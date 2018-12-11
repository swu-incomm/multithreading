package threadpool;

public class WorkerThread implements Runnable{
	
	private String command;
	public WorkerThread (String str) {
		this.command = str;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName() + " has started with command " + command);
		processCommand();
		System.out.println(Thread.currentThread().getName() + " has ended");
	}
	
	private void processCommand() {
		try {
			Thread.sleep(5000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		return this.command;
	}
	
}
