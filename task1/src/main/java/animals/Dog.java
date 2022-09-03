package animals;

public class Dog extends Animal{
    @Override
    public void voice() {
        System.out.println("Dog says woof!");
    }

    public Dog(String name) {
        super(name);
    }

    public Dog(String name, int age) {
        super(name, age);
    }
}
