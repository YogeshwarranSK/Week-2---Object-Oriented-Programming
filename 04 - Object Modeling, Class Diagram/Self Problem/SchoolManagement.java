package Day9;

import java.util.*;
class Course101 {
     String courseName101;
     List<Student101> enrolledStudents101;
    public Course101(String courseName101) {
        this.courseName101 = courseName101;
        this.enrolledStudents101 = new ArrayList<>();
    }
    public String getCourseName101() {
        return courseName101;
    }
    public void enrollStudent101(Student101 student101) {
        enrolledStudents101.add(student101);
    }
    public void showEnrolledStudents101() {
        System.out.println("Course: " + courseName101 + " has enrolled students:");
        for (Student101 s101 : enrolledStudents101) {
            System.out.println("- " + s101.getName101());
        }
    }
}
class Student101 {
     String name101;
     List<Course101> courses101;
    public Student101(String name101) {
        this.name101 = name101;
        this.courses101 = new ArrayList<>();
    }
    public String getName101() {
        return name101;
    }
    public void enrollInCourse101(Course101 course101) {
        courses101.add(course101);
        course101.enrollStudent101(this);
    }
    public void showCourses101() {
        System.out.println("Student: " + name101 + " is enrolled in:");
        for (Course101 c101 : courses101) {
            System.out.println("- " + c101.getCourseName101());
        }
    }
}
class School101 {
     String schoolName101;
     List<Student101> students101;
    public School101(String schoolName101) {
        this.schoolName101 = schoolName101;
        this.students101 = new ArrayList<>();
    }
    public void addStudent101(Student101 student101) {
        students101.add(student101);
    }
    public void showAllStudents101() {
        System.out.println("School: " + schoolName101 + " has students:");
        for (Student101 s101 : students101) {
            System.out.println("- " + s101.getName101());
        }
    }
}
public class SchoolManagement {
    public static void main(String[] args) {
        School101 school101 = new School101("Narayana");
        Student101 alice101 = new Student101("Naresh");
        Student101 bob101 = new Student101("Krishna");
        Course101 math101 = new Course101("Math");
        Course101 science101 = new Course101("Science");
        school101.addStudent101(alice101);
        school101.addStudent101(bob101);
        alice101.enrollInCourse101(math101);
        alice101.enrollInCourse101(science101);
        bob101.enrollInCourse101(science101);
        school101.showAllStudents101();
        System.out.println();
        alice101.showCourses101();
        bob101.showCourses101();
        System.out.println();
        math101.showEnrolledStudents101();
        science101.showEnrolledStudents101();
    }

}
