package com.zhongc.driver.web.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Filename Index.java
 * @Description
 * @Version 1.0
 * @Author zhongc
 * @Email zhong_ch@foxmail.com
 * @History <li>Author: zhongc</li>
 * <li>Date: 2015-09-24</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
@Controller
//@RequestMapping("")
public class Index {
    private Logger logger = LoggerFactory.getLogger(Index.class);

    @RequestMapping("/index")
    public void toHome(String name, Model model){
        model.addAttribute("name","zc");
//        System.out.print("进入");
        logger.info("进入");
        System.out.println(name);
//        return "/chat.vm";
    }

    /**
     * 跳转用户中心
     * @return
     */
    @RequestMapping({"usercenter",""})
    public String toUserCenter(){
        return "/user/order.vm";
    }

    /**
     * 后台
     * @return
     */
    @RequiresPermissions("admin:admin")
    @RequestMapping({"homecenter",""})
    public String toAdminCenter(){
        return "/user/order.vm";
    }
}
