package com.wuaishop.api.controller;

import com.wuai.commons.entities.CommonResult;
import com.wuai.commons.entities.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    @GetMapping(value = "/wuai/user/queryUserById")
    public CommonResult<User> queryUserById(){
        String url = uri+"/wuai/user"+"/queryUserById/{id}";
        RestTemplate restTemplate =new RestTemplate();
        Map<String,String> valuemap =new HashMap<>();
        valuemap.put("id","1");
        CommonResult commonResult = restTemplate.getForObject(url, CommonResult.class,valuemap);
        return commonResult;
    }
}

