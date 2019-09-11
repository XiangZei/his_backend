package com.neu.t1.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 * JWT 登录授权过滤器
 * 对请求进行过滤
 *      1，从请求头部取出token
 *      2，利用JwtTokenUtil工具类 获取token中的用户名
 *      3，检查用户名是否为空，如果为空代表token被修改过，则不进行认证
 *      4，利用JwtTokenUtil工具类 检查token是否过期
 *      5，如果过期则不进行认证，如果未过期则将认证信息放进SpringSecurityContext 认证成功 用户正常进行请求
 */
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthenticationTokenFilter.class);
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException{
        String authHeader = request.getHeader(this.tokenHeader);
        if(authHeader!=null&&authHeader.startsWith(this.tokenHead)){
            String authToken = authHeader.substring(this.tokenHead.length()); //获取token
            String username = jwtTokenUtil.getUserNameFromToken(authToken); // 利用算法将用户名从token中取出来
            LOGGER.info("开始验证信息");
            LOGGER.info("checking username:{}",username);
            if(username!=null){
                Userdetails userDetails = (Userdetails) this.userDetailsService.loadUserByUsername(username);
                if(jwtTokenUtil.isTokenExpired(authToken)){ //通过用户名和token是否超时进行验证
                    System.out.println("用户信息验证成功");
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    LOGGER.info("authenticated user:{}",username);
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
        }
        chain.doFilter(request,response);

    }
}

