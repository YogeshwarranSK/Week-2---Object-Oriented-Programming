package Day7.Instance;
import java.util.Scanner;
class Vehicle {
    private String ownerName;
    private String vehicleType;
    private static double registrationFee = 500.0;
    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }
    public void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: $" + registrationFee);
    }
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }
}
public class VehicleRegistrationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter new Registration Fee: ");
        double fee = sc.nextDouble();
        sc.nextLine();
        Vehicle.updateRegistrationFee(fee);
        System.out.print("Enter number of vehicles: ");
        int n = sc.nextInt();
        sc.nextLine();
        Vehicle[] vehicles = new Vehicle[n];
        for(int i = 0; i < n; i++) {
            System.out.print("Enter Owner Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Vehicle Type: ");
            String type = sc.nextLine();
            vehicles[i] = new Vehicle(name, type);
        }
        System.out.println("\n--- Vehicle Details ---");
        for(Vehicle v : vehicles) v.displayVehicleDetails();
    }
}

