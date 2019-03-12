package com.wzc.service;

import com.wzc.bean.RelationMap;
import com.wzc.bean.RelationMapExample;

public interface IRelationMapService extends IBaseService<RelationMap,RelationMapExample,Integer>{

    int cheackRelationIsExist(Integer kid, Integer vid, String type);
}
