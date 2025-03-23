package Day10;
import java.util.Scanner;
class Device {
    protected String deviceId;
    protected String status;
    public Device(String deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }
    public void displayStatus() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + status);
    }
}
class Thermostat extends Device {
    private double temperatureSetting;
    public Thermostat(String deviceId, String status, double temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }
    @Override
    public void displayStatus() {
        super.displayStatus();
        System.out.println("Temperature Setting: " + temperatureSetting + "°C");
    }
}
public class DeviceThermostatApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Device ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Device Status (On/Off): ");
        String status = sc.nextLine();
        System.out.print("Enter Temperature Setting: ");
        double temp = sc.nextDouble();
        Thermostat t = new Thermostat(id, status, temp);
        System.out.println("\n--- Device Status ---");
        t.displayStatus();
    }
}
