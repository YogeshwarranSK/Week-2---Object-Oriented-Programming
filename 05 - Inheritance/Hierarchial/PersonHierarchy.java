package Day10.Hierarchial;
import java.util.Scanner;
class Person {
    protected String name;
    protected int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
class Teacher extends Person {
    private String subject;
    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }
    public void displayRole() {
        displayInfo();
        System.out.println("Role: Teacher");
        System.out.println("Subject: " + subject);
    }
}
class Student extends Person {
    private String grade;
    public Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }
    public void displayRole() {
        displayInfo();
        System.out.println("Role: Student");
        System.out.println("Grade: " + grade);
    }
}
class Staff extends Person {
    private String department;
    public Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }
    public void displayRole() {
        displayInfo();
        System.out.println("Role: Staff");
        System.out.println("Department: " + department);
    }
}
public class PersonHierarchy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Select Role (1-Teacher, 2-Student, 3-Staff): ");
        int choice = sc.nextInt();
        sc.nextLine();
        if(choice == 1) {
            System.out.print("Enter Subject: ");
            String subject = sc.nextLine();
            Teacher t = new Teacher(name, age, subject);
            t.displayRole();
        } else if(choice == 2) {
            System.out.print("Enter Grade: ");
            String grade = sc.nextLine();
            Student s = new Student(name, age, grade);
            s.displayRole();
        } else if(choice == 3) {
            System.out.print("Enter Department: ");
            String dept = sc.nextLine();
            Staff st = new Staff(name, age, dept);
            st.displayRole();
        } else {
            System.out.println("Invalid choice.");
        }
    }
}
