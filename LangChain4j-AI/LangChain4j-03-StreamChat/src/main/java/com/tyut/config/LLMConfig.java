package com.tyut.config;

import com.tyut.service.IServiceAssistant;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.chat.StreamingChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.OpenAiStreamingChatModel;
import dev.langchain4j.service.AiServices;
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

    /**
     * 提供模型源信息 >> 流式输出
     * @return
     */
    @Bean
    public StreamingChatLanguageModel streamingChatLanguageModel() {
        return OpenAiStreamingChatModel.builder()
                .apiKey("sk-2013c20522404d77ad7492cf3a48c5b1") // 密钥
                .logRequests(true) // 开启日志
                .logResponses(true)
                .modelName("qwen-max")  // 模型名称
                .baseUrl("https://dashscope.aliyuncs.com/compatible-mode/v1")
                .build();
    }

    /**
     * 提供流式输出功能的AI服务
     * @return
     */
    @Bean
    public IServiceAssistant getIServiceAssistant() {
        return AiServices.builder(IServiceAssistant.class)
                .streamingChatLanguageModel(streamingChatLanguageModel())
                .build();
    }
}
