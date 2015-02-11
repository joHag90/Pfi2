
public class Cat extends Mammal{
	private int numberOfLives;
	
	public Cat(String latinName, int numberOfLives){
		this.latinName = super.latinName;
		this.numberOfLives = numberOfLives;
	}
	
	public int getNumberOfLives(){
		return numberOfLives;
	}
	
	public int setNumberOfLives(){
		
	}
}
