package Day10.Hybrid;
import java.util.Scanner;
interface Worker {
    void performDuties();
}
class Person {
    protected String name;
    protected String id;
    public Person(String name, String id) {
        this.name = name;
        this.id = id;
    }
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}
class Chef extends Person implements Worker {
    private String specialty;
    public Chef(String name, String id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }
    public void performDuties() {
        displayInfo();
        System.out.println("Role: Chef");
        System.out.println("Specialty: " + specialty);
        System.out.println("Duties: Cooking meals and managing the kitchen.");
    }
}
class Waiter extends Person implements Worker {
    private int tableCount;
    public Waiter(String name, String id, int tableCount) {
        super(name, id);
        this.tableCount = tableCount;
    }
    public void performDuties() {
        displayInfo();
        System.out.println("Role: Waiter");
        System.out.println("Tables Assigned: " + tableCount);
        System.out.println("Duties: Serving food and attending customers.");
    }
}
public class RestaurantStaffDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter ID: ");
        String id = sc.nextLine();
        System.out.print("Select Role (1-Chef, 2-Waiter): ");
        int choice = sc.nextInt();
        sc.nextLine();
        if(choice == 1) {
            System.out.print("Enter Specialty: ");
            String specialty = sc.nextLine();
            Chef chef = new Chef(name, id, specialty);
            chef.performDuties();
        } else if(choice == 2) {
            System.out.print("Enter Number of Tables: ");
            int tables = sc.nextInt();
            Waiter waiter = new Waiter(name, id, tables);
            waiter.performDuties();
        } else {
            System.out.println("Invalid choice.");
        }
    }
}
