package com.zhongc.driver.domain.order.user;

import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * @Filename LoginOrder.java
 * @Description
 * @Version 1.0
 * @Author zhongc
 * @Email zhong_ch@foxmail.com
 * @History <li>Author: zhongc</li>
 * <li>Date: 2015-09-26</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class LoginOrder implements Serializable {

    private static final long serialVersionUID = 99681264035669118L;

    @NotBlank(message = "账户不能为空！")
    private String phone;

    @NotBlank(message = "密码不能为空")
    private String password;

    /**
     * 用户类型  false 普通用户  true  管理员
     */
    private boolean userType;

    public LoginOrder() {

    }

    public LoginOrder(String userId, String password, boolean userType) {
        this.phone = userId;
        this.password = password;
        this.userType = userType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getUserType() {
        return userType;
    }

    public void setUserType(boolean userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "LoginOrder{" +
                "phone='" + phone + '\'' +
                ", password='" + "***********" + '\'' +
                ", userType=" + userType +
                '}';
    }
}
