package com.wuaishop.user.service;

import com.wuaishop.user.persist.mapper.UserMapper;
import com.wuaishop.user.persist.po.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    public List<User> queryAllUser() {
        return userMapper.queryAllUser();
    }

    public User queryUserById(String id) {
        User user = userMapper.queryUserById(id);
        return user;
    }
}
