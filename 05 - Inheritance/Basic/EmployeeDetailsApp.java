package Day10;
import java.util.*;

class Employee {
    protected String name;
    protected int id;
    protected double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public void displayDetails() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: $" + salary);
    }
}

class Manager extends Employee {
    private int teamSize;

    public Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Team Size: " + teamSize);
    }
}

class Developer extends Employee {
    private String programmingLanguage;

    public Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Programming Language: " + programmingLanguage);
    }
}

class Intern extends Employee {
    private String university;

    public Intern(String name, int id, double salary, String university) {
        super(name, id, salary);
        this.university = university;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("University: " + university);
    }
}

public class EmployeeDetailsApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        System.out.print("Enter number of employees: ");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Employee " + (i + 1));
            System.out.print("Enter type (Manager/Developer/Intern): ");
            String type = scanner.nextLine();

            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Salary: ");
            double salary = Double.parseDouble(scanner.nextLine());

            switch (type.toLowerCase()) {
                case "manager":
                    System.out.print("Team Size: ");
                    int teamSize = Integer.parseInt(scanner.nextLine());
                    employees.add(new Manager(name, id, salary, teamSize));
                    break;
                case "developer":
                    System.out.print("Programming Language: ");
                    String lang = scanner.nextLine();
                    employees.add(new Developer(name, id, salary, lang));
                    break;
                case "intern":
                    System.out.print("University: ");
                    String university = scanner.nextLine();
                    employees.add(new Intern(name, id, salary, university));
                    break;
                default:
                    System.out.println("Invalid type. Skipping entry.");
                    break;
            }
        }

        System.out.println("\nEmployee Details:\n");
        for (Employee emp : employees) {
            emp.displayDetails();
            System.out.println();
        }

        scanner.close();
    }
}
