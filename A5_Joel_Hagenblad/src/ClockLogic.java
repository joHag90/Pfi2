
public class ClockLogic implements ClockInterface {

	private DigitalClockGUI clockGUI;
	private int alarmHour; 
	private int alarmMinute; 

	
	public ClockLogic(DigitalClockGUI clockIn){
	this.clockGUI = clockIn;
	
	Thread t = new ClockThread(this);
	t.start();
	
	}
	
	public void setAlarm(int hours, int minutes) {
		this.alarmHour = hours;
		this.alarmMinute = minutes; 
	}
	
	public void clearAlarm(){
		this.alarmHour = 100;
		this.alarmMinute = 100;
	}


	public void update(int hours, int minutes, int seconds) {
		String s1 = "";
		  String s2 = "";
		  String s3 = "";
		  
		  if (hours < 10){
		   s1 = "0";
		  }
		  if (minutes < 10){
		   s2 = "0";
		  }
		  if (seconds < 10){
		   s3 = "0";
		  }
		  

		  String hourString = s1 + Integer.toString(hours);
		  String minuteString = s2 + Integer.toString(minutes);
		  String secondString = s3 + Integer.toString(seconds);
		  String finalTimeString = hourString + ":" + minuteString + ":"
				  + secondString;

		  clockGUI.setTimeOnLabel(finalTimeString);

		  s1 = "";
		  s2 = "";
		  s3 = "";

		

		  if (this.alarmHour == hours && this.alarmMinute == minutes) {
			  System.out.println("Alarm on!");
			  clockGUI.alarm(true);


	}
}
}