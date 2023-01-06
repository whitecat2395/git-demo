package com.wuaishop.user.persist.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.naming.factory.SendMailFactory;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class User {
    private String id;
    private String userName;
    private String passWord;
    private int roleId;
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
