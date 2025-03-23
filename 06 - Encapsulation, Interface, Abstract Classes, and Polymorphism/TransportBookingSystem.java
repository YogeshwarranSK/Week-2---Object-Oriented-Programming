package Day11;


import java.util.*;

interface LocationTracking {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

abstract class TransportVehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    public TransportVehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public String getVehicleId() { return vehicleId; }
    public void setVehicleId(String vehicleId) { this.vehicleId = vehicleId; }

    public String getDriverName() { return driverName; }
    public void setDriverName(String driverName) { this.driverName = driverName; }

    public double getRatePerKm() { return ratePerKm; }
    public void setRatePerKm(double ratePerKm) { this.ratePerKm = ratePerKm; }

    public void displayVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver: " + driverName);
        System.out.println("Rate per km: " + ratePerKm);
    }

    public abstract double calculateFare(double distance);
}

class Sedan extends TransportVehicle implements LocationTracking {
    private String currentLocation;

    public Sedan(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = currentLocation;
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() + 50;
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}

class Motorcycle extends TransportVehicle implements LocationTracking {
    private String currentLocation;

    public Motorcycle(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = currentLocation;
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}

class Rickshaw extends TransportVehicle implements LocationTracking {
    private String currentLocation;

    public Rickshaw(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = currentLocation;
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() + 20;
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}

public class TransportBookingSystem {

    public static void processRide(List<TransportVehicle> vehicles, double distance) {
        for (TransportVehicle vehicle : vehicles) {
            vehicle.displayVehicleDetails();
            if (vehicle instanceof LocationTracking) {
                System.out.println("Current Location: " + ((LocationTracking) vehicle).getCurrentLocation());
            }
            System.out.println("Distance: " + distance + " km");
            System.out.println("Fare: " + vehicle.calculateFare(distance));
            System.out.println("----------------------");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<TransportVehicle> rideVehicles = new ArrayList<>();

        System.out.print("Enter the number of rides to book: ");
        int numberOfRides = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < numberOfRides; i++) {
            System.out.println("Enter details for ride " + (i + 1) + ":");

            System.out.print("Vehicle type (Sedan/Motorcycle/Rickshaw): ");
            String vehicleType = sc.nextLine().trim().toLowerCase();

            System.out.print("Vehicle ID: ");
            String vehicleId = sc.nextLine();

            System.out.print("Driver Name: ");
            String driverName = sc.nextLine();

            System.out.print("Rate per km: ");
            double ratePerKm = sc.nextDouble();
            sc.nextLine(); // Consume newline

            System.out.print("Current Location: ");
            String location = sc.nextLine();

            if (vehicleType.equals("sedan")) {
                rideVehicles.add(new Sedan(vehicleId, driverName, ratePerKm, location));
            } else if (vehicleType.equals("motorcycle")) {
                rideVehicles.add(new Motorcycle(vehicleId, driverName, ratePerKm, location));
            } else if (vehicleType.equals("rickshaw")) {
                rideVehicles.add(new Rickshaw(vehicleId, driverName, ratePerKm, location));
            } else {
                System.out.println("Invalid vehicle type, skipping.");
            }
        }

        System.out.print("Enter distance for the rides (in km): ");
        double distance = sc.nextDouble();

        System.out.println("\n=== Ride Fare Summary ===");
        processRide(rideVehicles, distance);
        sc.close();
    }
}
