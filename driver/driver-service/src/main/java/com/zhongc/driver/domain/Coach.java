package com.zhongc.driver.domain;

import java.io.Serializable;

public class Coach implements Serializable{

    private static final long serialVersionUID = 6356072117788778497L;

    private Integer coachId;

    private String coachName;

    private Boolean coachSex;

    private Integer driverAge;

    private String driverType;

    private String teachType;

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
        this.coachName = coachName == null ? null : coachName.trim();
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
        this.driverType = driverType == null ? null : driverType.trim();
    }

    public String getTeachType() {
        return teachType;
    }

    public void setTeachType(String teachType) {
        this.teachType = teachType == null ? null : teachType.trim();
    }
}