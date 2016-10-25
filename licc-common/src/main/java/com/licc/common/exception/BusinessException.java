package com.licc.common.exception;

/**
 * 业务异常
 * Created by Jake on 1/24 0024.
 */
public class BusinessException extends EbaseRuntimeException {

    /**
     * 构造方法
     * @param message 提示
     * @param cause 源异常
     */
    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * 构造方法
     * @param errorCode 错误码
     * @param message 提示
     * @param cause 源异常
     */
    public BusinessException(int errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    /**
     * 抛出业务异常
     * @param errorCode 错误码
     * @param message 提示
     * @throws BusinessException
     */
    public static void throwIt(int errorCode, String message) throws BusinessException {
        throw new BusinessException(errorCode, message, null);
    }

    /**
     * 抛出业务异常
     * @param errorCode 错误码
     * @param message 提示
     * @param cause 源异常
     * @throws BusinessException
     */
    public static void throwIt(int errorCode, String message, Throwable cause) throws BusinessException {
        throw new BusinessException(errorCode, message, cause);
    }

}
