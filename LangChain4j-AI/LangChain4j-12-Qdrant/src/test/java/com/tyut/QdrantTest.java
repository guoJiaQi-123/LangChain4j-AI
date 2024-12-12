package com.tyut;

import io.qdrant.client.QdrantClient;
import io.qdrant.client.grpc.Collections;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @version v1.0
 * @author OldGj 2024/12/12
 * @apiNote TODO(一句话给出该类描述)
 */
@SpringBootTest
public class QdrantTest {

    @Autowired
    private QdrantClient qdrantClient;


    @Test
    public void test() {
        Collections.VectorParams vectorParams = Collections.VectorParams.newBuilder()
                // distance计算方法 cosine 余弦 EucLid 欧式距离 Dot 点积 Manhattan 曼哈顿距离
                .setDistance(Collections.Distance.Cosine)
                //  size向量长度数据维度
                .setSize(1024)
                .build();
        qdrantClient.createCollectionAsync("tyut", vectorParams);
    }
}
