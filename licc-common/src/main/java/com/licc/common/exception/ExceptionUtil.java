package com.licc.common.exception;

/**
 * 异常工具类
 * Created by Administrator on 2016-1-29.
 */
public class ExceptionUtil {



    /**
     * 抛出业务异常
     */
    public static void throwBusinessException(int errorCode, String message) {
        BusinessException.throwIt(errorCode, message);
    }

    /**
     * 抛出业务异常
     */
    public static void throwBusinessException(int errorCode, String message, Throwable cause) {
        BusinessException.throwIt(errorCode, message, cause);
    }

}
