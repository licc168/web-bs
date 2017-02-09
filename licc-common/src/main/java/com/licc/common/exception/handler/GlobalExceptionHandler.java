package com.licc.common.exception.handler;


import com.licc.common.exception.BusinessException;
import com.licc.common.util.ResultJson;
import com.licc.common.util.ResultJsonUtil;
import com.licc.common.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import sun.nio.cs.ext.DoubleByte;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 统一异常处理
 */

public class GlobalExceptionHandler implements HandlerExceptionResolver {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());


    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
            if(ex instanceof BusinessException){
            ResultJsonUtil.failResult(ex.getMessage());
            WebUtils.responseJson(response,ResultJsonUtil.failResult(ex.getMessage()));
        }else {
            WebUtils.responseJson(response,ResultJsonUtil.failResult("系统异常"));
        }

        return null;
    }




}