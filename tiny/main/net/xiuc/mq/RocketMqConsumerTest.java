package net.xiuc.mq;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * 消费者测试
 * Created by 秀川 on 16/5/6.
 */
public class RocketMqConsumerTest {
        public static void main(String[] args){
            DefaultMQPushConsumer consumer =
                    new DefaultMQPushConsumer("consumer");
            consumer.setNamesrvAddr("10.0.1.187:9876:9876");
            try {
                //订阅PushTopic下Tag为push的消息
                consumer.subscribe("test", "test1");
                //程序第一次启动从消息队列头取数据
                consumer.setConsumeFromWhere(
                        ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
                consumer.registerMessageListener(
                        new MessageListenerConcurrently() {
                            public ConsumeConcurrentlyStatus consumeMessage(
                                    List<MessageExt> list,
                                    ConsumeConcurrentlyContext Context) {
                                Message msg = list.get(0);
                                System.out.println(msg.toString());
                                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                            }
                        }
                );
                consumer.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
