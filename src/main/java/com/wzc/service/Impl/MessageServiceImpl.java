package com.wzc.service.Impl;

import com.wzc.bean.Message;
import com.wzc.bean.MessageExample;
import com.wzc.dao.MessageMapper;
import com.wzc.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl extends BaseServiceImpl<Message,MessageExample,Integer> implements IMessageService {

    @Autowired
    public MessageMapper mapper;

    @Autowired
    public void setBaseMapper(){
        super.setBaseMapper(mapper);
    }

    @Override
    public List<Message> selectByUserId(Integer userid) {
        return mapper.selectByUserId(userid);
    }
}
