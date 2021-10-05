package com.hh1305.message_queue.app;

import com.hh1305.message_queue.utils.Generate;

public class Producer implements Runnable {

	private MessageQueue messageQueue;
	private int timeToGenerate = 1;

	public Producer(MessageQueue mQ) {
		messageQueue = mQ;
	}

	public void setTime(int time) {
		timeToGenerate = time;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Message message = generateMessage();
				pushMessage(message);
				Thread.sleep(timeToGenerate * 1000);
			} catch (InterruptedException e) {
				System.out.println(e.toString());
			}
		}
	}

	public Message generateMessage() {
		return Generate.generateMessage();
	}

	public void pushMessage(Message message) {
		// System.out.println(Thread.currentThread().getName() + " added " +
		// message.toString());
		messageQueue.pushMessage(message);
	}
}
