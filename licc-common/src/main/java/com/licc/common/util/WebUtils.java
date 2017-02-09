package com.licc.common.util;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lichangchao
 * @Time 2017/01/21
 */
public class WebUtils {
    static Logger logger = Logger.getLogger(WebUtils.class);

    public static void responseJson(HttpServletResponse response, ResultJson resultJson) {
        try {
            String result = JSON.toJSONString(resultJson);
            response.getOutputStream().write(result.getBytes("UTF-8"));
            response.getOutputStream().flush();
        } catch (Exception e) {
            logger.error("返回值异常", e);
        } finally {
            try {
                response.getOutputStream().close();
            } catch (IOException e) {
                logger.error("写流关闭失败", e);
            }
        }
    }
}
