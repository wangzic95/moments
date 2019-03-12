package com.wzc.service.Impl;

import com.wzc.bean.User;
import com.wzc.bean.UserExample;
import com.wzc.dao.UserMapper;
import com.wzc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends BaseServiceImpl<User,UserExample,Integer> implements IUserService {

    @Autowired
    private UserMapper mapper;

    @Autowired
    public void setBaseMapper(){
        super.setBaseMapper(mapper);
    }

    @Override
    public User loginByEmail(String email) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andEmailEqualTo(email);
        List<User> list = mapper.selectByExample(example);
        if(list!=null&&list.size()>0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public boolean checkUsernameIsExist(String username) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<User> list = mapper.selectByExample(example);
        if(list!=null&&list.size()>0){
            return false;
        }
        return true;
    }

    @Override
    public boolean checkEmailIsExist(String email) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andEmailEqualTo(email);
        List<User> list = mapper.selectByExample(example);
        if(list!=null&&list.size()>0){
            return false;
        }
        return true;
    }

    @Override
    public List<User> selectFriendsByUserId(Integer userid) {
        return mapper.selectByIdAndType(userid,"friend");
    }

    @Override
    public List<User> selectMembersByCircleId(Integer circleid) {
        return mapper.selectByIdAndType(circleid,"circle");
    }

}
