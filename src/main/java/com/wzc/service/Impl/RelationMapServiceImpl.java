package com.wzc.service.Impl;

import com.wzc.bean.RelationMap;
import com.wzc.bean.RelationMapExample;
import com.wzc.dao.RelationMapMapper;
import com.wzc.service.IRelationMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RelationMapServiceImpl extends BaseServiceImpl<RelationMap,RelationMapExample,Integer> implements IRelationMapService {

    @Autowired
    public RelationMapMapper mapper;

    @Autowired
    public void setBaseMapper(){
        super.setBaseMapper(mapper);
    }

    @Override
    public int cheackRelationIsExist(Integer kid, Integer vid, String type) {
        return mapper.cheackRelationIsExist(kid,vid,type);
    }
}
