
public class TestKlass {

	public static void main(String[] args) {
		Human human; 
		Dog dog;
		
		human = new Human("Peter");
		
		human.buyDog(dog = new Dog("Fluffy"));
		
		System.out.println(human.getName() + " har en hund som heter " + dog.getName());
		
		
	}

}
