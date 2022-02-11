package com.tenstone.leet.rocketmq.batch;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuyuancheng on 2022/1/23  <br/>
 * 小于1MB的消息批量发送
 *
 * @author liuyuancheng
 */
public class SmallBatchProducerDemo {
    public static void main(String[] args) {
        DefaultMQProducer producer = new DefaultMQProducer("test_group_name");
        String topic = "BatchTest";
        List<Message> messages = new ArrayList<>();
        messages.add(new Message(topic, "TagA", "OrderID001", "Hello world 0".getBytes()));
        messages.add(new Message(topic, "TagA", "OrderID002", "Hello world 1".getBytes()));
        messages.add(new Message(topic, "TagA", "OrderID003", "Hello world 2".getBytes()));
        try {
            producer.send(messages);
        } catch (Exception e) {
            e.printStackTrace();
            //handle the error
        }
    }
}
