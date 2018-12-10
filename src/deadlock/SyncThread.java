package deadlock;

//To avoid dead lock, try not using nest lock on objects
public class SyncThread implements Runnable {
	private Object obj1;
	private Object obj2;

	public SyncThread(Object obj1, Object obj2) {
		this.obj1 = obj1;
		this.obj2 = obj2;
	}

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println(name + " acquiring lock on " + obj1);
		synchronized (obj1) {
			System.out.println(name + " got lock on " + obj1);
			work();
			System.out.println(name + " acquiring lock on " + obj2);
			synchronized (obj2) {
				System.out.println(name + " got lock on " + obj1);
				work();
			}
			System.out.println(name + " release lock on " + obj2);
		}
		System.out.println(name + " release lock on " + obj1);
		System.out.println(name + " finished execution. ");
	}

	private void work() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
