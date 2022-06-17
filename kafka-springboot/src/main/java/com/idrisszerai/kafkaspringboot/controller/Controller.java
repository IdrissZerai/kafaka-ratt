package com.idrisszerai.kafkaspringboot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.idrisszerai.kafkaspringboot.broker.event.EventOp;
import com.idrisszerai.kafkaspringboot.broker.producer.TopicProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class Controller {
    @Autowired
    private TopicProducer topicProducer;
    @GetMapping(value = "/send")
    public void send(@RequestBody EventOp event) throws JsonProcessingException {
        topicProducer.send(event);
    }
}
