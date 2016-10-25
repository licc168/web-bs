package com.licc.common.exception.handler;


import com.alibaba.fastjson.JSON;
import com.licc.common.exception.BusinessException;
import com.licc.common.util.ResultJsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 统一异常处理
 */

public class GlobalExceptionHandler implements HandlerExceptionResolver {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());


    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        LOG.error("访问" + request.getRequestURI() + " 发生错误, 错误信息:" + ex.getMessage());
        // 判断是否ajax请求
        if (!(request.getHeader("accept").indexOf("application/json") > -1 || (request
                .getHeader("X-Requested-With") != null && request.getHeader(
                "X-Requested-With").indexOf("XMLHttpRequest") > -1))) {
            // 如果不是ajax，JSP格式返回
            // 为安全起见，只有业务异常我们对前端可见，否则否则统一归为系统异常
            Map<String, Object> map = new HashMap<String, Object>(10);
            if (ex instanceof BusinessException) {
                map.put("errorMsg", ex.getMessage());
            } else {
                map.put("errorMsg", "系统异常！");
            }
            return new ModelAndView("/error", map);
        } else {
            // 如果是ajax请求，JSON格式返回
            try {
                response.setContentType("application/json;charset=UTF-8");
                PrintWriter writer = response.getWriter();
                if (ex instanceof BusinessException) {
                    writer.write(JSON.toJSONString(ResultJsonUtil.failResult(ex.getMessage())));
                } else {
                    writer.write("系统异常");
                }
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}