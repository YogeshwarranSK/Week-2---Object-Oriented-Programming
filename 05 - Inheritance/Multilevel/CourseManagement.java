package Day10;
import java.util.Scanner;
class Course {
    protected String courseName;
    protected int duration;
    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }
    public void displayInfo() {
        System.out.println("Course: " + courseName);
        System.out.println("Duration: " + duration + " hours");
    }
}
class OnlineCourse extends Course {
    protected String platform;
    protected boolean isRecorded;
    public OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Platform: " + platform);
        System.out.println("Recorded: " + isRecorded);
    }
}
class PaidOnlineCourse extends OnlineCourse {
    private double fee;
    private double discount;
    public PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Fee: $" + fee);
        System.out.println("Discount: " + discount + "%");
    }
}
public class CourseManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Course Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Duration (in hours): ");
        int duration = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Platform: ");
        String platform = sc.nextLine();
        System.out.print("Is it recorded? (true/false): ");
        boolean recorded = sc.nextBoolean();
        System.out.print("Enter Course Fee: ");
        double fee = sc.nextDouble();
        System.out.print("Enter Discount (%): ");
        double discount = sc.nextDouble();
        PaidOnlineCourse poc = new PaidOnlineCourse(name, duration, platform, recorded, fee, discount);
        System.out.println("\n--- Course Details ---");
        poc.displayInfo();
    }
}

