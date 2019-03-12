package com.wzc.service;

import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

public interface IBaseService<T,E,PK extends Serializable>  {


    boolean insert(T record);

    boolean deleteByPrimaryKey(PK id);

    boolean updateByPrimaryKey(T record);

    T selectByPrimaryKey(PK id);

    List<T> selectAll();

    List<T> selectByExample(E example);

    PageInfo<T> queryByPage(Integer pn, Integer ps, E example);

    boolean updateByPrimaryKeySelective(T record);

    int deleteByExample(E example);

    int updateByExampleSelective(@Param("record") T record, @Param("example") E example);

    int updateByExample(@Param("record") T record, @Param("example") E example);

    int countByExample(E example);

}
