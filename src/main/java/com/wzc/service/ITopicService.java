package com.wzc.service;

import com.wzc.bean.Topic;
import com.wzc.bean.TopicExample;
import com.github.pagehelper.PageInfo;

public interface ITopicService  extends IBaseService<Topic,TopicExample,Integer>{



    PageInfo<Topic> pagequery(Integer pn, Integer ps, String keyword, String orderBy);

}
