package com.wuaishop.user.controller.impl;

import com.wuai.commons.entities.CommonResult;
import com.wuaishop.user.controller.service.UserController;
import com.wuaishop.user.persist.po.User;
import com.wuaishop.user.service.UserService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class UserControllerImpl implements UserController {
    private UserService userService;

    @Override
    public CommonResult<List<User>> queryAllUser(){
        List<User> list = userService.queryAllUser();
        CommonResult<List<User>> commonResult =new CommonResult<>(200,"查询成功",list);
        return commonResult;
    }
    @Override
    public CommonResult<User> queryUserById(@PathVariable  String id){
        User user =userService.queryUserById(id);
        CommonResult<User> commonResult =new CommonResult<>(200,"查询成功",user);
        return commonResult;
    }

    @Override
    public CommonResult<User> updateOneUser() {
        return null;
    }
}
