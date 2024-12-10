package com.tyut.service;

import com.tyut.model.User;
import dev.langchain4j.service.UserMessage;

/**
 * @version v1.0
 * @author OldGj 2024/12/10
 * @apiNote TODO(一句话给出该类描述)
 */
public interface IUserService {

    @UserMessage("从 {{it}} 中提取有关某人的信息")
    User exportUser(String message);
}
