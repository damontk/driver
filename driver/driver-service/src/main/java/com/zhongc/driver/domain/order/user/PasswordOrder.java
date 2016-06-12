package com.zhongc.driver.domain.order.user;

import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * @Filename PasswordOrder.java
 * @Description
 * @Version 1.0
 * @Author zhongc
 * @Email zhong_ch@foxmail.com
 * @History <li>Author: zhongc</li>
 * <li>Date: 2015-09-26</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 * 更改密码
 */
public class PasswordOrder implements Serializable{

    private static final long serialVersionUID = 6935150611640560615L;

    /**
     * 用户名
     */
    @NotBlank(message = "用户ID不能为空")
    private String phone;

    /**
     * 原密码
     */
    private String oldPassword;

    /**
     * 新密码
     */
    private String password;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "PasswordOrder{" +
                "phone='" + phone + '\'' +
                ", oldPassword='" + oldPassword + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
