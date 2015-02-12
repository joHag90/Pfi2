
public class Dog extends Mammal{
	
	private boolean stupid;
	
	public Dog(String latinName, int gestationTime, boolean stupid){
		super(latinName, gestationTime);
		this.stupid = stupid;
	}
	
	public Dog(String latinName, int gestationTime, boolean stupid, String friendlyName){
		super(latinName, gestationTime);
		super.setFriendlyName(friendlyName);
		this.stupid = stupid;
	}
	
	public boolean isStupid(){
		return stupid;
	}
	
	public String getInfo(){
		String stupid;
		if (this.stupid != true){
			stupid = "isn't";
		} else {
			stupid = "is";
		}
		return "The dog, " + "\"" + getFriendlyName() + "\"" + ", latin: " + "\"" + getLatinName() + "\"," + " nurses for " + getGestationTime() + " month(s)" + " and " + stupid + " stupid.";		
	}
}
