package com.tyut.config;

import dev.langchain4j.model.image.ImageModel;
import dev.langchain4j.model.openai.OpenAiImageModel;
import dev.langchain4j.model.zhipu.ZhipuAiImageModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

/**
 * @version v1.0
 * @author OldGj 2024/12/6
 * @apiNote 配置类
 */
@Configuration
public class LLMConfig {

    @Bean
    public ImageModel imageModel() {
        return ZhipuAiImageModel.builder()
                .apiKey("f6debc524d70c1c245b6e931c5a6b394.3OeExMPIXSW8YOCq")
                .connectTimeout(Duration.ofSeconds(10000))
                .callTimeout(Duration.ofSeconds(10000))
                .readTimeout(Duration.ofSeconds(10000))
                .writeTimeout(Duration.ofSeconds(10000))
                .logRequests(true)
                .logResponses(true)
                .build();
    }

}
