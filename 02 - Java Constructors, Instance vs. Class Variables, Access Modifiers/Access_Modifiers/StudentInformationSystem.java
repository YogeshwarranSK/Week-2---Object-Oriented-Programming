package Day7.Access_Modifiers;

import java.util.Scanner;
class Student {
    public int rollNumber;
    protected String name;
    private double CGPA;
    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }
    public double getCGPA() {
        return CGPA;
    }
    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }
    public void displayStudent() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + CGPA);
    }
}
class PostgraduateStudent extends Student {
    private String specialization;
    public PostgraduateStudent(int rollNumber, String name, double CGPA, String specialization) {
        super(rollNumber, name, CGPA);
        this.specialization = specialization;
    }
    public void displayPGStudent() {
        System.out.println("PG Student");
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("Specialization: " + specialization);
        System.out.println("CGPA: " + getCGPA());
    }
}
public class StudentInformationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter CGPA: ");
        double cgpa = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter Specialization: ");
        String spec = sc.nextLine();
        PostgraduateStudent pg = new PostgraduateStudent(roll, name, cgpa, spec);
        pg.displayPGStudent();
        System.out.print("Update CGPA: ");
        double newCgpa = sc.nextDouble();
        pg.setCGPA(newCgpa);
        System.out.println("\nUpdated Details:");
        pg.displayPGStudent();
    }
}

