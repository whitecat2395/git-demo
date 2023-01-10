package com.wuaishop.user.controller.impl;

import com.wuai.commons.entities.CommonResult;
import com.wuaishop.user.controller.request.UserRequest;
import com.wuaishop.user.controller.service.UserController;
import com.wuaishop.user.persist.po.User;
import com.wuaishop.user.service.UserService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
public class UserControllerImpl implements UserController {

    @Resource
    private UserService userService;

    @Override
    public CommonResult<List<User>> queryAllUser(){
        List<User> userList = userService.queryAllUser();
        System.out.println("查询成功");
        for(User user:userList){
            System.out.println(" "+user.getId()+" "+user.getUserName());
        }
        return new CommonResult<>(200,"查询成功",userList);
    }

    @Override
    public CommonResult<User> queryUserById(@PathVariable(value = "id")  String id) {
        User user = userService.queryUserById(id);
        if (user == null) {
            System.out.println("查询"+id+"失败");
            return new CommonResult<>(400, "查询失败", null);
        } else {
            System.out.println("查询"+id+"成功");
            return new CommonResult<>(200, "查询成功", user);
        }
    }

    @Override
    public CommonResult<User> updateOneUser() {
        return null;
    }

    @Override
    public CommonResult addUser(@RequestBody UserRequest userRequest) {
        User user = new User();
        System.out.println(userRequest.getUserName());
        BeanUtils.copyProperties(userRequest,user);
        String id = UUID.randomUUID().toString();
        user.setId(id);
        //角色id 0为游客用户 1为普通用户
        user.setRoleId(1);
        int result = userService.addUser(user);
        System.out.println("addUser结果："+result);
        if (result== 1 ) {
            return new CommonResult<>(200, "注册成功", null);
        } else {
            return new CommonResult<>(400, "注册失败",null);
        }
    }
}
