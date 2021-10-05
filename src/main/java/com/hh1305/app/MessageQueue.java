package com.hh1305.app;

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
		notify();
		
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
		notify();
		return messages.remove();
	}
	

	public synchronized int size() {
		return messages.size();
	}
	
}
