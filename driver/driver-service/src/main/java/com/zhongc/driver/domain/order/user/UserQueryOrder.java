package com.zhongc.driver.domain.order.user;

import com.zhongc.driver.result.CommonPageOrder;

import java.io.Serializable;

/**
 * @Filename UserQueryOrder.java
 * @Description
 * @Version 1.0
 * @Author zhongc
 * @Email zhong_ch@foxmail.com
 * @History <li>Author: zhongc</li>
 * <li>Date: 2015-09-26</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class UserQueryOrder extends CommonPageOrder implements Serializable {

    private static final long serialVersionUID = -7157220325266476210L;

    private String phone;

    private Boolean userType;

    private Integer coachId;

    private Integer courseId;

    private Integer stadyType;

    private String realName;


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getUserType() {
        return userType;
    }

    public void setUserType(Boolean userType) {
        this.userType = userType;
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

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Override
    public String toString() {
        return "UserQueryOrder{" +
                ", phone='" + phone + '\'' +
                ", userType=" + userType +
                ", coachId=" + coachId +
                ", courseId=" + courseId +
                ", stadyType=" + stadyType +
                ", realName='" + realName + '\'' +
                '}';
    }
}
