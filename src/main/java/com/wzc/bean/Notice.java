package com.wzc.bean;

import java.util.Date;

public class Notice {
    private Integer id;

    private String noticeTitle;

    private Integer noticeUserid;

    private String noticeUsername;

    private String noticeType;

    private Integer noticeFileid;

    private Date createtime;

    private String noticeBody;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle == null ? null : noticeTitle.trim();
    }

    public Integer getNoticeUserid() {
        return noticeUserid;
    }

    public void setNoticeUserid(Integer noticeUserid) {
        this.noticeUserid = noticeUserid;
    }

    public String getNoticeUsername() {
        return noticeUsername;
    }

    public void setNoticeUsername(String noticeUsername) {
        this.noticeUsername = noticeUsername == null ? null : noticeUsername.trim();
    }

    public String getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(String noticeType) {
        this.noticeType = noticeType == null ? null : noticeType.trim();
    }

    public Integer getNoticeFileid() {
        return noticeFileid;
    }

    public void setNoticeFileid(Integer noticeFileid) {
        this.noticeFileid = noticeFileid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getNoticeBody() {
        return noticeBody;
    }

    public void setNoticeBody(String noticeBody) {
        this.noticeBody = noticeBody == null ? null : noticeBody.trim();
    }
}