package Day7.Access_Modifiers;
import java.util.Scanner;
class Employee {
    public int employeeID;
    protected String department;
    private double salary;
    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
}
class Manager extends Employee {
    private String level;
    public Manager(int employeeID, String department, double salary, String level) {
        super(employeeID, department, salary);
        this.level = level;
    }
    public void displayManagerDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: $" + getSalary());
        System.out.println("Level: " + level);
    }
}
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Department: ");
        String dept = sc.nextLine();
        System.out.print("Enter Salary: ");
        double sal = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter Manager Level: ");
        String level = sc.nextLine();
        Manager mgr = new Manager(id, dept, sal, level);
        mgr.displayManagerDetails();
        System.out.print("Update Salary: ");
        double newSal = sc.nextDouble();
        mgr.setSalary(newSal);
        System.out.println("\nUpdated Manager Details:");
        mgr.displayManagerDetails();
    }
}

