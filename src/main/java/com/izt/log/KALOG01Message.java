package com.izt.log;

public class KALOG01Message {
    private String msg;
    private String token;

    public String getMsg(){
        return msg;
    }
    
    public String getToken(){
        return token;
    }

    public void setToken(String token){
        this.token = token;
    }

      public void setMsg(String msg){
        this.msg = msg;
    }
}