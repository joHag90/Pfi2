import java.util.ArrayList;


public class Human {
	private Dog dog;
	private String name;
	private String error;
	
	public Human (String name){
		if (name.length() > 2){
			this.name = name;
		} else {
			error = "Ägarens namn måste vara minst 3 bokstäver långt.";
		}
	}
	
	public String getName(){
		return name;
	}
	
	public String getError(){
		return this.error;
	}
	
	public Dog buyDog(Dog newDog){
		return this.dog = dog;
	}
	
	/** 
	 * Returnerar: "x äger en hund som heter y" eller "x äger inte en hund"
	 * @return
	 */
	public String getInfo(){
			if(dog != null){
				return getName() + " äger en hund som heter " + dog.getName();
			} else {
				return getName() + " äger inte en hund";
			}

	}
}
