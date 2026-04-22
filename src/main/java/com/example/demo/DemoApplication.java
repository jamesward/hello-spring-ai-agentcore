package com.example.demo;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    ChatClient chatClient;

    DemoApplication(ChatClient.Builder chatClientBuilder) {
        chatClient = chatClientBuilder.build();
    }

    @PostMapping("/invocations")
    public String myAgent() {
        return chatClient
            .prompt("tell me a joke")
            .call()
            .content();
    }

}
