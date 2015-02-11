
public class Snake extends Animal{
	
	private boolean poisonous;
	
	public Snake(String latinName, boolean poisonous){
		this.latinName = super.latinName;
	}
	
	public boolean isPoisonous(){
		if (this.poisonous == true){
			return true;
		} else {
			return false;
		}
	}
	
}
