package com.zhongc.driver.socket.handler;

import com.alibaba.fastjson.JSON;
import com.zhongc.driver.common.Constant;
import com.zhongc.driver.common.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.ExceptionWebSocketHandlerDecorator;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhongChao on 2016/1/26.
 */
public class WebSocketMsgHandler implements WebSocketHandler {
    private static List<WebSocketSession> onLineList;

    private static Logger logger = LoggerFactory.getLogger(WebSocketMsgHandler.class);

    static {
        onLineList = new LinkedList<>();
    }
    public WebSocketMsgHandler() {
    }


    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.print("afterConnectionEstablished() 运行时间:" + DateUtil.format(DateUtil.dtSimpleHMS, new Date()));
        // 获取用户名称
        String userName = (String) session.getAttributes().get(Constant.Session.SESSION_USER_NAME);

        if (userName != null) {
        }
        onLineList.add(session);
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        System.out.print("handleMessage() 运行时间:" + DateUtil.format(DateUtil.dtSimpleHMS, new Date()));
        JSON.parseObject(message.getPayload() + "", User.class);
        TextMessage tm = new TextMessage(message.getPayload() + "");
//        session.sendMessage(tm);
        senMsgToAllOnline(tm);
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        System.out.print("handleTransportError() 运行时间:" + DateUtil.format(DateUtil.dtSimpleHMS, new Date()));
        if (session.isOpen()) {
            try {
                session.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        onLineList.remove(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        System.out.print("afterConnectionClosed() 运行时间:" + DateUtil.format(DateUtil.dtSimpleHMS, new Date()));
        onLineList.remove(session);
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    /**
     * 给指定的人发送信息
     *
     * @param userName 用户名
     * @param message  信息
     */
    public void sendMsgToUser(String userName, TextMessage message) {
        for (WebSocketSession user : onLineList) {
            if (user.getAttributes().get(userName) != null) {
                sendMsg(userName, message, user);
            }
        }
    }

    /**
     * 给指定人发送信息
     *
     * @param userNames
     * @param message
     */
    public void senMsgToAssignUsers(List<String> userNames, TextMessage message) {
        for (WebSocketSession user : onLineList) {
            for (String userName : userNames) {
                if (user.getAttributes().get(userName) != null) {
                    sendMsg(userName, message, user);
                }
            }
        }
    }


    /**
     * 给所有当前在线的用户发送信息
     *
     * @param message
     */
    public void senMsgToAllOnline(TextMessage message) {
        for (WebSocketSession user : onLineList) {
            sendMsg((String) user.getAttributes().get(Constant.Session.SESSION_USER_NAME), message, user);
        }
    }

    private void sendMsg(String userName, TextMessage message, WebSocketSession user) {
        try {
            if (user.isOpen()) {
                user.sendMessage(message);
            } else {
                logger.error("发送给" + userName + "信息出错！连接已关闭");
            }
        } catch (IOException e) {
            logger.error("发送给" + userName + "信息出错！" + e);
        }
    }
}

class User {
    private String userid;
    private String username;
    private String content;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
