package com.zhongc.driver.socket;

import com.zhongc.driver.socket.handler.WebSocketMsgHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.*;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

/**
 * @Filename WebsocketConfig.java
 * @Description
 * @Version 1.0  http://www.jianshu.com/p/8500ad65eb50
 * @Author zhongc
 * @Email zhong_ch@foxmail.com
 * @History <li>Author: zhongc</li>
 * <li>Date: 2016/2/20</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
@Configuration
@EnableWebSocket
@EnableWebSocketMessageBroker
@EnableScheduling
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer{
//    @Override
//    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
//        webSocketHandlerRegistry.addHandler(getWebSocketMsgHandler(), "/webSocketServer").addInterceptors(new HttpSessionIdHandshakeInterceptor());
//        webSocketHandlerRegistry.addHandler(getWebSocketMsgHandler(), "/sockjs/webSocketServer").addInterceptors(new HttpSessionIdHandshakeInterceptor()).withSockJS();
//    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/socket").withSockJS().setInterceptors(new HttpSessionIdHandshakeInterceptor());
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");
        registry.setApplicationDestinationPrefixes("/app");
    }

//    @Bean
//    public WebSocketHandler getWebSocketMsgHandler(){
//        return new WebSocketMsgHandler();
//    }

    @Bean
    public ServletServerContainerFactoryBean createWebSocketContainer() {
        ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
        container.setMaxTextMessageBufferSize(8192);
        container.setMaxBinaryMessageBufferSize(8192);
        return container;
    }
}
