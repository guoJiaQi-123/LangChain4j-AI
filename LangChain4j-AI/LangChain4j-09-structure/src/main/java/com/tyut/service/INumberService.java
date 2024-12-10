package com.tyut.service;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;

/**
 * @version v1.0
 * @apiNote TODO(请给出接口描述)
 * @author OldGj 2024/12/10
 */
public interface INumberService {

    @UserMessage("从{{message}}中提取一个数字")
    int exportNumber(@V(value = "message") String message);
}
