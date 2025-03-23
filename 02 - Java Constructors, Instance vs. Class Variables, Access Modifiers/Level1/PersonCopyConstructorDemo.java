package Day7.Level1;
import java.util.Scanner;
class Person{
    String name;
    int age;
    double height;

    Person(String name, int age, double height){
        this.name = name;
        this.age = age;
        this.height = height;
    }
    void Description1(){
        System.out.println("My name is "+name+
                "\nMy age is "+age+
                "\nMy height is "+height);
    }
    Person(Person new_person){
        this.name = new_person.name;
        this.age = new_person.age;
        this.height = new_person.height;
    }
    void Description2() {
        System.out.println("Copy Constructor...");
        System.out.println("My name is " + name +
                "\nMy age is " + age +
                "\nMy height is " + height);
    }
}
public class PersonCopyConstructorDemo {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name: ");
        String name = sc.nextLine();
        System.out.println("Enter age: ");
        int age = sc.nextInt();
        System.out.println("Enter height in cm..");
        double height = sc.nextDouble();
        Person p = new Person(name,age,height);
        p.Description1();
        p.Description2();
        sc.close();
    }
}



