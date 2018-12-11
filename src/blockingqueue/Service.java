package blockingqueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
public class Service {
	public static void main(String [] args) {
		BlockingQueue<Message> queue = new ArrayBlockingQueue<>(10);
		Thread producer = new Thread(new Producer(queue), "producer");
		Thread consumer = new Thread(new Consumer(queue), "consumer");
		
		producer.start();
		consumer.start();
		
		System.out.println("Program started! ");
		
	}
}
