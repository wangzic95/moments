package com.wzc.dao;

import com.wzc.bean.Message;
import com.wzc.bean.MessageExample;

import java.util.List;

public interface MessageMapper  extends BaseMapper<Message,MessageExample,Integer>{

    List<Message> selectByUserId(Integer userid);
}