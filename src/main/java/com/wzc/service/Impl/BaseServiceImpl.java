package com.wzc.service.Impl;

import com.wzc.dao.BaseMapper;
import com.wzc.service.IBaseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.List;

public abstract class BaseServiceImpl<T,E, PK extends Serializable> implements IBaseService<T,E,PK>{

    private BaseMapper<T,E,PK> mapper;

    public void setBaseMapper(BaseMapper<T,E,PK> mapper) {
        this.mapper = mapper;
    }

    @Override
    public boolean insert(T record) {
        return mapper.insert(record)>0;
    }

    @Override
    public boolean deleteByPrimaryKey(PK id) {
        return mapper.deleteByPrimaryKey(id)>0;
    }

    @Override
    public boolean updateByPrimaryKey(T record) {
        return mapper.updateByPrimaryKey(record)>0;
    }

    @Override
    public T selectByPrimaryKey(PK id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<T> selectAll() {
        return mapper.selectByExample(null);
    }

    @Override
    public PageInfo<T> queryByPage(Integer pn, Integer ps,E example) {
        PageHelper.startPage(pn,ps);
        return new PageInfo<>(mapper.selectByExample(example));
    }

    @Override
    public boolean updateByPrimaryKeySelective(T record) {
        return mapper.updateByPrimaryKeySelective(record)>0;
    }

    @Override
    public int deleteByExample(E example) {
        return mapper.deleteByExample(example);
    }

    @Override
    public int updateByExampleSelective(T record, E example) {
        return mapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(T record, E example) {
        return mapper.updateByExample(record,example);
    }

    @Override
    public int countByExample(E example) {
        return mapper.countByExample(example);
    }

    @Override
    public List<T> selectByExample(E example) {
        return mapper.selectByExample(example);
    }
}
