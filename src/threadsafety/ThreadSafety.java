package threadsafety;

//multiple threads are updating the shared data
public class ThreadSafety {
	public static void main(String [] args) throws InterruptedException {
		ProcessingThread pt = new ProcessingThread();
		Thread t1 = new Thread(pt, "t1");
		Thread t2 = new Thread(pt, "t2");
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		System.out.println("Processing count=" + pt.getCount());
	}
}

class ProcessingThread implements Runnable {
	private int count = 0;
	private Object lock = new Object();
	@Override 
	public void run() {
		synchronized(lock) {
			for(int i=1;i<5;i++) {
				processingSomething(i);
				count++;
			}
		}
	}
	
	private void processingSomething(int i) {
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public int getCount() {
		return this.count;
	}
}
