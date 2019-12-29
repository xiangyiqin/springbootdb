package com.lala.springbootdb.common.vo;

import java.io.Serializable;
import java.security.PrivateKey;

public class JsonResult implements Serializable {
    private int state=1;
    private String message="ok";
    private Object data;
    public JsonResult(){};
    public JsonResult(String msg){
        this.message=msg;
    }
    public JsonResult(Object data){
        this.data=data;
    }
    public JsonResult(Throwable t){
        this.state=0;
        this.message=t.getMessage();
    }
    public JsonResult(String msg,int state){
        this.message=msg;
        this.state=state;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
