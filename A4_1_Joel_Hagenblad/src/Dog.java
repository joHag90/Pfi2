
public class Dog {
	private String name;
	public String dogError;
	
	public Dog(String name){
		if (name.length() > 3){
			this.name = name;
		} else {
			dogError = "Hundens namn måste vara minst 3 bokstäver";
			name = null;
			this.name = name;
		}
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getError(){
		return dogError;
	}
}
