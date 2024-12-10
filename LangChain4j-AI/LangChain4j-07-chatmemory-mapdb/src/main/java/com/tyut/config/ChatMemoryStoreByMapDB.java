package com.tyut.config;

import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.ChatMessageDeserializer;
import dev.langchain4j.data.message.ChatMessageSerializer;
import dev.langchain4j.store.memory.chat.ChatMemoryStore;
import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.Serializer;

import java.util.List;
import java.util.Map;

/**
 * @version v1.0
 * @author OldGj 2024/12/7
 * @apiNote 自定义的持久化聊天存储器 - 使用MapDB进行本地缓存
 */
public class ChatMemoryStoreByMapDB implements ChatMemoryStore {

    // 创建 MapDB
    private final DB db = DBMaker.fileDB("./chat-memory.db")
            .transactionEnable()
            .make();
    // 创建map对象
    private final Map<Integer, String> map = db.hashMap("messages")
            .keySerializer(Serializer.INTEGER)
            .valueSerializer(Serializer.STRING)
            .createOrOpen();

    /**
     * 获取消息
     * @param
     * @return
     */
    @Override
    public List<ChatMessage> getMessages(Object memoryId) {
        String json = map.get((Integer) memoryId);
        return ChatMessageDeserializer.messagesFromJson(json);
    }

    /**
     * 更新消息
     * @param
     * @param list
     */
    @Override
    public void updateMessages(Object memoryId, List<ChatMessage> list) {
        String json = ChatMessageSerializer.messagesToJson(list);
        map.put((Integer) memoryId, json);
        db.commit();
    }

    /**
     * 删除消息
     * @param
     */
    @Override
    public void deleteMessages(Object memoryId) {
        map.remove((Integer) memoryId);
        db.commit();
    }
}
