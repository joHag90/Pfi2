import java.util.Calendar;

public class ClockThread extends Thread {
	private ClockInterface clockInterface;
	
	public ClockThread(ClockInterface ci){
		this.clockInterface = ci;
	}
	
	public void run(){
		while (true){
			Calendar cal = Calendar.getInstance();
			clockInterface.update(cal.get(Calendar.HOUR_OF_DAY),(cal.get(Calendar.MINUTE)), (cal.get(Calendar.SECOND)));
		try {
			Thread.sleep(900);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		}
	}
}
	