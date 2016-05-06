package net.xiuc.mq;

import com.alibaba.rocketmq.client.QueryResult;
import com.alibaba.rocketmq.client.consumer.DefaultMQPullConsumer;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.alibaba.rocketmq.common.message.MessageQueue;

import java.util.List;

/**
 * Created by 秀川 on 16/5/6.
 */
public class PullConsumerTest {
    public static void main(String[] args) throws MQClientException, InterruptedException {
        DefaultMQPullConsumer pullConsumer = new DefaultMQPullConsumer("consumer1");
        pullConsumer.setNamesrvAddr("10.0.1.187:9876");
        pullConsumer.start();
        QueryResult queryResult = pullConsumer.queryMessage("test","order1",10000,1462517033,1462519983);
        List<MessageExt> list = queryResult.getMessageList();
    }
}
