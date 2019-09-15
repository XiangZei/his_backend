package com.neu.t1.util;

import com.neu.t1.po.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

/**
 * 将用户信息继承自UserDetails，目的是在进行验证的时候可以将提取出来的用户信息放入SpringSecutity所维护的上下文中。
 * 这样一来就可以成功进行对用户信息的验证和存储，以达到相关api权限的管理。
 */
public class Userdetails implements UserDetails {
    private User user;
    public Userdetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //返回当前用户的权限
        return Arrays.asList(new SimpleGrantedAuthority("TEST"));
    }

    public int getType(){
        return user.getUserType();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public User getUser(){
        return user;
    }
}
