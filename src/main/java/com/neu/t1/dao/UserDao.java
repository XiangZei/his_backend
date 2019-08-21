package com.neu.t1.dao;

import com.neu.t1.po.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    User getByUsername(@Param("username") String username);
}
