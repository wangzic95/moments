package com.wzc.service.Impl;

import com.wzc.bean.Circle;
import com.wzc.bean.CircleExample;
import com.wzc.dao.CircleMapper;
import com.wzc.service.ICircleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CircleServiceImpl extends BaseServiceImpl<Circle,CircleExample,Integer> implements ICircleService {

    @Autowired
    public CircleMapper mapper;

    @Autowired
    public void setBaseMapper(){
        super.setBaseMapper(mapper);
    }

    @Override
    public List<Circle> selectByUserId(Integer userid) {
        return mapper.selectByUserId(userid);
    }
}
