package com.dodo.rabbitmq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author lwh
 * @date 2023-09-26 10:06:18
 * @describe --
 */
@Slf4j
@Component
@RabbitListener(queues = "testDirectQueue")
public class DirectReceiver {

    @RabbitHandler
    public void process(Map testMessage) {
        log.info("第一个DirectReceiver消费者接收到到消息：{}", testMessage.toString());
    }
}
