package com.tyut.config;

import com.tyut.service.IServiceAssistant;
import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.store.memory.chat.ChatMemoryStore;
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

    @Bean
    public IServiceAssistant getIServiceAssistant() {
        return AiServices.builder(IServiceAssistant.class)
                .chatLanguageModel(getChatLanguageModel())
                .chatMemoryProvider(chatMemoryProvider()) // 聊天存储器生产者
                .build();
    }

    @Bean
    public ChatMemoryStore chatMemoryStore() {
        return new ChatMemoryStoreByMapDB();
    }

    @Bean
    public ChatMemoryProvider chatMemoryProvider() {
        return memoryId -> MessageWindowChatMemory.builder()
                // 设置消息窗口 ID
                .id(memoryId)
                // 设置消息最大条数，默认为 10
                .maxMessages(20)
                // 设置聊天存储器，使用自定义的
                .chatMemoryStore(chatMemoryStore())
                .build();
    }
}
