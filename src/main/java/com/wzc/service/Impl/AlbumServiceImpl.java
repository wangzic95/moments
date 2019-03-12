package com.wzc.service.Impl;

import com.wzc.bean.Album;
import com.wzc.bean.AlbumExample;
import com.wzc.dao.AlbumMapper;
import com.wzc.service.IAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumServiceImpl extends BaseServiceImpl<Album,AlbumExample,Integer> implements IAlbumService {

    @Autowired
    public AlbumMapper mapper;

    @Autowired
    public void setBaseMapper(){
        super.setBaseMapper(mapper);
    }
}
