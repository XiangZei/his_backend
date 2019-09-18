package com.neu.t1.Service;

import com.neu.t1.po.User;

/**
 *登录服务类
 */
public interface LoginService {
    User getByUsername(String username);
    /**
     *登录
     */
    String login(String username,String password,Integer type);

    /**
     *刷新token
     */
    String refreshToken(String token);

    /**
     * 获取用户信息
     */
    User getUserInfo(String username);
}
