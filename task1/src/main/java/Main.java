import animals.*;

public class Main {
    public static void main(String[] args) {
        Animal[] animals =  {
                new Cat("", 1),
                new Dog("Barsik", 1),
                new AngryDog("", 0),
                new Cow("Buryonka", 5),
                new AngryDog(""),
                new Cat("Murka", 3),
                new CrazyCat(""),
        };

        for (Animal animal: animals) {
            animal.voice();

            // проверил данные внутри объектов
//            System.out.println(animal.toString());
        }
    }
}
