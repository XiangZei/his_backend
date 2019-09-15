package com.neu.t1.filter;

import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

public class ReferFilter extends FilterSecurityInterceptor {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest r = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;
        String refer = r.getHeader("Origin");
        boolean canaccess=true;
        if(refer==null){
                resp.setHeader("deny","Sorry,you don't have the right to access this page");
                resp.getWriter().println("Sorry,you don't have the right to access this page");
                canaccess=false;
        }else if(!refer.equals("http://localhost:8081")){
            resp.setHeader("deny","Sorry,you don't have the right to access this page");
            resp.getWriter().println("Sorry,you don't have the right to access this page");
            canaccess = false;
        }
        if(!canaccess){return;}
        filterChain.doFilter(request,response);
    }

}
