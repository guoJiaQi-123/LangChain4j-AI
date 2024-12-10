package com.tyut.service;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.UserMessage;

/**
 * @version v1.0
 * @apiNote 接口
 * @author OldGj 2024/12/6
 */
public interface IServiceAssistant {


    String chat(@MemoryId Integer userId, @UserMessage String message);
}
