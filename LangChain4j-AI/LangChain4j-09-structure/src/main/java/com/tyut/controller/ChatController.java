package com.tyut.controller;

import com.tyut.model.User;
import com.tyut.service.INumberService;
import com.tyut.service.IServiceAssistant;
import com.tyut.service.IUserService;
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
    private IServiceAssistant iServiceAssistant;

    @Autowired
    private INumberService iNumberService;

    @Autowired
    private IUserService iUserService;


    @GetMapping("/boolean")
    public boolean chat2(String message) {
        return iServiceAssistant.chat(message);
    }

    @GetMapping("/enum")
    public IServiceAssistant.Sentiment chat(String message) {
        return iServiceAssistant.analyzeSentimentOf(message);
    }

    @GetMapping("/number")
    public int number(String message) {
        return iNumberService.exportNumber(message);
    }

    @GetMapping("/user")
    public User user(String message) {
        return iUserService.exportUser(message);
    }
}

