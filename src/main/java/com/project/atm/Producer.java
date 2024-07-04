package com.project.atm;

public class Producer extends Thread {
    private MessageQueue messageQueue;
    private String message;

    public Producer(MessageQueue messageQueue, String message) {
        this.messageQueue = messageQueue;
        this.message = message;
    }

    @Override
    public void run() {
        try {
            messageQueue.produce(message);
            messageQueue.incrementMessageCount();
            System.out.println("Produced: " + message);
        } catch (Exception e) {
            messageQueue.incrementErrorCount();
            System.err.println("Error producing message: " + e.getMessage());
        }
    }
}
