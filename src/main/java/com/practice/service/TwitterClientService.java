package com.practice.service;

import com.twitter.hbc.core.Client;

import java.util.concurrent.BlockingQueue;

public interface TwitterClientService {

    public Client createClient(BlockingQueue<String> msgQueue);
}
