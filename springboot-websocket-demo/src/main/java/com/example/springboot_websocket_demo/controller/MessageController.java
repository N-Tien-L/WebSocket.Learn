package com.example.springboot_websocket_demo.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import lombok.Data;

@Controller
public class MessageController {
    
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public OutputMessage sendMessage(Message message) {
        return new OutputMessage("Server received: " + message.getName());
    }

    @Data
    public static class Message {
        private String name;
    }

    @Data
    public static class OutputMessage {
        private final String content;
    }
}
