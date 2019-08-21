package com.neu.t1.Service;

import com.neu.t1.component.Userdetails;
import com.neu.t1.dao.UserDao;
import com.neu.t1.po.User;
import com.neu.t1.util.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("loginService")
@Transactional
public class LoginServiceImpl implements LoginService{
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginService.class);
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDetailsService userDetailsService;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Override
    public String login(String username, String password, Integer type) {
        String token =null;
        //密码需要客户加密后传递
        try{
            Userdetails userdetails = (Userdetails) userDetailsService.loadUserByUsername(username);
            if(userdetails.getType()==type) {
//                if (!passwordEncoder.matches(password, userdetails.getPassword())) {
//                    throw new BadCredentialsException("密码不正确 "+password+"    "+userdetails.getPassword());
//                }
                if(!password.equals(userdetails.getPassword())){
                    throw new BadCredentialsException("密码不正确 "+password+"    "+userdetails.getPassword());
                }
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userdetails, null, userdetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                token = jwtTokenUtil.generateToken(userdetails);
                LOGGER.info(username + "  已经登陆");
            }
        }catch(AuthenticationException ex){
            LOGGER.warn("登录异常：{}",ex.getMessage());
        }
        return token;
    }

    @Override
    public String refreshToken(String token) {
        /*
        弊端只有超时的时候才内刷新
         */
        String newtoken = token.substring(tokenHead.length());
        if(jwtTokenUtil.canRefresh(newtoken)){
            return jwtTokenUtil.refreshToken(newtoken);
        }
        return null;
    }

    @Override
    public User getUserInfo(String username) {
        return null;
    }
}
