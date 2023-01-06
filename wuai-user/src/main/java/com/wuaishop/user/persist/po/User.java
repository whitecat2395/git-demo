package com.wuaishop.user.persist.po;

import lombok.Data;
import org.apache.naming.factory.SendMailFactory;

@Data
public class User {
    private String id;
    private String userName;
    private String passWord;
    private int roleId;
    private String nickName;
    private String email;
    private String phone;
    private String freeze;
    private String deptId;
    private String remark;
    private String insertTime;
}
