package com.wuaishop.user.persist.mapper;

import com.wuaishop.user.persist.po.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> queryAllUser();

    User queryUserById(String id);

    int insertUser(User user);

}
