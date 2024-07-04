import org.junit.Test;
import static org.junit.Assert.*;

public class ProducerTest {
    @Test
    public void testProducerSuccess() throws InterruptedException {
        MessageQueue messageQueue = new MessageQueue();
        Producer producer = new Producer(messageQueue, "Test Message");
        producer.start();
        producer.join();
        assertEquals(1, messageQueue.getMessageCount());
    }
}
