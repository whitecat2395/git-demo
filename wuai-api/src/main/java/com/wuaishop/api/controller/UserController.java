package com.wuaishop.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "用户接口")
public class UserController {
    @ApiOperation(value = "查询全部用户接口")
    @GetMapping(value = "/user/queryAllUser")
    public String queryAllUser(){
        return "queryAllUser is OK";
    }
}

