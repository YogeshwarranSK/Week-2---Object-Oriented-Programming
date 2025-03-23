package Day8;
import java.util.Scanner;

class Employee {
    static String companyName = "TechNova Inc.";
    private static int totalEmployees = 0;

    private final int id;
    private String name;
    private String designation;

    public Employee(String name, int id, String designation) {
        this.name = this.setName(name);
        this.id = id;
        this.designation = this.setDesignation(designation);
        totalEmployees++;
    }

    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    public void displayDetails() {
        if (this instanceof Employee) {
            System.out.println("Company Name: " + companyName);
            System.out.println("Employee ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Designation: " + designation);
        } else {
            System.out.println("Invalid employee object.");
        }
    }

    public String setName(String name) {
        this.name = name;
        return this.name;
    }

    public String setDesignation(String designation) {
        this.designation = designation;
        return this.designation;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of employees to add: ");
        int count = Integer.parseInt(scanner.nextLine());

        Employee[] employees = new Employee[count];

        for (int i = 0; i < count; i++) {
            System.out.println("\nEnter details for Employee " + (i + 1));
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Designation: ");
            String designation = scanner.nextLine();

            employees[i] = new Employee(name, id, designation);
        }

        System.out.println("\nEmployee Details:");
        for (Employee emp : employees) {
            emp.displayDetails();
            System.out.println();
        }

        displayTotalEmployees();
        scanner.close();
    }
}

