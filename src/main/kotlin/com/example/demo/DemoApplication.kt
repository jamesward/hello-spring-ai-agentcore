package com.example.demo

import org.springframework.ai.chat.client.ChatClient
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@SpringBootApplication
@RestController
class DemoApplication(chatClientBuilder: ChatClient.Builder) {

    data class Prompt(val question: String)

    val chatClient = chatClientBuilder.build()

    @PostMapping("/invocations")
    fun inquire(@RequestBody prompt: Prompt): String {
        return chatClient
            .prompt()
            .user(prompt.question)
            .call()
            .content() ?: throw IllegalStateException("No content returned")
    }

}

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}
