package Day6.Level2;
import java.util.Scanner;

class Student {
    String name;
    int roll_no;
    float marks;

    Student(String name, int roll_no, float marks) {
        this.name = name;
        this.roll_no = roll_no;
        this.marks = marks;
    }

    String getGrade() {
        if (marks >= 90) return "O";
        else if (marks >= 80) return "A";
        else if (marks >= 70) return "B";
        else if (marks >= 60) return "C";
        else if (marks >= 50) return "D";
        else if (marks >= 40) return "E";
        else return "F";
    }

    void studentDetails() {
        System.out.println("Student Name: " + name);
        System.out.println("Student Roll No: " + roll_no);
        System.out.println("Student Marks: " + marks);
        System.out.println("Student Grade: " + getGrade());
    }
}

public class student {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name of Student: ");
        String name = sc.nextLine();

        System.out.print("Enter student roll number: ");
        int roll_no = sc.nextInt();

        System.out.print("Enter student percentage: ");
        float marks = sc.nextFloat();

        Student student = new Student(name, roll_no, marks);
        student.studentDetails();

        sc.close();
    }
}
