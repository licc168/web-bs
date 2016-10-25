package com.licc.common.aop;

import com.licc.common.util.ResultJsonUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;

/**
 * 参数验证处理类
 * @author lichangchao
 */
public class BindingResultAop {


    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.licc.web.*.*(..))")
    public void aopMethod() {
    }


    @Around("aopMethod()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        LOG.info("before method invoking!");
        BindingResult bindingResult = null;
        for (Object arg : joinPoint.getArgs()) {
            if (arg instanceof BindingResult) {
                bindingResult = (BindingResult) arg;
            }
        }
        if (bindingResult != null) {
            if (bindingResult.hasErrors()) {
                String errorInfo = "[" + bindingResult.getFieldError().getField() + "]" + bindingResult.getFieldError().getDefaultMessage();
                return  ResultJsonUtil.failResult(errorInfo);
            }
        }
        return joinPoint.proceed();
    }
}