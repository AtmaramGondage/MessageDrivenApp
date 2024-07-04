
import org.junit.Test;
import static org.junit.Assert.*;

public class ConsumerTest {
	@Test
	public void testConsumerSuccess() throws InterruptedException {
		MessageQueue messageQueue = new MessageQueue();
		Producer producer = new Producer(messageQueue, "Test Message");
		producer.start();
		producer.join();

		Consumer consumer = new Consumer(messageQueue);
		consumer.start();
		consumer.join();

		assertEquals(1, messageQueue.getMessageCount());
		assertEquals(0, messageQueue.getErrorCount());
	}

	@Test
	public void testConsumerFailure() throws InterruptedException {
		MessageQueue messageQueue = new MessageQueue();
		Consumer consumer = new Consumer(messageQueue);
		consumer.start();
		consumer.join();

		assertEquals(0, messageQueue.getMessageCount());
		assertEquals(1, messageQueue.getErrorCount());
	}
}
