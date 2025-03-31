import animals.Animal;
import data.AnimalTypeData;
import data.CommandsData;
import factory.AnimalFactory;
import tools.NumberTools;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private ArrayList<String> animals = new ArrayList<String>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();

        while (true) {
            List<String> nameStr = new ArrayList<>();
            for (CommandsData commandsData : CommandsData.values()) {
                nameStr.add(commandsData.name().toLowerCase());
            }
            System.out.println(String.format("Введите команду: %s", String.join("/", nameStr)));
            String userCommand = scanner.next().trim().toUpperCase();
            String userCommandUpperCase = userCommand.toUpperCase();
            boolean isCommandExist = false;
            for (CommandsData commandsData : CommandsData.values()) {
                if (userCommandUpperCase.equals(commandsData.name())) {
                    isCommandExist = true;
                    break;
                }
            }
            if (!isCommandExist) {
                System.out.printf("Команда %s не поддерживается \n", userCommand);
                continue;
            }
            switch (CommandsData.valueOf(userCommand)) {
                case ADD: {
                    while (true) {
                        List<String> type = new ArrayList<>();
                        for (AnimalTypeData animalTypeData : AnimalTypeData.values()) {
                            nameStr.add(animalTypeData.name().toLowerCase());
                        }
                        System.out.println(String.format("Какое животное вы хотите добавить cat / dog / duck: %s", String.join("/", type)));
                        String animalType = scanner.next().trim().toUpperCase();
                        String animalTypeUpperCase = animalType.toUpperCase();
                        boolean isTypeExist = false;
                        for (AnimalTypeData animalTypeData : AnimalTypeData.values()) {
                            if (animalTypeUpperCase.equals(animalTypeData.name())) {
                                isTypeExist = true;
                                break;
                            }
                        }
                        if (!isTypeExist) {
                            System.out.printf("Тип %s не поддерживается \n", animalType);

                        }

                        System.out.println("Как зовут животное?");
                        String animalName = scanner.next();

                        NumberTools validateAge = new NumberTools();
                        String animalAge = null;
                        do {
                            System.out.println("Сколько лет животному?");
                            animalAge = scanner.next();
                            if (!validateAge.isNumber(animalAge))
                                System.out.println("Недопустимое значение для возраста. Повторите ввод.");

                        } while (!validateAge.isNumber(animalAge));

                        NumberTools validateWeight = new NumberTools();
                        String animalWeight = null;
                        do {
                            System.out.println("Сколько весит животное?");
                            animalWeight = scanner.next();
                            if (!validateWeight.isNumber(animalWeight))
                                System.out.println("Недопустимое значение для веса. Повторите ввод.");

                        } while (!validateWeight.isNumber(animalWeight));
                        System.out.println("Какой цвет животного?");
                        String color = scanner.next();

                        AnimalFactory animalFactory = new AnimalFactory(animalName, Integer.parseInt(animalAge), Integer.parseInt(animalWeight), color);
                        Animal animal = animalFactory.create(AnimalTypeData.valueOf(animalType));
                        animals.add(animal);
                        animal.say();
                        break;
                    }

                }

                case LIST: {
                    for (Animal animal : animals) {
                        System.out.println(animal.toString());
                    }
                    break;
                }
                case EXIT: {
                    System.exit(0);
                }

            }
        }
    }
}
