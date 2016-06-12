package com.zhongc.driver.socket;

import com.zhongc.driver.socket.handler.WebSocketMsgHandler;
import com.zhongc.driver.web.interceptors.HttpSessionIdHandshakeInterceptor;
import com.zhongc.driver.web.interceptors.SessionKeepAliveChannelInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;
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
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
//		config.enableStompBrokerRelay("/queue", "/topic/");
        config.enableSimpleBroker("/topic/", "/queue/");
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.setInterceptors(sessionKeepAliveChannelInterceptor());
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat").withSockJS()
                .setInterceptors(httpSessionIdHandshakeInterceptor());
    }

    @Bean
    public HttpSessionIdHandshakeInterceptor httpSessionIdHandshakeInterceptor() {
        return new HttpSessionIdHandshakeInterceptor();
    }

    @Bean
    public SessionKeepAliveChannelInterceptor sessionKeepAliveChannelInterceptor() {
        return new SessionKeepAliveChannelInterceptor();
    }

    @Autowired
    private WebSocketHandler subProtocolWebSocketHandler;

    @Override
    public void configureWebSocketTransport(WebSocketTransportRegistration registration) {
        registration.addDecoratorFactory(new WebSocketHandlerDecoratorFactory() {
            @Override
            public WebSocketHandler decorate(WebSocketHandler webSocketHandler) {
                return new WebSocketSessionCapturingHandlerDecorator(webSocketHandler);
            }
        });
    }
}
