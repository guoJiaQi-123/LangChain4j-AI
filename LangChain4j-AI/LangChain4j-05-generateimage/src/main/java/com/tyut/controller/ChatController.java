package com.tyut.controller;


import dev.langchain4j.data.image.Image;
import dev.langchain4j.model.image.ImageModel;
import dev.langchain4j.model.output.Response;
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
@RequestMapping("/generate")
public class ChatController {

    @Autowired
    private ImageModel imageModel;


    @GetMapping("/image")
    public String generateImage(String msg) {
        Response<Image> imageResponse = imageModel.generate(msg);
        return imageResponse.content().url().toString();
    }
}

