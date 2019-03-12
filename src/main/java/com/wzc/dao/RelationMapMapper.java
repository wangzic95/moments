package com.wzc.dao;

import com.wzc.bean.RelationMap;
import com.wzc.bean.RelationMapExample;
import org.apache.ibatis.annotations.Param;

public interface RelationMapMapper extends BaseMapper<RelationMap,RelationMapExample,Integer>{

    int cheackRelationIsExist(@Param("kid") Integer kid, @Param("vid") Integer vid, @Param("type") String type);
}