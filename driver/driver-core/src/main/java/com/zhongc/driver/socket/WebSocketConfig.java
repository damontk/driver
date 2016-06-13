package com.zhongc.driver.socket;

import com.zhongc.driver.socket.handler.WebSocketMsgHandler;
import com.zhongc.driver.web.interceptors.HttpSessionIdHandshakeInterceptor;
import com.zhongc.driver.web.interceptors.SessionKeepAliveChannelInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.*;
import org.springframework.web.socket.handler.WebSocketHandlerDecoratorFactory;

/**
 * @Filename WebsocketConfig.java
 * @Description
 * @Version 1.0
 * @Author zhongc
 * @Email zhong_ch@foxmail.com
 * @History <li>Author: zhongc</li>
 * <li>Date: 2016/2/20</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(getWebSocketMsgHandler(), "/webSocketServer").addInterceptors(new WebSocketSessionCapturingHandlerDecorator());
        webSocketHandlerRegistry.addHandler(getWebSocketMsgHandler(), "/sockjs/webSocketServer").addInterceptors(new WebSocketSessionCapturingHandlerDecorator()).withSockJS();
    }
    @Bean
    public WebSocketMsgHandler getWebSocketMsgHandler(){
        return new WebSocketMsgHandler();
    }
}
