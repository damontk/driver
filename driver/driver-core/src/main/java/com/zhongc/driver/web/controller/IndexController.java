package com.zhongc.driver.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @version 1.0
 * @项目名称：
 * @类名称： IndexController.java
 * @类描述：
 * @创建人：zc
 * @创建时间：
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String index() {
        return "index.vm";
    }
}
