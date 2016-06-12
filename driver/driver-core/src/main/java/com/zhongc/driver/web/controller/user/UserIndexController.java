package com.zhongc.driver.web.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Filename UserIndexController.java
 * @Description
 * @Version 1.0
 * @Author zhongc
 * @Email zhong_ch@foxmail.com
 * @History <li>Author: zhongc</li>
 * <li>Date: 2015-11-14</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
@Controller
@RequestMapping("/usercenter")
public class UserIndexController {

    /**
     * 跳转用户中心
     * @return
     */
    @RequestMapping({"/",""})
    public String toUserCenter(){
        return "/user/order.vm";
    }
}
