package com.hh1305.message_queue.app;

import java.util.LinkedList;
import java.util.Queue;

public class MessageQueue {

	private int maxSize;
	Queue<Message> messages;

	public MessageQueue(int maxSize) {
		this.maxSize = maxSize;
		messages = new LinkedList<Message>();
	}

	public synchronized void pushMessage(Message message) {

		while (messages.size() == maxSize) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		messages.add(message);
		notifyAll();

	}

	public synchronized Message remove() {

		while (messages.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		notifyAll();
		return messages.remove();
	}

	public synchronized int size() {
		return messages.size();
	}

}
