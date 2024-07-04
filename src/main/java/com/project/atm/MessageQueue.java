package com.project.atm;

import java.util.LinkedList;
import java.util.Queue;

public class MessageQueue {
	private Queue<String> queue = new LinkedList<>();
	private int messageCount = 0;
	private int errorCount = 0;

	public synchronized void produce(String message) {
		queue.add(message);
		notifyAll();
	}

	public synchronized String consume() throws InterruptedException {
		while (queue.isEmpty()) {
			wait();
		}
		return queue.poll();
	}

	public synchronized void incrementMessageCount() {
		messageCount++;
	}

	public synchronized void incrementErrorCount() {
		errorCount++;
	}

	public int getMessageCount() {
		return messageCount;
	}

	public int getErrorCount() {
		return errorCount;
	}
}
