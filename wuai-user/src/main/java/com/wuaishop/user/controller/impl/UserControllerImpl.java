package com.wuaishop.user.controller.impl;

import com.wuai.commons.entities.CommonResult;
import com.wuaishop.user.controller.service.UserController;
import com.wuaishop.user.persist.po.User;
import com.wuaishop.user.service.UserService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
public class UserControllerImpl implements UserController {

    @Resource
    private UserService userService;

    @Override
    public CommonResult<List<User>> queryAllUser(){
        List<User> userList = userService.queryAllUser();
        for(User user:userList){
            System.out.println(user.getId());
        }
        return new CommonResult<>(200,"查询成功",userList);
    }

    @Override
    public CommonResult<User> queryUserById(@PathVariable(value = "id")  String id){
        System.out.println(id);
        User user = userService.queryUserById(id);
        if(user==null){
            return new CommonResult<>(400,"查询失败",null);
        }else{
            return new CommonResult<>(200,"查询成功",user);
        }
    }

    @Override
    public CommonResult<User> updateOneUser() {
        return null;
    }
}
