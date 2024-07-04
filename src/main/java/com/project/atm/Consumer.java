package com.project.atm;

public class Consumer extends Thread {
    private MessageQueue messageQueue;

    public Consumer(MessageQueue messageQueue) {
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
        try {
            String message = messageQueue.consume();
            System.out.println("Consumed: " + message);
        } catch (InterruptedException e) {
            messageQueue.incrementErrorCount();
            System.err.println("Error consuming message: " + e.getMessage());
        }
    }
}
