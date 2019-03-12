package com.wzc.service.Impl;

import com.wzc.bean.UploadFile;
import com.wzc.bean.UploadFileExample;
import com.wzc.dao.UploadFileMapper;
import com.wzc.service.IUploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UploadFileServiceImpl extends BaseServiceImpl<UploadFile,UploadFileExample,Integer> implements IUploadFileService {
    @Autowired
    public UploadFileMapper mapper;

    @Autowired
    public void setBaseMapper(){
        super.setBaseMapper(mapper);
    }
}
