package com.zhongc.driver.domain.order.user;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * @Filename UserAddOrder.java
 * @Description
 * @Version 1.0
 * @Author zhongc
 * @Email zhong_ch@foxmail.com
 * @History <li>Author: zhongc</li>
 * <li>Date: 2015-09-26</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class UserAddOrder implements Serializable {

    private static final long serialVersionUID = 8217179546442923159L;

    private String userId;

    @NotBlank(message = "密码不能为空")
    @Size(max = 30, min = 6)
    private String password;

    @NotBlank(message = "手机不能为空")
    private String phone;

    private Boolean userType;

    @NotNull(message = "性别不能为空")
    private Boolean userSex;

    @NotNull(message = "教练ID不能为空")
    private Integer coachId;


    private Integer courseId;

    private Integer stadyType;

    private Date createTime;

    @NotBlank(message = "真实姓名不能为空")
    private String realName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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
        return "UserAddOrder{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
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
