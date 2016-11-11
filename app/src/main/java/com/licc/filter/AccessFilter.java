package com.licc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

public class AccessFilter extends HttpServlet implements Filter {
      
    /** 
     * 序列ID，用来监测控制版本更新的 
     */  
    private static final long serialVersionUID = 1L;  
      


  
    @Override  
    public void init(FilterConfig filterConfig) throws ServletException {                 
    }  
  
    //设置其他IP地址的机器可以直接访问到这个项目的后端  
    @Override  
    public void doFilter(ServletRequest request, ServletResponse response,  
            FilterChain chain) throws IOException, ServletException {  
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpResponse.setHeader("Access-Control-Allow-Methods","GET, POST, OPTIONS");
        httpResponse.setHeader("Access-Control-Allow-Headers","DNT,X-CustomHeader,Keep-Alive,User-Agent,X-Requested-With,If-Modified-Since,Cache-Control,Content-Type");
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");  
        chain.doFilter(request, httpResponse);  
                  
    }  
  
}  