package com.tyut.config;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.chat.StreamingChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.OpenAiStreamingChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @version v1.0
 * @author OldGj 2024/12/6
 * @apiNote 配置类
 */
@Configuration
public class LLMConfig {

    /**
     * 提供模型源信息
     * @return
     */
    @Bean
    public ChatLanguageModel getChatLanguageModel() {
        return OpenAiChatModel.builder()
                .apiKey("sk-2013c20522404d77ad7492cf3a48c5b1") // 密钥
                .logRequests(true) // 开启日志
                .logResponses(true)
                .modelName("qwen-vl-max")  // 模型名称
                .baseUrl("https://dashscope.aliyuncs.com/compatible-mode/v1")
                .build();
    }
}
