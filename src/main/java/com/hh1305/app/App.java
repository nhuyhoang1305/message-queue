package com.hh1305.app;

import com.hh1305.config.Config;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		Config config = new Config();
		
		if (args.length == 3) {
			config.setMaxSize(Integer.valueOf(args[0]));
			config.setTimePush(Integer.valueOf(args[1]));
			config.setTimePull(Integer.valueOf(args[2]));
		}
		
		MessageQueue messageQueue = new MessageQueue(config.getMaxSize());
		Producer producer = new Producer(messageQueue);
		producer.setTime(config.getTimePush());
		Thread t1 = new Thread(producer, "Producer");
		Consumer consumer = new Consumer(messageQueue);
		consumer.setTime(config.getTimePull());
		Thread t2 = new Thread(consumer, "Consumer");
		
		
		t2.start();
		t1.start();
		
	}
}
