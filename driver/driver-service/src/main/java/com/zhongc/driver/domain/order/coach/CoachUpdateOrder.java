package com.zhongc.driver.domain.order.coach;

import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * @Filename CoachUpdateOrder.java
 * @Description
 * @Version 1.0
 * @Author zhongc
 * @Email zhong_ch@foxmail.com
 * @History <li>Author: zhongc</li>
 * <li>Date: 2015-11-14</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class CoachUpdateOrder implements Serializable{

    private static final long serialVersionUID = -8833908176910598513L;

    @NotBlank(message = "教练id为空！")
    private Integer coachId;

    private String coachName;

    private Boolean coachSex;

    private Integer driverAge;

    private String driverType;

    private String teachType;

    public String getDriverType() {
        return driverType;
    }

    public void setDriverType(String driverType) {
        this.driverType = driverType;
    }

    public Integer getCoachId() {
        return coachId;
    }

    public void setCoachId(Integer coachId) {
        this.coachId = coachId;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public Boolean getCoachSex() {
        return coachSex;
    }

    public void setCoachSex(Boolean coachSex) {
        this.coachSex = coachSex;
    }

    public Integer getDriverAge() {
        return driverAge;
    }

    public void setDriverAge(Integer driverAge) {
        this.driverAge = driverAge;
    }

    public String getTeachType() {
        return teachType;
    }

    public void setTeachType(String teachType) {
        this.teachType = teachType;
    }
}
