package com.neu.t1.Service;

import com.neu.t1.po.User;

public interface LoginService {
    String login(String username,String password,Integer type);
    String refreshToken(String token);

    User getUserInfo(String username);
}
