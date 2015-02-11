# Pfi2

Kommentarer
 =======
 
 Assignment 4.1
 -----------
 
 Anledning till att du får errors av Human.getInfo:
 I classen Human har du en instans av Dog som heter dog. 
 Denna försöker du hämta namnet på i getinfo med hjälp av dog.getName().
 Problemet är att den inte kan retunera name eftersom den inte blivit tilldelat ett.
 I buyDog(Dog newDog) överför du inte det skapade objektets attribut till Dog dog.
 Se exemplet nedan:

	public class Human {
	private Dog dog;   //<---- denna får aldrig något värde
	private String name;
	
	public Human (String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void buyDog(Dog newDog){  //<---- i din GUI class så skapar du en ny instans av Dog i denna metodens inparameter
		newDog = new Dog(newDog.getName()); //<---- pga ovanstående anledning så är detta onödigt
		//this.dog = newDog;  <---- detta överför attributen som du ger Dog i din GUI class till instansen av Dog i denna classen
	}
	
	/** 
	 * Returnerar: "x Ã¤ger en hund som heter y" eller "x Ã¤ger inte en hund"
	 * @return
	 */
	public String getInfo(){
		String s;
		s = this.getName() + " Ã¤ger en hund som heter " + dog.getName();
		return s;
	}
}
