package Day9;
import java.util.*;
class Course105 {
     String courseName105;
     Professor105 assignedProfessor105;
     List<Student105> enrolledStudents105;
    public Course105(String courseName105) {
        this.courseName105 = courseName105;
        this.enrolledStudents105 = new ArrayList<>();
    }
    public String getCourseName105() {
        return courseName105;
    }
    public void assignProfessor105(Professor105 professor105) {
        this.assignedProfessor105 = professor105;
        System.out.println("Professor " + professor105.getProfessorName105() + " assigned to course: " + courseName105);
    }
    public void enrollStudent105(Student105 student105) {
        enrolledStudents105.add(student105);
        System.out.println("Student " + student105.getStudentName105() + " enrolled in course: " + courseName105);
    }
    public void showCourseDetails105() {
        System.out.println("Course: " + courseName105);
        if (assignedProfessor105 != null) {
            System.out.println("Taught by: " +
                    assignedProfessor105.getProfessorName105());
        }
        System.out.println("Enrolled Students:");
        for (Student105 s105 : enrolledStudents105) {
            System.out.println("- " + s105.getStudentName105());
        }
    }
}
class Professor105 {
     String professorName105;
    public Professor105(String professorName105) {
        this.professorName105 = professorName105;
    }
    public String getProfessorName105() {
        return professorName105;
    }
    public void assignToCourse105(Course105 course105) {
        course105.assignProfessor105(this);
    }
}
class Student105 {
     String studentName105;
     List<Course105> enrolledCourses105;
    public Student105(String studentName105) {
        this.studentName105 = studentName105;
        this.enrolledCourses105 = new ArrayList<>();
    }
    public String getStudentName105() {
        return studentName105;
    }
    public void enrollInCourse105(Course105 course105) {
        enrolledCourses105.add(course105);
        course105.enrollStudent105(this);
    }
    public void showEnrolledCourses105() {
        System.out.println("Student: " + studentName105 + " is enrolled in:");
        for (Course105 c105 : enrolledCourses105) {
            System.out.println("- " + c105.getCourseName105());
        }
    }
}
public class UniversityCourseManagement {
    public static void main(String[] args) {
        Student105 studentA105 = new Student105("Kanakaraj");
        Student105 studentB105 = new Student105("Lokesh");
        Professor105 professor105 = new Professor105("Prof. Malathy");
        Course105 courseA105 = new Course105("Data Structures");
        Course105 courseB105 = new Course105("Operating Systems");
        professor105.assignToCourse105(courseA105);
        professor105.assignToCourse105(courseB105);
        studentA105.enrollInCourse105(courseA105);
        studentB105.enrollInCourse105(courseA105);
        studentB105.enrollInCourse105(courseB105);
        System.out.println();
        studentA105.showEnrolledCourses105();
        System.out.println();
        studentB105.showEnrolledCourses105();
        System.out.println();
        courseA105.showCourseDetails105();
        System.out.println();
        courseB105.showCourseDetails105();
    }
}