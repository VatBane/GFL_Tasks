package animals;

public class CrazyCat extends Cat{
    @Override
    public void voice() {
        System.out.println("Crazy cat says mmoof!");
    }

    public CrazyCat(String name) {
        super(name);
    }

    public CrazyCat(String name, int age) {
        super(name, age);
    }
}
