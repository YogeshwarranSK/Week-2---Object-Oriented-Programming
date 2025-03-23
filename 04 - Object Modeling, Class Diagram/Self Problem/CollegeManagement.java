package Day;
import java.util.*;
class Faculty {
    String name;
    Faculty(String name) {
        this.name = name;
    }
    void display() {
        System.out.println("Faculty: " + name);
    }
}
class Department {
    String deptName;
    List<Faculty> facultyList = new ArrayList<>();
    Department(String deptName) {
        this.deptName = deptName;
    }
    void addFaculty(Faculty f) {
        facultyList.add(f);
    }
    void displayDepartment() {
        System.out.println("Department: " + deptName);
        for (Faculty f : facultyList) {
            f.display();
        }
    }
}
class University {
    String universityName;
    List<Department> departments = new ArrayList<>();
    University(String universityName) {
        this.universityName = universityName;
    }
    void addDepartment(Department d) {
        departments.add(d);
    }
    void displayUniversity() {
        System.out.println("University: " + universityName);
        for (Department d : departments) {
            d.displayDepartment();
        }
    }
    void deleteUniversity() {
        departments.clear();
        System.out.println("University and all departments deleted.");
    }
}
public class CollegeManagement {
    public static void main(String[] args) {
        University uni = new University("SRM Univeristy");
        Faculty f1 = new Faculty("Prof. Malathy");
        Faculty f2 = new Faculty("Prof. Hariharan");
        Faculty f3 = new Faculty("Dr. Raja");
        Department d1 = new Department("Computer Science & Engineering");
        Department d2 = new Department("Mathematics");
        d1.addFaculty(f1);
        d2.addFaculty(f2);
        uni.addDepartment(d1);
        uni.addDepartment(d2);
        uni.displayUniversity();
        System.out.println("Independent Faculty:");
        f3.display();
        uni.deleteUniversity();

    }
}