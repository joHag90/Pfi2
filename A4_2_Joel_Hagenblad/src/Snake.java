
public class Snake extends Animal{
	
	private boolean poisonous;
	
	public Snake(String latinName, boolean poisonous){
		super(latinName);
		this.poisonous = poisonous;
		super.setFriendlyName(getFriendlyName());
	}
	
	public boolean isPoisonous(){
		return poisonous;
	}
	
	public String getInfo(){
		String poison;
		if (poisonous != true){
			poison = "isn't";
		} else {
			poison = "is";
		}
		return "The snake, " + "\"" + getFriendlyName() + "\"" + ", latin: " + "\"" + getLatinName() + "\", " + poison + " poisonous.";
	}
	
}
