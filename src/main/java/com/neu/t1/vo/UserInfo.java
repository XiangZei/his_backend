package com.neu.t1.vo;

import lombok.Data;

/**
 *用户信息
 */
@Data
public class UserInfo {

    /**
     *用户名
     */
    private String username;

    /**
     *密码
     */
    private String password;

    /**
     *用户类型
     */
    private Integer type;
}
