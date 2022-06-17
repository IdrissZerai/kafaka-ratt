package com.idriss.kafkaspringbootconsumer.broker.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.idriss.kafkaspringbootconsumer.broker.event.EventOp;
import com.idriss.kafkaspringbootconsumer.mapper.JsonMapper;
import com.idriss.kafkaspringbootconsumer.properties.PropertiesCache;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class TopicConsumer {

    @KafkaListener(topics = "topic.comand.test", groupId = "group_id")
    public void listenGroupFoo(String message) throws IOException {
        System.out.println("Received Message in group group_id: " + message);
        EventOp eventOp = JsonMapper.readFromJson(message, EventOp.class);
        if (PropertiesCache.getInstance().getProperty("account.id").equals(String.valueOf(eventOp.getIdAcc())) &&
            eventOp.getStatus().equals("valid")){
            updateBalance(eventOp.getAmount());
        }
    }

    public void updateBalance(int amount) throws IOException {
        PropertiesCache cache = PropertiesCache.getInstance();
        int oldBalance = Integer.parseInt(PropertiesCache.getInstance().getProperty("account.balance"));
        int newBalance = oldBalance + amount;
        cache.setProperty("account.balance", ""+newBalance);
        PropertiesCache.getInstance().flush();
    }
}
