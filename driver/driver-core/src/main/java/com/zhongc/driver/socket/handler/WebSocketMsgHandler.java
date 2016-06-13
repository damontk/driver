package com.zhongc.driver.socket.handler;

import com.zhongc.driver.common.Constant;
import com.zhongc.driver.common.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.WebSocketHandlerDecorator;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhongChao on 2016/1/26.
 */
public class WebSocketMsgHandler extends WebSocketHandlerDecorator {
    private static List<WebSocketSession> onLine;

    private static Logger logger = LoggerFactory.getLogger(WebSocketMsgHandler.class);

    private static WebSocketMsgHandler webSocketMsgHandler;
    static {
        onLine = new LinkedList<>();
        webSocketMsgHandler=new WebSocketMsgHandler();
    }

    public WebSocketMsgHandler() {
        super(webSocketMsgHandler);
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.print("afterConnectionEstablished() 运行时间:" + DateUtil.format(DateUtil.dtSimpleHMS, new Date()));
        // 获取用户名称
        String userName = (String) session.getAttributes().get(Constant.Session.SESSION_USER_NAME);

        if (userName != null) {

        }
        super.afterConnectionEstablished(session);
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        System.out.print("handleMessage() 运行时间:" + DateUtil.format(DateUtil.dtSimpleHMS, new Date()));
        session.sendMessage(message);
        super.handleMessage(session, message);
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        System.out.print("handleTransportError() 运行时间:" + DateUtil.format(DateUtil.dtSimpleHMS, new Date()));
        super.handleTransportError(session, exception);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        System.out.print("afterConnectionClosed() 运行时间:" + DateUtil.format(DateUtil.dtSimpleHMS, new Date()));
        super.afterConnectionClosed(session, closeStatus);
    }

    /**
     * 给指定的人发送信息
     *
     * @param userName 用户名
     * @param message  信息
     */
    public void sendMsgToUser(String userName, TextMessage message) {
        for (WebSocketSession user : onLine) {
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
        for (WebSocketSession user : onLine) {
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
        for (WebSocketSession user : onLine) {
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
