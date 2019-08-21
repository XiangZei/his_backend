package com.neu.t1.Service;

import com.neu.t1.dao.UserDao;
import com.neu.t1.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    public User getByUsername(String username){
        User user =userDao.getByUsername(username);
        return user;
    }
}

