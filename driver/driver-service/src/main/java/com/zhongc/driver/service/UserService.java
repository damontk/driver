package com.zhongc.driver.service;

import com.zhongc.driver.result.CommonEntityResult;
import com.zhongc.driver.result.CommonPageResult;
import com.zhongc.driver.result.CommonResult;
import com.zhongc.driver.domain.order.user.LoginOrder;
import com.zhongc.driver.domain.order.user.PasswordOrder;
import com.zhongc.driver.domain.order.user.UserAddOrder;
import com.zhongc.driver.domain.order.user.UserQueryOrder;

/**
 * Created by zhongChao on 2015/9/25.
 */
public interface UserService {
    /**
     * 添加用户
     * @param user
     * @return
     */
    CommonResult addUser(UserAddOrder user);

    /**
     * 删除用户
     * @param userId
     * @return
     */
    CommonResult deleteUser(String userId);

    /**
     * 分页查询用户信息
     * @param order
     * @return
     */
    CommonPageResult queryUsers(UserQueryOrder order);

    /**
     * 根据用户手机，密码登陆
     * @param order
     * @return
     */
    CommonEntityResult login (LoginOrder order);

    /**
     * 修改密码
     * @param passwordOrder
     * @return
     */
    CommonResult updatePassword(PasswordOrder passwordOrder);

    /**
     * 忘记密码直接修改
     * @param passwordOrder
     * @return
     */
    CommonResult forgetPassword(PasswordOrder passwordOrder);
}
