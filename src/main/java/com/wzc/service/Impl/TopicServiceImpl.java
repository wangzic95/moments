package com.wzc.service.Impl;

import com.wzc.bean.Topic;
import com.wzc.bean.TopicExample;
import com.wzc.dao.TopicMapper;
import com.wzc.service.ITopicService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicServiceImpl extends BaseServiceImpl<Topic,TopicExample,Integer> implements ITopicService {

    @Autowired
    private TopicMapper mapper;

    @Autowired
    public void setBaseMapper(){
        super.setBaseMapper(mapper);
    }

    @Override
    public PageInfo<Topic> pagequery(Integer pn, Integer ps,String keyword,String orderBy) {
        PageHelper.startPage(pn,ps);
        TopicExample example = new TopicExample();
        if(StringUtils.isNotBlank(keyword)){
            TopicExample.Criteria criteria =example.createCriteria();
            criteria.andTitleLike("%"+keyword+"%");
            TopicExample.Criteria criteria2 =example.createCriteria();
            criteria2.andUsernameLike("%"+keyword+"%");
            example.or(criteria2);
        }
        example.setOrderByClause(" "+orderBy+" desc,title asc ");
        return new PageInfo<>(mapper.selectByExample(example));
    }
}
