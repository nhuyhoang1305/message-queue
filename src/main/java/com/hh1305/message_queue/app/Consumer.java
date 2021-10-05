package com.hh1305.message_queue.app;

public class Consumer implements Runnable {

	private MessageQueue messageQueue;
	private int timeToPull = 3;

	public Consumer(MessageQueue mQ) {
		messageQueue = mQ;
	}

	@Override
	public void run() {
		while (true) {
			try {

				Message message = pullMessage();
				printMessage(message);
				Thread.sleep(timeToPull * 1000);

			} catch (InterruptedException e) {
				System.out.println(e.toString());
			}
		}
	}

	public void setTime(int time) {
		this.timeToPull = time;
	}

	public Message pullMessage() {
		return messageQueue.remove();
	}

	public void printMessage(Message message) {
		System.out.println(Thread.currentThread().getName() + " got " + message.toString());
	}

}
