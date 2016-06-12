package com.zhongc.driver.domain;

import java.util.Date;

public class User {
    private String userId;

    private String password;

    private String phone;

    private Boolean dr;

    /**
     * 用户类型  管理员  true 学员 false
     */
    private Boolean userType;

    private Boolean userSex;

    private Integer coachId;

    private Integer courseId;

    private Integer stadyType;

    private Date createTime;

    private String realName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Boolean getDr() {
        return dr;
    }

    public void setDr(Boolean dr) {
        this.dr = dr;
    }

    public Boolean getUserType() {
        return userType;
    }

    public void setUserType(Boolean userType) {
        this.userType = userType;
    }

    public Boolean getUserSex() {
        return userSex;
    }

    public void setUserSex(Boolean userSex) {
        this.userSex = userSex;
    }

    public Integer getCoachId() {
        return coachId;
    }

    public void setCoachId(Integer coachId) {
        this.coachId = coachId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getStadyType() {
        return stadyType;
    }

    public void setStadyType(Integer stadyType) {
        this.stadyType = stadyType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", password='" + "*********" + '\'' +
                ", phone='" + phone + '\'' +
                ", dr=" + dr +
                ", userType=" + userType +
                ", userSex=" + userSex +
                ", coachId=" + coachId +
                ", courseId=" + courseId +
                ", stadyType=" + stadyType +
                ", createTime=" + createTime +
                ", realName='" + realName + '\'' +
                '}';
    }
}