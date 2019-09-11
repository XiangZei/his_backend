package com.neu.t1.dao;

import com.neu.t1.po.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {

    /**
     * 根据用户名获取用户实体
     */
    User getByUsername(@Param("username") String username);
}
