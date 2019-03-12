package com.wzc.service;

import com.wzc.bean.Message;
import com.wzc.bean.MessageExample;

import java.util.List;

public interface IMessageService extends IBaseService<Message,MessageExample,Integer>{

    List<Message> selectByUserId(Integer userid);

}
