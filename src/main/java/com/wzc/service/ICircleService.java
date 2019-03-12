package com.wzc.service;

import com.wzc.bean.*;

import java.util.List;

public interface ICircleService extends IBaseService<Circle,CircleExample,Integer>{

    List<Circle> selectByUserId(Integer userid);
}
