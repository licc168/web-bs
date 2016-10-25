package com.licc.common.util;

/**
 * @author  lichangchao
 * @功能 返回json格式数据
 */
public class ResultJson {
      private int code;
      private String msg;
      private  Object data;
    public ResultJson(int code,String msg){
        this.code = code;
        this.msg = msg;
    }
    public ResultJson(int resultCode,String message,Object b ){
        this.code = resultCode;
        this.msg = message;
        this.data = b;
    }
    public  ResultJson(int resultCode,Object b){
        this.code =resultCode;
        this.data = b;
    }
    public int getResultCode() {
        return code;
    }

    public void setResultCode(int resultCode) {
        this.code = resultCode;
    }

    public String getMessage() {
        return msg;
    }

    public void setMessage(String message) {
        this.msg = message;
    }

    public Object getB() {
        return data;
    }

    public void setB(Object b) {
        this.data = b;
    }
}
