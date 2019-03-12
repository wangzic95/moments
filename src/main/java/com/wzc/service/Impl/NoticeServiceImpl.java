package com.wzc.service.Impl;

import com.wzc.bean.Notice;
import com.wzc.bean.NoticeExample;
import com.wzc.dao.NoticeMapper;
import com.wzc.service.INoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeServiceImpl extends BaseServiceImpl<Notice,NoticeExample,Integer> implements INoticeService {


    @Autowired
    public NoticeMapper mapper;

    @Autowired
    public void setBaseMapper(){
        super.setBaseMapper(mapper);
    }
}
