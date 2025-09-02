package com.example.springboot_websocket_demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker // open websocket
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{
    
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // define prefix for client's message
        config.setApplicationDestinationPrefixes("/app");
        // enable broker so that server can send message to client
        config.enableSimpleBroker("/topic");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // declare endpoint that client will connect to
        // withSockJS() -> fallback when browser not support websocket
        registry.addEndpoint("/ws").setAllowedOriginPatterns("*").withSockJS();
    }
}
