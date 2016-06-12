package com.zhongc.driver.result;

import com.zhongc.driver.enums.Status;

import java.io.Serializable;

/**
 * Created by zhongChao on 2015/9/25.
 */
public class CommonResult implements Serializable{

    private static final long serialVersionUID = 7653144592772712778L;
    /** 结果状态 */
    private Status status;

    /** 信息码 */
    private String code;

    /** 描述 */
    private String description;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CommonResult{" +
                "status=" + status +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
