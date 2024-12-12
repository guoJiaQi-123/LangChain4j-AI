package com.tyut.controller;

import com.tyut.service.IServiceAssistant;
import dev.langchain4j.model.chat.ChatLanguageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version v1.0
 * @author OldGj 2024/12/6
 * @apiNote 控制器
 */
@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private ChatLanguageModel chatLanguageModel;
    @Autowired
    private IServiceAssistant iServiceAssistant;

    @GetMapping("/qwen")
    public String chat(String message) {
        return chatLanguageModel.generate(message);
    }

    @GetMapping("/assistant")
    public String chat2(String message) {
        return iServiceAssistant.chat(message);
    }
}

