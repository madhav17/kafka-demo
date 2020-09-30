package com.practice.es.repository;

import com.practice.es.repository.Tweet;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface TweetRepository extends ElasticsearchRepository<Tweet, Long> {
}
