package Day8;
import java.util.Scanner;

class Student {
    static String universityName = "Global Tech University";
    private static int totalStudents = 0;

    private final int rollNumber;
    private String name;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = this.setName(name);
        this.rollNumber = rollNumber;
        this.grade = this.setGrade(grade);
        totalStudents++;
    }

    public static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }

    public void displayStudentDetails() {
        if (this instanceof Student) {
            System.out.println("University: " + universityName);
            System.out.println("Name: " + name);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Grade: " + grade);
        } else {
            System.out.println("Invalid student object.");
        }
    }

    public void updateGrade(String newGrade) {
        if (this instanceof Student) {
            this.grade = newGrade;
            System.out.println("Grade updated successfully.");
        } else {
            System.out.println("Operation failed: Not a Student instance.");
        }
    }

    public String setName(String name) {
        this.name = name;
        return this.name;
    }

    public String setGrade(String grade) {
        this.grade = grade;
        return this.grade;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students to enroll: ");
        int n = Integer.parseInt(scanner.nextLine());

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Student " + (i + 1));
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Roll Number: ");
            int roll = Integer.parseInt(scanner.nextLine());
            System.out.print("Grade: ");
            String grade = scanner.nextLine();

            students[i] = new Student(name, roll, grade);
        }

        System.out.println("\nStudent Details:");
        for (Student s : students) {
            s.displayStudentDetails();
            System.out.println();
        }

        displayTotalStudents();

        System.out.print("\nDo you want to update a student's grade? (yes/no): ");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("yes")) {
            System.out.print("Enter student index (1 to " + n + "): ");
            int index = Integer.parseInt(scanner.nextLine()) - 1;

            if (index >= 0 && index < n) {
                System.out.print("Enter new grade: ");
                String newGrade = scanner.nextLine();
                students[index].updateGrade(newGrade);
                System.out.println("\nUpdated Student Info:");
                students[index].displayStudentDetails();
            } else {
                System.out.println("Invalid student index.");
            }
        }

        scanner.close();
    }
}
