package com.licc.common.util;

/**
 * @author  lichangchao
 * @version 0.1
 * @功能   转化工具 如 5={1,4}  7={1,2,4}  用于数据库int存储多值得情况
 */
public class BinaryeTranslateUtil {
    /**
     * 十进制转化为数组
     * @param ind
     * @return
     */
    public static int[] intToIntegerList(int ind) {
        if (ind < 0) {
            throw new IllegalArgumentException("参数异常");
        }
        int[] array = new int[Integer.bitCount(ind)];
        int count = 0;
        for (int i = 1; i > 0 && count < array.length; i <<= 1) {
            if ((ind & i) != 0) {
                array[count++] = i;
            }
        }
        return array;
    }

}
