package com.wuaishop.user.controller.service;

import com.wuai.commons.entities.CommonResult;
import com.wuaishop.user.persist.po.User;
import com.wuaishop.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Api(value = "用户服务接口")
@RequestMapping(value = "/user")
public interface UserController {

    @ApiOperation(value = "用户全部查询接口")
    @GetMapping(value = "/queryAllUser")
    public CommonResult<List<User>> queryAllUser();

    @ApiOperation(value = "单一用户查询接口")
    @RequestMapping(value = "/queryUserById/{id}")
    public CommonResult<User> queryUserById(@PathVariable(value = "id")  String id);

    @ApiOperation(value = "编辑用户接口")
    @GetMapping(value = "/updateOneUser")
    public CommonResult<User> updateOneUser();
}
