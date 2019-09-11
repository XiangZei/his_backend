package com.neu.t1.Service;

import com.neu.t1.po.User;

public interface UserService {

    /**
     * 根据用户名获取用户
     */
    User getByUsername(String username);
}
