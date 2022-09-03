package animals;

public class AngryDog extends Dog {
    @Override
    public void voice() {
        System.out.println("Angry dog says woof!");
    }

    public AngryDog(String name) {
        super(name);
    }

    public AngryDog(String name, int age) {
        super(name, age);
    }
}
