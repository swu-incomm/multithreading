package concurrency;

public class Message {
    /*
        Three methods allow threads to communicate about the lock status of a resource.
        object.wait() to suspend a thread to wait until some other thread invokes notify() on the same object 
        object.notify() wakes up only one thread that waiting on the object 
        object.notifyAll() wakes up all the threads waiting on the object
    */
	private String msg;
	public Message(String msg) {
		this.msg = msg;
	}
	
	public String getMessage() {
		 return this.msg;
	}
	public void setMessage(String msg) {
		this.msg = msg;
	}
}
