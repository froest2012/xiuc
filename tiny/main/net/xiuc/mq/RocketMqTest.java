package net.xiuc.mq;

import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.exception.RemotingException;

/**
 * RocketMq 测试
 * Created by 秀川 on 16/5/5.
 */
public class RocketMqTest {

    public static void main(String[] args) {
        DefaultMQProducer producer = new DefaultMQProducer("producer_group");
        producer.setNamesrvAddr("10.0.1.107:9876");
        try{
            producer.start();
//            producer.createTopic("order1","test", 1);
//            for (int i = 0; i < 1000; i++) {
//                Message message = new Message("test", "test"+i, "order"+i, ("我是测试人员"+i).getBytes());
                Message message = new Message("test", "test993", "order993", ("我是测试人员"+993).getBytes());
                SendResult result = producer.send(message);
                System.out.println("messageId : " + result.getMsgId() + ", 发送状态 :" + result.getSendStatus());
//            }
        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (MQBrokerException e) {
            e.printStackTrace();
        }
    }
}
