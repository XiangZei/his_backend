package com.neu.t1.Service;

import com.neu.t1.po.User;

public interface UserService {
    User getByUsername(String username);
}
