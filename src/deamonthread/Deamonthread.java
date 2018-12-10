package deamonthread;

public class Deamonthread {
	public static void main (String [] args) throws InterruptedException {
		Thread dt = new Thread(new TestThread(), "dt");
		dt.setDaemon(true);
		dt.start();
		
		Thread.sleep(12000);
		System.out.println("Finishing program.");
	}
}

class TestThread implements Runnable {
	@Override 
	public void run() {
		while(true) {
			processSomething();
		}
	}
	
	private void processSomething() {
		try {
			System.out.println("Processing deamon thread in an infinity loop. ");
			Thread.sleep(2000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
