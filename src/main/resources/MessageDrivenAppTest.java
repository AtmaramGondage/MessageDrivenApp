
import org.junit.Test;
import static org.junit.Assert.*;

public class MessageDrivenAppTest {
    @Test
    public void testMessageDrivenApp() throws InterruptedException {
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

        assertEquals(2, messageQueue.getMessageCount());
        assertEquals(0, messageQueue.getErrorCount());
    }
}
