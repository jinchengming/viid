package com.dyne.viid;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@Slf4j
class ViidApplicationTests {

    @Autowired
    AmqpAdmin amqpAdmin;


    @Test
    void createExchange() {

        DirectExchange directExchange = new DirectExchange("alarm-msg-1400", true, false);
        // 支持延时推送
//        directExchange.setDelayed(true);
        amqpAdmin.declareExchange(directExchange);
        log.info("创建交换机：{} 成功", "alarm-msg-1400");

    }

    @Test
    void createQueue() {
        Queue queue = new Queue("alarm-1400-queue",
                true,
                false,// 排他，被一个交换机绑定就不能被其他交换机绑定了
                false);
        amqpAdmin.declareQueue(queue);
        log.info("创建队列：{} 成功", "alarm-1400-queue");
    }

    @Test
    void bindQueueToExchange() {
        Binding binding = new Binding("alarm-1400-queue",
                Binding.DestinationType.QUEUE,
                "alarm-msg-1400",
                "alarm.msg", null);
        amqpAdmin.declareBinding(binding);
        log.info("绑定关系建立成 {} - {}", "alarm-msg-1400", "alarm-1400-queue");
    }


}
