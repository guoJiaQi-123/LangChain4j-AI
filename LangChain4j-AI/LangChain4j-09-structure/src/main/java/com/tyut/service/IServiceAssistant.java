package com.tyut.service;

import dev.langchain4j.service.UserMessage;

/**
 * @version v1.0
 * @apiNote 接口
 * @author OldGj 2024/12/6
 */
public interface IServiceAssistant {

    @UserMessage(value = "Does {{it}} have positive sentiment")
    boolean chat(String message);

    @UserMessage("Analyze sentiment of {{it}}")
    Sentiment analyzeSentimentOf(String text);

    enum Sentiment {
        POSITIVE, NEGATIVE, NEUTRAL
    }
}
