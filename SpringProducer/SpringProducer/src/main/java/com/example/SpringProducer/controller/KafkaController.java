package com.example.SpringProducer.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.SpringProducer.service.TopicProducer;

@RestController
@AllArgsConstructor



public class KafkaController {
    private final TopicProducer topicProducer;
    @RequestMapping(value = "/kafka")
    public void send(){
        topicProducer.send("Mensagem de teste enviada ao tópico");
    }
}
