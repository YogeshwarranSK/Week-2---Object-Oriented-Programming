package Day8;
import java.util.Scanner;

class Vehicle {
    static double registrationFee = 500.0;
    private static int vehicleCount = 0;

    private final String registrationNumber;
    private String ownerName;
    private String vehicleType;

    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = this.setOwnerName(ownerName);
        this.vehicleType = this.setVehicleType(vehicleType);
        this.registrationNumber = registrationNumber;
        vehicleCount++;
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    public void displayVehicleDetails() {
        if (this instanceof Vehicle) {
            System.out.println("Owner Name: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Registration Fee: $" + registrationFee);
        } else {
            System.out.println("Invalid vehicle object.");
        }
    }

    public String setOwnerName(String ownerName) {
        this.ownerName = ownerName;
        return this.ownerName;
    }

    public String setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
        return this.vehicleType;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of vehicles to register: ");
        int n = Integer.parseInt(scanner.nextLine());

        Vehicle[] vehicles = new Vehicle[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Vehicle " + (i + 1));
            System.out.print("Owner Name: ");
            String name = scanner.nextLine();
            System.out.print("Vehicle Type: ");
            String type = scanner.nextLine();
            System.out.print("Registration Number: ");
            String regNo = scanner.nextLine();

            vehicles[i] = new Vehicle(name, type, regNo);
        }

        System.out.print("\nDo you want to update the registration fee? (yes/no): ");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("yes")) {
            System.out.print("Enter new registration fee: ");
            double newFee = Double.parseDouble(scanner.nextLine());
            updateRegistrationFee(newFee);
        }

        System.out.println("\nRegistered Vehicles:");
        for (Vehicle v : vehicles) {
            v.displayVehicleDetails();
            System.out.println();
        }

        scanner.close();
    }
}

