package com.wuaishop.api.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class UserRequest {
    private String userName;
    private String passWord;
    private String nickName;
    private String email;
    private String phone;
    private int freeze;
    private int deptId;
    private String remark;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date insertTime;
}
