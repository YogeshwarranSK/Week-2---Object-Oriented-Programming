package Day10;
class Vehicle {
    protected int maxSpeed;
    protected String fuelType;
    public Vehicle(int maxSpeed, String fuelType) {
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }
    public void displayInfo() {
        System.out.println("Vehicle Info - Max Speed: " + maxSpeed + " km/h, Fuel Type: " + fuelType);
    }
}

class Car extends Vehicle {
    private int seatCapacity;
    public Car(int maxSpeed, String fuelType, int seatCapacity) {
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }
    @Override
    public void displayInfo() {
        System.out.println("Car - Max Speed: " + maxSpeed + " km/h, Fuel Type: " + fuelType + ", Seat Capacity: " + seatCapacity);
    }
}

class Truck extends Vehicle {
    private double loadCapacity;
    public Truck(int maxSpeed, String fuelType, double loadCapacity) {
        super(maxSpeed, fuelType);
        this.loadCapacity = loadCapacity;
    }
    @Override
    public void displayInfo() {
        System.out.println("Truck - Max Speed: " + maxSpeed + " km/h, Fuel Type: " + fuelType + ", Load Capacity: " + loadCapacity + " tons");
    }
}

class Motorcycle extends Vehicle {
    private boolean hasCarrier;
    public Motorcycle(int maxSpeed, String fuelType, boolean hasCarrier) {
        super(maxSpeed, fuelType);
        this.hasCarrier = hasCarrier;
    }
    @Override
    public void displayInfo() {
        System.out.println("Motorcycle - Max Speed: " + maxSpeed + " km/h, Fuel Type: " + fuelType + ", Has Carrier: " + hasCarrier);
    }
}

public class VehicleInfoApp {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[3];
        vehicles[0] = new Car(180, "Petrol", 5);
        vehicles[1] = new Truck(120, "Diesel", 15.5);
        vehicles[2] = new Motorcycle(150, "Petrol", true);
        for (Vehicle v : vehicles) {
            v.displayInfo();
        }
    }
}

