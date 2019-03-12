package com.wzc.dao;

import com.wzc.bean.Circle;
import com.wzc.bean.CircleExample;

import java.util.List;

public interface CircleMapper extends BaseMapper<Circle,CircleExample,Integer>{

    List<Circle> selectByUserId(Integer userid);
}