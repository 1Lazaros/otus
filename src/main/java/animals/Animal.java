package animals;

public abstract class Animal {
    private String name;
    private int age;
    private int weight;
    private String color;

    public Animal(String name, int age, int weight, String color) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void say() {
        System.out.println("Я говорю");
    }


    public String getYearsText(int age) {
        if (age == 1) {
            return "год";
        } else if (age >= 2 && age <= 4) {
            return "года";
        } else {
            return "лет";
        }
    }

    /*
    Привет! Меня зовут name, мне age лет, я вешу weight кг, мой цвет color.
     */
    @Override
    public String toString() {
        return "Привет! Меня зовут " + name + " мне " + age + " " + getYearsText(age) + ", я вешу " + weight + " кг, мой цвет " + color;
    }


}
