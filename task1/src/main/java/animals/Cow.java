package animals;

public class Cow extends Animal {
    @Override
    public void voice() {
        System.out.println("Moo!");
    }

    public Cow(String name) {
        super(name);
    }

    public Cow(String name, int age) {
        super(name, age);
    }
}
