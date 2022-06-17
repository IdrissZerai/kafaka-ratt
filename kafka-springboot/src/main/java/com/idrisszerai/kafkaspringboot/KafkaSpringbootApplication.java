package com.idrisszerai.kafkaspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class KafkaSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaSpringbootApplication.class, args);
    }

}
