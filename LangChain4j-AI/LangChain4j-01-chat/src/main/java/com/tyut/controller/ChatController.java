package com.tyut.controller;

import dev.langchain4j.model.chat.ChatLanguageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version v1.0
 * @author OldGj 2024/12/5
 * @apiNote chat控制器
 */
@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private ChatLanguageModel chatLanguageModel;

    @GetMapping("/qwen")
    public String chatAi(String message) {
        String generate = chatLanguageModel.generate(message);
        return generate;
    }
}
