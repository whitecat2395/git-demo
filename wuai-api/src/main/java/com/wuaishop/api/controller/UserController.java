package com.wuaishop.api.controller;

import com.wuai.commons.entities.CommonResult;
import com.wuai.commons.entities.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(value = "用户接口")
public class UserController {
    private String uri="http://localhost:9527/";

    @ApiOperation(value = "查询全部用户接口")
    @GetMapping(value = "/wuai/user/queryAllUser")
    public CommonResult<List<User>> queryAllUser(){
        String url = uri+"/wuai/user"+"/queryAllUser";
        RestTemplate restTemplate =new RestTemplate();
        CommonResult commonResult = restTemplate.getForObject(url, CommonResult.class);
        return commonResult;
    }
    @ApiOperation(value = "查询单个用户接口")
    @GetMapping(value = "/wuai/user/queryUserById/{id}")
    public CommonResult<User> queryUserById(@PathVariable("id") String id){
        String url = uri+"/wuai/user"+"/queryUserById/{id}";
        RestTemplate restTemplate =new RestTemplate();
        Map<String,String> valuemap =new HashMap<>();
        valuemap.put("id",id);
        CommonResult commonResult = restTemplate.getForObject(url, CommonResult.class,valuemap);
        return commonResult;
    }
    @ApiOperation(value = "用户注册接口")
    @PostMapping(value = "/wuai/user/addUser")
    public CommonResult<User> addUser(@RequestBody User user){
        String url = uri+"/wuai/user"+"/addUser";
        RestTemplate restTemplate =new RestTemplate();
        CommonResult commonResult = restTemplate.postForObject(url,user,CommonResult.class);
        return commonResult;
    }
}

