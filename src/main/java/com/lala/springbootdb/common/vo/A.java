package com.lala.springbootdb.common.vo;

public class A {
    public static A a=new A();
    private A(){}
    public static A b(){
        return a;
    }
}
