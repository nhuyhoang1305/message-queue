package com.hh1305.message_queue.app;

import com.hh1305.message_queue.config.Config;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		Config config = new Config();

		config.loadFromProperties("config.properties");

		MessageQueue messageQueue = new MessageQueue(config.getMaxSize());

		Producer[] producers = new Producer[config.getNumberOfProducers()];

		for (int i = 0; i < producers.length; ++i) {
			producers[i] = new Producer(messageQueue);
			producers[i].setTime(config.getTimePush());
		}

		Consumer[] consumers = new Consumer[config.getNumberOfConsumers()];

		for (int i = 0; i < consumers.length; ++i) {
			consumers[i] = new Consumer(messageQueue);
			consumers[i].setTime(config.getTimePull());
		}

		Thread[] threads = new Thread[config.getNumberOfProducers() + config.getNumberOfConsumers()];
		for (int i = 0; i < threads.length; ++i) {
			if (i < config.getNumberOfProducers()) {
				threads[i] = new Thread(producers[i], "Producer-" + i);
			} else {
				threads[i] = new Thread(consumers[i - config.getNumberOfProducers()],
						"Consumer-" + (i - config.getNumberOfProducers()));
			}
		}

		for (int i = 0; i < threads.length; ++i) {
			threads[i].start();
		}

	}
}
