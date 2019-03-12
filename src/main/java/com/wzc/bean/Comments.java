package com.wzc.bean;

import java.util.Date;

public class Comments {
    private Integer id;

    private Integer commentUserid;

    private String commentUsername;

    private String commentBody;

    private Integer commentAnnid;

    private Integer commentTargetid;

    private String commentTargetname;

    private Date createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCommentUserid() {
        return commentUserid;
    }

    public void setCommentUserid(Integer commentUserid) {
        this.commentUserid = commentUserid;
    }

    public String getCommentUsername() {
        return commentUsername;
    }

    public void setCommentUsername(String commentUsername) {
        this.commentUsername = commentUsername == null ? null : commentUsername.trim();
    }

    public String getCommentBody() {
        return commentBody;
    }

    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody == null ? null : commentBody.trim();
    }

    public Integer getCommentAnnid() {
        return commentAnnid;
    }

    public void setCommentAnnid(Integer commentAnnid) {
        this.commentAnnid = commentAnnid;
    }

    public Integer getCommentTargetid() {
        return commentTargetid;
    }

    public void setCommentTargetid(Integer commentTargetid) {
        this.commentTargetid = commentTargetid;
    }

    public String getCommentTargetname() {
        return commentTargetname;
    }

    public void setCommentTargetname(String commentTargetname) {
        this.commentTargetname = commentTargetname == null ? null : commentTargetname.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}