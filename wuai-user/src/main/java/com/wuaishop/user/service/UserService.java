package com.wuaishop.user.service;

import com.wuaishop.user.persist.mapper.UserMapper;
import com.wuaishop.user.persist.po.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserMapper userMapper;

    public List<User> queryAllUser() {
        List<User> userList =userMapper.queryAllUser();
        return userList;
    }

    public User queryUserById(String id) {
        User user = userMapper.queryUserById(id);
        return user;
    }
}
