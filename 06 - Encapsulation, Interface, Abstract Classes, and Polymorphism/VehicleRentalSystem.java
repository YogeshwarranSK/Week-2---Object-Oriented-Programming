package Day11;

import java.util.*;

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public String getVehicleNumber() { return vehicleNumber; }
    public void setVehicleNumber(String vehicleNumber) { this.vehicleNumber = vehicleNumber; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public double getRentalRate() { return rentalRate; }
    public void setRentalRate(double rentalRate) { this.rentalRate = rentalRate; }

    public abstract double calculateRentalCost(int days);
}

class Car extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Car(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Car", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * getRentalRate();
    }

    @Override
    public double calculateInsurance() {
        return 200.0; // Fixed insurance cost for cars
    }

    @Override
    public String getInsuranceDetails() {
        return "Insurance Policy Number: " + insurancePolicyNumber;
    }
}

class Bike extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Bike(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Bike", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * getRentalRate();
    }

    @Override
    public double calculateInsurance() {
        return 100.0; // Fixed insurance cost for bikes
    }

    @Override
    public String getInsuranceDetails() {
        return "Insurance Policy Number: " + insurancePolicyNumber;
    }
}

class Truck extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Truck(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Truck", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * getRentalRate();
    }

    @Override
    public double calculateInsurance() {
        return 300.0; // Fixed insurance cost for trucks
    }

    @Override
    public String getInsuranceDetails() {
        return "Insurance Policy Number: " + insurancePolicyNumber;
    }
}

public class VehicleRentalSystem {
    public static void processRental(List<Vehicle> vehicles, int days) {
        for (Vehicle v : vehicles) {
            System.out.println("Vehicle Number: " + v.getVehicleNumber());
            System.out.println("Vehicle Type: " + v.getType());
            System.out.println("Rental Cost for " + days + " days: " + v.calculateRentalCost(days));
            if (v instanceof Insurable) {
                System.out.println("Insurance Cost: " + ((Insurable) v).calculateInsurance());
                System.out.println(((Insurable) v).getInsuranceDetails());
            }
            System.out.println("----------------------");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Vehicle> vehicles = new ArrayList<>();

        System.out.print("Enter number of vehicles to register: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for vehicle " + (i + 1) + ":");
            System.out.print("Vehicle Type (Car/Bike/Truck): ");
            String type = sc.nextLine().trim().toLowerCase();

            System.out.print("Vehicle Number: ");
            String vehicleNumber = sc.nextLine();

            System.out.print("Rental Rate: ");
            double rentalRate = sc.nextDouble();
            sc.nextLine();

            System.out.print("Insurance Policy Number: ");
            String insurancePolicyNumber = sc.nextLine();

            if (type.equals("car")) {
                vehicles.add(new Car(vehicleNumber, rentalRate, insurancePolicyNumber));
            } else if (type.equals("bike")) {
                vehicles.add(new Bike(vehicleNumber, rentalRate, insurancePolicyNumber));
            } else if (type.equals("truck")) {
                vehicles.add(new Truck(vehicleNumber, rentalRate, insurancePolicyNumber));
            } else {
                System.out.println("Invalid vehicle type. Skipping.");
            }
        }

        System.out.print("Enter number of days for rental: ");
        int days = sc.nextInt();

        System.out.println("\n=== Rental and Insurance Summary ===");
        processRental(vehicles, days);

        sc.close();
    }
}
