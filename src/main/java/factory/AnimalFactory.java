package factory;

import animals.Animal;
import animals.birds.Duck;
import animals.pets.Cat;
import animals.pets.Dog;
import data.AnimalTypeData;

public class AnimalFactory {
    private String name;
    private int age;
    private int weight;
    private String color;

    public AnimalFactory(String name, int age, int weight, String color) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }

    public Animal create(AnimalTypeData animalTypeData) {
        switch (animalTypeData) {
            case CAT: {
                return new Cat(name, age, weight, color);
            }
            case DOG: {
                return new Dog(name, age, weight, color);
            }
            case DUCK: {
                return new Duck(name, age, weight, color);
            }
        }
        return null;
    }
}
