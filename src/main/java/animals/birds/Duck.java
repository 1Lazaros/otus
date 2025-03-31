package animals.birds;

import animals.Animal;
import animals.Flyable;

public class Duck extends Animal implements Flyable {
    public Duck(String name, int age, int weight, String color) {
        super(name, age, weight, color);
    }

    @Override
    public void say() {
        System.out.println("Кря");
    }

    @Override
    public void fly() {
        System.out.println("Я лечу");
    }
}

