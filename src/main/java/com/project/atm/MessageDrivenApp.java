package com.project.atm;

public class MessageDrivenApp {
    public static void main(String[] args) throws InterruptedException {
        MessageQueue messageQueue = new MessageQueue();

        Producer producer1 = new Producer(messageQueue, "Message 1");
        Producer producer2 = new Producer(messageQueue, "Message 2");
        Consumer consumer1 = new Consumer(messageQueue);
        Consumer consumer2 = new Consumer(messageQueue);

        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();

        producer1.join();
        producer2.join();
        consumer1.join();
        consumer2.join();

        System.out.println("Total messages processed: " + messageQueue.getMessageCount());
        System.out.println("Total errors encountered: " + messageQueue.getErrorCount());
    }
}
