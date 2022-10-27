package com.example.chatting.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class SpringConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry){
        // stomp ���� �ּ� url > /ws-stomp
        registry.addEndpoint("/ws-stomp") // ����� ��������Ʈ
                .withSockJS(); //socketJS �� �����Ѵٴ� ����
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry){
        // �޼����� �����ϴ� ��û url > �� �޼����� ���� ��      SUB(����)
        registry.enableSimpleBroker("/sub");

        // �޼����� �����ϴ� ��û url > �� �޼����� ���� ��
        registry.setApplicationDestinationPrefixes("/pub");
    }
}
