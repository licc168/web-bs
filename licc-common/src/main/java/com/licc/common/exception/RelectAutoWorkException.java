package com.licc.common.exception;

import com.licc.common.constance.CommonErrorCode;


/**
 * 转化处理异常
 * Created by lichangchao
 */
public class RelectAutoWorkException extends EbaseRuntimeException {

    /**
     * 构造方法
     * @param message 提示消息
     * @param cause 源异常
     */
    public RelectAutoWorkException(String message, Throwable cause) {
        super(CommonErrorCode.REFLECT_WORK_EXCEPTION, message, cause);
    }

}
