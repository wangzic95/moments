package com.wzc.bean;

import java.util.Date;

public class Circle {
    private Integer id;

    private String circleName;

    private Integer circleUserid;

    private String circleUsername;

    private String circleDescription;

    private String circlePhoto;

    private String circleState;

    private Date createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCircleName() {
        return circleName;
    }

    public void setCircleName(String circleName) {
        this.circleName = circleName == null ? null : circleName.trim();
    }

    public Integer getCircleUserid() {
        return circleUserid;
    }

    public void setCircleUserid(Integer circleUserid) {
        this.circleUserid = circleUserid;
    }

    public String getCircleUsername() {
        return circleUsername;
    }

    public void setCircleUsername(String circleUsername) {
        this.circleUsername = circleUsername == null ? null : circleUsername.trim();
    }

    public String getCircleDescription() {
        return circleDescription;
    }

    public void setCircleDescription(String circleDescription) {
        this.circleDescription = circleDescription == null ? null : circleDescription.trim();
    }

    public String getCirclePhoto() {
        return circlePhoto;
    }

    public void setCirclePhoto(String circlePhoto) {
        this.circlePhoto = circlePhoto == null ? null : circlePhoto.trim();
    }

    public String getCircleState() {
        return circleState;
    }

    public void setCircleState(String circleState) {
        this.circleState = circleState == null ? null : circleState.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}