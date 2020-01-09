package com.lala.springbootdb.shiro;

import com.lala.springbootdb.dao.UsersDao;
import com.lala.springbootdb.pojo.Users;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UsersDao usersDao;
    /**
     * 设置凭证匹配器(与用户添加操作使用相同的加密算法)
     */

    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        //构建凭证匹配对象
        HashedCredentialsMatcher cMatcher=
                new HashedCredentialsMatcher();
        //设置加密算法
        cMatcher.setHashAlgorithmName("MD5");
        //设置加密次数
        cMatcher.setHashIterations(1);
        super.setCredentialsMatcher(cMatcher);

    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //1.获取用户名(用户页面输入)
        UsernamePasswordToken upToken=
                (UsernamePasswordToken)token;
        String username=upToken.getUsername();
        //2.基于用户名查询用户信息
        Users user= usersDao.findByUserName(username);
        //3.判定用户是否存在
        if(user==null)
            throw new UnknownAccountException();
        //4.判定用户是否已被禁用。
        if(user.getValid()==0)
            throw new LockedAccountException();
        //5.封装用户信息
        ByteSource credentialsSalt=
                ByteSource.Util.bytes(user.getSalt());

        System.out.println("执行认证逻辑");
        SimpleAuthenticationInfo info=
                new SimpleAuthenticationInfo(
                        user,//principal (身份)
                        user.getPassword(),//hashedCredentials
                        credentialsSalt, //credentialsSalt
                        getName());//realName
        //6.返回封装结果
        return info;//返回值会传递给认证管理器(后续
        //认证管理器会通过此信息完成认证操作)

    }
}
