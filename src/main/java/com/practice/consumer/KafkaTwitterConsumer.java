package com.practice.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.config.KafkaDemoProperties;
import com.practice.dto.TweetDTO;
import com.practice.es.repository.Tweet;
import com.practice.es.repository.TweetRepository;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.practice.util.Util.convertToTweet;

@Component
public class KafkaTwitterConsumer {

    @Autowired
    private KafkaConsumer<String, String> consumer;

    @Autowired
    private KafkaDemoProperties properties;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TweetRepository tweetRepository;

    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Scheduled(fixedDelay = 1000, initialDelay = 30000)
    public void process() throws Exception {
        logger.info("Consumer Started");
        List<Tweet> batch = new ArrayList<>();

        ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
        if (!records.isEmpty()) {
            for (ConsumerRecord<String, String> record : records) {
                TweetDTO tweetDTO = objectMapper.readValue(record.value(), TweetDTO.class);
                batch.add(convertToTweet(tweetDTO));
            }
        }
        if (!batch.isEmpty()) {
            tweetRepository.saveAll(batch);
            consumer.commitSync();
        }

    }

}
