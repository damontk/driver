package com.zhongc.driver.domain.order.coach;

import com.zhongc.driver.domain.Coach;

import java.io.Serializable;

/**
 * @Filename CoachQueryOrder.java
 * @Description
 * @Version 1.0
 * @Author zhongc
 * @Email zhong_ch@foxmail.com
 * @History <li>Author: zhongc</li>
 * <li>Date: 2015-11-14</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 *
 * 教练信息查询order
 *
 */
public class CoachQueryOrder implements Serializable {

    private static final long serialVersionUID = -5192556220344340354L;
    private String coachName;

    private Boolean coachSex;

    private Integer driverAge;

    private String driverType;

    private String teachType;

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

    public String getDriverType() {
        return driverType;
    }

    public void setDriverType(String driverType) {
        this.driverType = driverType;
    }

    public String getTeachType() {
        return teachType;
    }

    public void setTeachType(String teachType) {
        this.teachType = teachType;
    }

    @Override
    public String toString() {
        return "CoachQueryOrder{" +
                "coachName='" + coachName + '\'' +
                ", coachSex=" + coachSex +
                ", driverAge=" + driverAge +
                ", driverType='" + driverType + '\'' +
                ", teachType='" + teachType + '\'' +
                '}';
    }
}
