package com.zhongc.driver.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

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
    @Resource
    private SimpMessagingTemplate simpMessagingTemplate;

    @RequestMapping("/")
    public String index() {
        return "chat.vm";
    }

    @MessageMapping("/msg")
    public void receiveAndSendMessage(String value) {
//        simpMessagingTemplate.convertAndSend("","/topic/note", value);
        simpMessagingTemplate.convertAndSendToUser("zc", "/topic/note", value);
    }
}
