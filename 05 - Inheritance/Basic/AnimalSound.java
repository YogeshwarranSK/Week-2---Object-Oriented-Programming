package Day10;

class Animal {
    String name;
    int age;

    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    void makeSound() {
        System.out.println("Some generic animal sound");
    }
}

class Dog extends Animal {

    Dog(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() {
        System.out.println(name + " (Dog): Barks!");
    }
}

class Cat extends Animal {

    Cat(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() {
        System.out.println(name + " (Cat): Meow!");
    }
}
class Bird extends Animal {

    Bird(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() {
        System.out.println(name + " (Bird) : Chirps!");
    }
}

public class AnimalSound {
    public static void main(String[] args) {
        Dog dog = new Dog("Shiro", 3);
        Cat cat = new Cat("Snowbell", 2);
        Bird bird = new Bird("Chickoo", 1);


        dog.makeSound();
        cat.makeSound();
        bird.makeSound();
    }
}