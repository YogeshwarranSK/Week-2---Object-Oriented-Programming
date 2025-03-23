package Day7.Instance;
import java.util.Scanner;
class Course {
    private String courseName;
    private int duration;
    private double fee;
    private static String instituteName = "Default Institute";
    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }
    public void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " months");
        System.out.println("Fee: $" + fee);
        System.out.println("Institute: " + instituteName);
    }
    public static void updateInstituteName(String newName) {
        instituteName = newName;
    }
}
public class CourseManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter new Institute Name: ");
        String newInstitute = sc.nextLine();
        Course.updateInstituteName(newInstitute);
        System.out.print("Enter number of courses: ");
        int n = sc.nextInt();
        sc.nextLine();
        Course[] courses = new Course[n];
        for(int i = 0; i < n; i++) {
            System.out.print("Enter Course Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Duration (in months): ");
            int duration = sc.nextInt();
            System.out.print("Enter Fee: ");
            double fee = sc.nextDouble();
            sc.nextLine();
            courses[i] = new Course(name, duration, fee);
        }
        System.out.println("\n--- Course Details ---");
        for(Course c : courses) c.displayCourseDetails();
    }
}

