package com.practice.producer;

import com.practice.config.KafkaDemoProperties;
import com.practice.service.TwitterClientService;
import com.twitter.hbc.core.Client;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

@Component
public class KafkaTwitterProducer {

    @Autowired
    private KafkaProducer<String, String> producer;

    @Autowired
    private TwitterClientService twitterClientService;

    @Autowired
    private KafkaDemoProperties properties;

    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

//    @Scheduled(fixedDelay = 86400000, initialDelay = 30000)
//    public void process() throws Exception {
//        logger.info("Producer started");
//        BlockingQueue<String> msgQueue = new LinkedBlockingQueue<String>(100000);
//        Client client = twitterClientService.createClient(msgQueue);
//        while (!client.isDone()) {
//            try {
//                String msg = msgQueue.poll(5, TimeUnit.SECONDS);
//                ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>(properties.getTopic(), msg);
//                producer.send(producerRecord, new Callback() {
//                    @Override
//                    public void onCompletion(RecordMetadata recordMetadata, Exception e) {
//                        if (Objects.nonNull(e)) {
//                            logger.error("Unable to push message");
//                        }
//                    }
//                });
//                producer.flush();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        client.stop();
//    }
}
