package com.lala.springbootdb.controller;

import com.lala.springbootdb.common.vo.JsonResult;
import com.lala.springbootdb.common.vo.Node;
import com.lala.springbootdb.pojo.Menus;
import com.lala.springbootdb.service.MenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenusService menusService;
   /* @RequestMapping("/menu_list")
    public String doMenuList(){
        return "sys/menu_list";
    }*/
    @RequestMapping("doFindObjects")
    @ResponseBody
    public JsonResult doFindObjects(){
        List<Menus> menus = menusService.selectAll();
        return new JsonResult(menus);
    }
    @RequestMapping("doDeleteObject")
    @ResponseBody
    public JsonResult doDeleteObject(Integer id){
        int parentId=menusService.selectParent(id);
        if(parentId>0){

            return new JsonResult("删除子类1",0);

        }else {
            int row = menusService.deleteObject(id);
            return new JsonResult("delete OK");
        }
    }
    @RequestMapping("{moudle}")
    public String doin(@PathVariable String moudle){
        return "sys/"+moudle;
    }
    @RequestMapping("doSaveObject")
    @ResponseBody
    public JsonResult doSaveObject(Menus menus){
        
        int i = menusService.insertObject(menus);
        	if(i>0){
	return new JsonResult("增加成功");

}else{
return new JsonResult("增加失败");
}

    }
    @RequestMapping("doFindZtreeMenuNodes")
    @ResponseBody
    public JsonResult doFindZtreeMenuNodes(){
        List<Node> nodes=menusService.doFindZtreeMenuNodes();
        System.out.println(nodes);
        return new JsonResult(nodes);
    }
}
