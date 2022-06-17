package com.idrisszerai.kafkaspringboot.broker.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.idrisszerai.kafkaspringboot.broker.event.EventOp;
import com.idrisszerai.kafkaspringboot.mapper.JsonMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Slf4j
@Service
public class TopicProducer {

    private String topicName;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Transactional("kafkaTransactionManager")
    public void send(EventOp eventOp) throws JsonProcessingException {
        log.info("Payload sent: {}", eventOp);
        topicName = "topic.status."+eventOp.getStatus();
        kafkaTemplate.send(topicName, JsonMapper.writeToJson(eventOp));
    }
}


