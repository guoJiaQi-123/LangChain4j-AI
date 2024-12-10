package com.tyut.config;

import com.tyut.service.INumberService;
import com.tyut.service.IServiceAssistant;
import com.tyut.service.IUserService;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
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
                .modelName("qwen-max")  // 模型名称
                .baseUrl("https://dashscope.aliyuncs.com/compatible-mode/v1")
                .build();
    }

    /**
     * 不同AI服务与模型的解耦
     * @return AI服务
     */
    @Bean
    public IServiceAssistant getIServiceAssistant() {
        // 解读:IServiceAssistant这个AI服务类使用的大模型是 >> getChatLanguageModel()这个方法返回的大模型
        return AiServices.builder(IServiceAssistant.class)
                .chatLanguageModel(getChatLanguageModel())
                .build();
    }


    /**
     * 不同AI服务与模型的解耦
     * @return AI服务
     */
    @Bean
    public INumberService iNumberService() {
        // 解读:IServiceAssistant这个AI服务类使用的大模型是 >> getChatLanguageModel()这个方法返回的大模型
        return AiServices.builder(INumberService.class)
                .chatLanguageModel(getChatLanguageModel())
                .build();
    }

    /**
     * 不同AI服务与模型的解耦
     * @return AI服务
     */
    @Bean
    public IUserService iUserService() {
        // 解读:IServiceAssistant这个AI服务类使用的大模型是 >> getChatLanguageModel()这个方法返回的大模型
        return AiServices.builder(IUserService.class)
                .chatLanguageModel(getChatLanguageModel())
                .build();
    }
}
