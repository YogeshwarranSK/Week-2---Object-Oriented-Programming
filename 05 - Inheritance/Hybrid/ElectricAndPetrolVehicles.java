package Day10.Hybrid;
import java.util.Scanner;
interface Refuelable {
    void refuel();
}
class Vehicle {
    protected int maxSpeed;
    protected String model;
    public Vehicle(int maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }
    public void displayInfo() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}
class ElectricVehicle extends Vehicle {
    private int batteryCapacity;
    public ElectricVehicle(int maxSpeed, String model, int batteryCapacity) {
        super(maxSpeed, model);
        this.batteryCapacity = batteryCapacity;
    }
    public void charge() {
        displayInfo();
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
        System.out.println("Charging electric vehicle...");
    }
}
class PetrolVehicle extends Vehicle implements Refuelable {
    private int fuelCapacity;
    public PetrolVehicle(int maxSpeed, String model, int fuelCapacity) {
        super(maxSpeed, model);
        this.fuelCapacity = fuelCapacity;
    }
    public void refuel() {
        displayInfo();
        System.out.println("Fuel Capacity: " + fuelCapacity + " liters");
        System.out.println("Refueling petrol vehicle...");
    }
}
public class ElectricAndPetrolVehicles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Model: ");
        String model = sc.nextLine();
        System.out.print("Enter Max Speed: ");
        int speed = sc.nextInt();
        System.out.print("Select Type (1-Electric, 2-Petrol): ");
        int type = sc.nextInt();
        if(type == 1) {
            System.out.print("Enter Battery Capacity: ");
            int battery = sc.nextInt();
            ElectricVehicle ev = new ElectricVehicle(speed, model, battery);
            ev.charge();
        } else if(type == 2) {
            System.out.print("Enter Fuel Capacity: ");
            int fuel = sc.nextInt();
            PetrolVehicle pv = new PetrolVehicle(speed, model, fuel);
            pv.refuel();
        } else {
            System.out.println("Invalid type.");
        }
    }
}
