package com.wzc.service;

import com.wzc.bean.User;
import com.wzc.bean.UserExample;

import java.util.List;

public interface IUserService extends IBaseService<User,UserExample,Integer>{

    User loginByEmail(String email);

    boolean checkUsernameIsExist(String username);

    boolean checkEmailIsExist(String email);

    List<User> selectFriendsByUserId(Integer userid);

    List<User> selectMembersByCircleId(Integer circleid);

}
