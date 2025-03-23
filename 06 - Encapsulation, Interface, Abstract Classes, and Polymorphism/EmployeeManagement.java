package Day11;
import java.util.*;

interface Department {
    void assignDepartment(String dept);
    String getDepartmentDetails();
}

abstract class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;

    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public int getEmployeeId() { return employeeId; }
    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getBaseSalary() { return baseSalary; }
    public void setBaseSalary(double baseSalary) { this.baseSalary = baseSalary; }

    public abstract double calculateSalary();

    public void displayDetails() {
        System.out.println("ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: " + baseSalary);
    }
}


class FullTimeEmployee extends Employee implements Department {
    private String department;

    public FullTimeEmployee(int employeeId, String name, double baseSalary) {
        super(employeeId, name, baseSalary);
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary();  // Fixed salary
    }

    @Override
    public void assignDepartment(String dept) {
        this.department = dept;
    }

    @Override
    public String getDepartmentDetails() {
        return "Department: " + department;
    }
}


class PartTimeEmployee extends Employee implements Department {
     int hoursWorked;
     double hourlyRate;
    private String department;

    public PartTimeEmployee(int employeeId, String name, double hourlyRate, int hoursWorked) {
        super(employeeId, name, 0);  // baseSalary not used
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public void assignDepartment(String dept) {
        this.department = dept;
    }

    @Override
    public String getDepartmentDetails() {
        return "Department: " + department;
    }
}

// Main class
public class EmployeeManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Employee " + (i + 1));
            System.out.print("Is the employee FullTime or PartTime? (F/P): ");
            String type = sc.nextLine().trim().toUpperCase();

            System.out.print("Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            if (type.equals("F")) {
                System.out.print("Base Salary: ");
                double baseSalary = sc.nextDouble();
                sc.nextLine();

                FullTimeEmployee fte = new FullTimeEmployee(id, name, baseSalary);

                System.out.print("Assign Department: ");
                String dept = sc.nextLine();
                fte.assignDepartment(dept);

                employees.add(fte);
            } else if (type.equals("P")) {
                System.out.print("Hourly Rate: ");
                double hourlyRate = sc.nextDouble();
                System.out.print("Hours Worked: ");
                int hours = sc.nextInt();
                sc.nextLine();

                PartTimeEmployee pte = new PartTimeEmployee(id, name, hourlyRate, hours);

                System.out.print("Assign Department: ");
                String dept = sc.nextLine();
                pte.assignDepartment(dept);

                employees.add(pte);
            } else {
                System.out.println("Invalid employee type. Skipping...");
            }
        }

        // Display all employee details
        System.out.println("\n=== Employee Details ===");
        for (Employee emp : employees) {
            emp.displayDetails();
            System.out.println("Calculated Salary: " + emp.calculateSalary());
            if (emp instanceof Department) {
                System.out.println(((Department) emp).getDepartmentDetails());
            }
            System.out.println("---------------------------");
        }

        sc.close();
    }
}
