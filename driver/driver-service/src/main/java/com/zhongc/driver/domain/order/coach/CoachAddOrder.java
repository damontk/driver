package com.zhongc.driver.domain.order.coach;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Filename CoachAddOrder.java
 * @Description
 * @Version 1.0
 * @Author zhongc
 * @Email zhong_ch@foxmail.com
 * @History <li>Author: zhongc</li>
 * <li>Date: 2015-11-14</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class CoachAddOrder implements Serializable{

    private static final long serialVersionUID = -9051840445827566227L;

    @NotBlank(message = "教练姓名不能为空")
    private String coachName;

    @NotBlank(message = "教练性别不能为空")
    private Boolean coachSex;

    @NotBlank(message = "教练驾龄不能为空")
    private Integer driverAge;

    @NotBlank(message = "教练驾照类型不能为空")
    private String driverType;

    @NotBlank(message = "教练教学驾照类型不能为空")
    private String teachType;

    public String getTeachType() {
        return teachType;
    }

    public void setTeachType(String teachType) {
        this.teachType = teachType;
    }

    public String getDriverType() {
        return driverType;
    }

    public void setDriverType(String driverType) {
        this.driverType = driverType;
    }

    public Integer getDriverAge() {
        return driverAge;
    }

    public void setDriverAge(Integer driverAge) {
        this.driverAge = driverAge;
    }

    public Boolean getCoachSex() {
        return coachSex;
    }

    public void setCoachSex(Boolean coachSex) {
        this.coachSex = coachSex;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    @Override
    public String toString() {
        return "CoachAddOrder{" +
                "coachName='" + coachName + '\'' +
                ", coachSex=" + coachSex +
                ", driverAge=" + driverAge +
                ", driverType='" + driverType + '\'' +
                ", teachType='" + teachType + '\'' +
                '}';
    }
}
