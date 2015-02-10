import java.util.ArrayList;


public class Human {
	private Dog dog;
	private String name;
	
	public Human (String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void buyDog(Dog newDog){
		newDog = new Dog(newDog.getName());
	}
	
	/** 
	 * Returnerar: "x äger en hund som heter y" eller "x äger inte en hund"
	 * @return
	 */
	public String getInfo(){
		String s;
		s = this.getName() + " äger en hund som heter " + dog.getName();
		return s;
	}
}
