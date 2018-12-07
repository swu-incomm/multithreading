package multithreading;

public class ThreadRun {
    public static void main(String [] args) {
        Thread t1 = new Thread(new MultiThreading(),"t1");
        Thread t2 = new Thread(new MultiThreading(),"t2");
        t1.start();
        t2.start();
    }
}
