package multithreading;

public class ThreadSleep {
 /*
 Thread.sleep() method can be used to pause the execution of current thread for 
 specified time in milliseconds.
 */
    public static void main(String [] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(2000);
        System.out.println("Sleep time is " + (System.currentTimeMillis()-start));
    }
}
