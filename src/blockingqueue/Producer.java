package blockingqueue;
import java.util.concurrent.BlockingQueue;


//Producer will create the messages and put them in the queue
public class Producer implements Runnable {
	
	private BlockingQueue<Message> queue;
	
	public Producer(BlockingQueue<Message> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++) {
			Message msg = new Message(" "+i);
			try{
				Thread.sleep(i);
				queue.put(msg);
				System.out.println("Produced " + msg.getMsg());
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		Message msg = new Message("exit");
		
		try{
			queue.put(msg);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
