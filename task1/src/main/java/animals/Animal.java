package animals;

public abstract class Animal {
    private String name;
    private int age;

    public Animal(String name) {
        // допустим мы знаем только имя,
        // поэтому автоматически сделаем будто животному 1 год
        this(name, 1);
    }

    public Animal(String name, int age) {
        // если не дали имя обозвем "безымянным"
        this.name = name.isBlank() ? "Noname" : name;

        // если неправильно указан возраст поставим 1 год
        this.age = age <= 0 ? 1 : age;
    }

    public abstract void voice();

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
