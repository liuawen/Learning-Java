package test;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.BSON;
import org.bson.Document;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MongoTest {

    // 客户端
    private MongoClient mongoClient;
    // 集合
    private MongoCollection<Document> comment;

    @Before
    public void init() {
        //1. 创建操作MongoDB的客户端
        mongoClient = new MongoClient("192.168.200.128");
        // MongoClient mongoClient = new MongoClient("192.168.200.128",27017);

        //2. 选择数据库 use commentdb
        MongoDatabase commentdb = mongoClient.getDatabase("commentdb");

        //3. 获取集合 db.comment
        comment = commentdb.getCollection("comment");
    }


    //查询所有数据db.comment.find()
    @Test
    public void test1() {
        //4. 使用集合进行查询，查询所有数据db.comment.find()
        FindIterable<Document> documents = comment.find();

        //5. 解析结果集（打印）
        // "_id" : "1", "content" : "到底为啥出错", "userid" : "1012", "thumbup" : 2020 }
        for (Document document : documents) {
            System.out.println("------------------------------");
            System.out.println("_id:" + document.get("_id"));
            System.out.println("content:" + document.get("content"));
            System.out.println("userid:" + document.get("userid"));
            System.out.println("thumbup:" + document.get("thumbup"));
        }

    }


    @After
    public void after() {
        // 释放资源,关闭客户端
        mongoClient.close();
    }


    // 根据条件_id查询数据，db.comment.find({"_id" : "1"})
    @Test
    public void test2() {
        // 封装查询条件
        BasicDBObject bson = new BasicDBObject("_id", "1");

        // 执行查询
        FindIterable<Document> documents = comment.find(bson);

        for (Document document : documents) {
            System.out.println("------------------------------");
            System.out.println("_id:" + document.get("_id"));
            System.out.println("content:" + document.get("content"));
            System.out.println("userid:" + document.get("userid"));
            System.out.println("thumbup:" + document.get("thumbup"));
        }
    }

    // 新增db.comment.insert({"_id" : "5", "content" : "坚持就是胜利123", "userid" : "1018", "thumbup" : 1212})
    @Test
    public void test3() {
        // 封装新增数据
        Map<String, Object> map = new HashMap<>();
        map.put("_id", "6");
        map.put("content", "新增测试");
        map.put("userid", "1019");
        map.put("thumbup", "666");

        // 封装新增文档对象
        Document document = new Document(map);

        // 执行新增
        comment.insertOne(document);
    }

    // 修改，db.comment.update({"_id" : "5"},{$set:{"userid" : "888"}})
    @Test
    public void test4() {
        //创建修改的条件
        BasicDBObject filter = new BasicDBObject("_id", "6");
        //创建修改的值
        BasicDBObject update = new BasicDBObject("$set", new Document("userid", "999"));

        // 执行修改
        comment.updateOne(filter, update);
    }

    // 删除，db.comment.remove({"_id" : "5"})
    @Test
    public void test5() {
        // 创建删除的条件
        BasicDBObject bson = new BasicDBObject("_id", "6");

        // 执行删除
        comment.deleteOne(bson);
    }
}
