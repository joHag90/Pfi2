
public abstract class Mammal extends Animal{

	private int gestationTime;
	
	public abstract Mammal(String latinName, int gestationTime){
		this.latinName = super.latinName;
		this.gestationTime = gestationTime;
	}
	
	public int getGestationTime(){
		return gestationTime;
	}
}
