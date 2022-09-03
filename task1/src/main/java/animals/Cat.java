package animals;

public class Cat extends Animal{
    @Override
    public void voice() {
        System.out.println("Cat says meow!");
    }

    public Cat(String name) {
        super(name);
    }

    public Cat(String name, int age) {
        super(name, age);
    }
}
