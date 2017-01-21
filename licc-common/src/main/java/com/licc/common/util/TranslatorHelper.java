package com.licc.common.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取国际化信息
 */
public class TranslatorHelper {
   public static String get(String key,String ...args){
       ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
       if(requestAttributes==null){
           return  key;
       }
       HttpServletRequest request = requestAttributes.getRequest();
       if(request==null){
           return  key;
       }
       RequestContext requestContext =  new RequestContext(request);
        return requestContext.getMessage(key,args);
   }

   public  static  String get(String key){
       return  TranslatorHelper.get(key,new String[0]);
   }
}
