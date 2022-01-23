package com.tenstone.leet.rocketmq.filter;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;

/**
 * Created by liuyuancheng on 2022/1/23  <br/>
 *
 * @author liuyuancheng
 */
public class FilterProducerDemo {
    public static void main(String[] args) throws Exception {
        final String tag = "TAGA";
        int i = 1;
        DefaultMQProducer producer = new DefaultMQProducer("please_rename_unique_group_name");
        producer.start();

        Message msg = new Message("TopicTest",
                tag,
                ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET)
        );
// Set some properties.
        msg.putUserProperty("a", String.valueOf(i));

        SendResult sendResult = producer.send(msg);

        producer.shutdown();
    }
}
