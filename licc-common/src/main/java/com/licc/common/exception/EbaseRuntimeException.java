package com.licc.common.exception;


import com.licc.common.constance.CommonErrorCode;

/**
 * 系统运行时异常基类
 * Created by Jake on 1/17 0017.
 */
public class EbaseRuntimeException extends RuntimeException  {
    /**
     * 错误代码
     */
    private int errorCode = CommonErrorCode.UNKNOW;

    /**
     * 构造方法
     * @param message 提示
     * @param cause 源异常
     */
    public EbaseRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * 构造方法
     * @param errorCode 错误码
     * @param message 提示
     * @param cause 源异常
     */
    public EbaseRuntimeException(int errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    protected void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
