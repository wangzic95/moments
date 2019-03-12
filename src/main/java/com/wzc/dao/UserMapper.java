package com.wzc.dao;

import com.wzc.bean.User;
import com.wzc.bean.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends BaseMapper<User,UserExample,Integer>{

    List<User> selectByIdAndType(@Param("userid") Integer userid, @Param("type") String type);
}