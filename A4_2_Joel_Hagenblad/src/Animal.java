
public abstract class Animal {
	private String latinName;
	private String friendlyName;
	
	public Animal(String latinName){
		this.latinName = latinName;
	}
	
	public abstract String getInfo(){
		
	}
	
	public void setFriendlyName(String name){
		
	}
	
	public String getFriendlyName(){
		return friendlyName;
	}
}
