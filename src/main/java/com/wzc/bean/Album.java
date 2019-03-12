package com.wzc.bean;

import java.util.Date;

public class Album {
    private Integer id;

    private String albumName;

    private String albumCover;

    private Integer albumUserid;

    private Date createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName == null ? null : albumName.trim();
    }

    public String getAlbumCover() {
        return albumCover;
    }

    public void setAlbumCover(String albumCover) {
        this.albumCover = albumCover == null ? null : albumCover.trim();
    }

    public Integer getAlbumUserid() {
        return albumUserid;
    }

    public void setAlbumUserid(Integer albumUserid) {
        this.albumUserid = albumUserid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}