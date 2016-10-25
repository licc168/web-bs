package com.licc.common.constance;

/**
 * 通用错误码
 * Created by Jake on 1/24 0024.
 */
public interface CommonErrorCode {

    /**
     * 未知错误码
     */
    int UNKNOW = -1;

    /**
     * 对象转化处理异常
     */
    int REFLECT_WORK_EXCEPTION = -2;

    /**
     * 参数异常
     */
    int ILLEGAL_ARGUMENT = -3;

    /**
     * 数据权限异常
     */
    int DATA_SECURE = -4;

}
