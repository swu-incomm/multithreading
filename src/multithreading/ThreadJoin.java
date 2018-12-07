package multithreading;

public class ThreadJoin {
    /*
    Thread.join() method can be used to pause the current thread execution until unless
    the specified thread is dead. 
    public final join()
    public final synchronized void join(long mills)
    */
    
    public static void main(String [] args) {
        Thread t1 = new Thread(new MultiThreading(), "t1");
        Thread t2 = new Thread(new MultiThreading(), "t2");
        Thread t3 = new Thread(new MultiThreading(), "t3");
        
        t1.start();
        
        //start second thread after waiting for 2 seconds or if it's dead
        try {
            t1.join(2000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        
        t2.start();
        
        //start third thread only when first thread is dead
        
        try {
            t1.join();
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
        
        //start third thread only when first thread is dead
        try {
            t1.join();
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
        
        t3.start();
        
        try {
            t1.join();
            t2.join();
            t3.join();
        }  catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("All threads are dead, exiting main thread");    
    }
    
}
