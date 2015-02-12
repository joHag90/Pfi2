
public class Cat extends Mammal{
	private int numberOfLives;
	
	public Cat(String latinName, int gestationTime, int numberOfLives, String friendlyName){
		super(latinName, gestationTime);
		this.numberOfLives = numberOfLives;
		super.setFriendlyName(friendlyName);
	}
	
	public int getNumberOfLives(){
		return numberOfLives;
	}
	
	public int setNumberOfLives(int i){
		return this.numberOfLives = i;
	}
	
	public String getInfo(){
		return "The cat, " + "\"" + getFriendlyName() + "\"" + ", latin: " + "\"" + getLatinName() + "\"," + " nurses for " + getGestationTime() + " month(s)" + " and has " + getNumberOfLives() + " lives.";
	}
}
