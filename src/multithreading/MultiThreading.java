package multithreading;

public class MultiThreading implements Runnable{
    
    /*
        new
        runnable
        running
        blocked/waiting
        dead
    */
    @Override 
    public void run() {
        System.out.println("Start thread: " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
            dbProcessing();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread ended:::" + Thread.currentThread().getName());
    }
    private void dbProcessing() throws InterruptedException {
        Thread.sleep(5000);
    }
}
