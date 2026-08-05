package com.example.demo;

import org.springaicommunity.agentcore.annotation.AgentCoreInvocation;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication {

    static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    ChatClient chatClient;

    DemoApplication(ChatClient.Builder chatClientBuilder) {
        chatClient = chatClientBuilder.build();
    }

    @AgentCoreInvocation
    public String myAgent() {
        return chatClient.prompt("tell me a joke").call().content();
    }

}
