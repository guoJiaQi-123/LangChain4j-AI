package com.tyut;

import junit.framework.TestCase;
import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.HTreeMap;
import org.mapdb.Serializer;

import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

    /**
     * mapdb写入
     */
    public void test() {
        // 创建或打开一个DB文件
        File dbFile = new File("mydb");
        DB db = DBMaker.fileDB(dbFile).make();
        // 创建一个HashMap并设置名称
        HTreeMap<String, String> map = db.hashMap("myMap")
                .keySerializer(Serializer.STRING)
                .valueSerializer(Serializer.STRING).createOrOpen();
        // 在Map中存储数据
        map.put("key1", "value1");
        map.put("key2", "value2");
        // 提交事务以确保数据被持久化到磁盘
        db.commit();
        // 关闭数据库连接
        db.close();
    }

    /**
     * mapdb读取
     */
    public void test2() {
        File dbFile = new File("mydb");
        // 重新打开数据库以检索数据
        DB db = DBMaker.fileDB(dbFile).make();
        // 从Map中检索数据
        HTreeMap<String, String> map = db.hashMap("myMap")
                .keySerializer(Serializer.STRING)
                .valueSerializer(Serializer.STRING).createOrOpen();
        String value1 = map.get("key1");
        String value2 = map.get("key2");
        System.out.println("Value for key1: " + value1);
        System.out.println("Value for key2: " + value2);
        // 关闭数据库连接
        db.close();
    }
}
