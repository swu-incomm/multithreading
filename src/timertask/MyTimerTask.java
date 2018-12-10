package timertask;
import java.util.*;
public class MyTimerTask extends TimerTask{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Timer task started at: " + new Date());
		completeTask();
		System.out.println("Timer task finished at " + new Date());
	}
	private void completeTask() {
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String [] args) {
		TimerTask timerTask = new MyTimerTask();
		
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(timerTask, 0, 10*1000);
		
		System.out.println("TimerTask started. ");
		
		try {
			Thread.sleep(1000000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		timer.cancel();
		System.out.println("TimerTask cancelled. ");
		
		try {
			Thread.sleep(10000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}	
	}
	
}
