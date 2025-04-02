package Day8;
import java.util.Scanner;

class Patient {
    static String hospitalName = "Sunrise Health Center";
    private static int totalPatients = 0;

    private final int patientID;
    private String name;
    private int age;
    private String ailment;

    public Patient(String name, int age, String ailment, int patientID) {
        this.name = this.setName(name);
        this.age = this.setAge(age);
        this.ailment = this.setAilment(ailment);
        this.patientID = patientID;
        totalPatients++;
    }

    public static int getTotalPatients() {
        return totalPatients;
    }

    public void displayDetails() {
        if (this instanceof Patient) {
            System.out.println("Hospital: " + hospitalName);
            System.out.println("Patient ID: " + patientID);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Ailment: " + ailment);
        } else {
            System.out.println("Invalid patient object.");
        }
    }

    public String setName(String name) {
        this.name = name;
        return this.name;
    }

    public int setAge(int age) {
        this.age = age;
        return this.age;
    }

    public String setAilment(String ailment) {
        this.ailment = ailment;
        return this.ailment;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of patients to admit: ");
        int n = Integer.parseInt(scanner.nextLine());

        Patient[] patients = new Patient[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Patient " + (i + 1));
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Age: ");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.print("Ailment: ");
            String ailment = scanner.nextLine();
            int patientID = i + 1;

            patients[i] = new Patient(name, age, ailment, patientID);
        }

        System.out.println("\nPatient Records:");
        for (Patient p : patients) {
            p.displayDetails();
            System.out.println();
        }

        System.out.println("Total Patients Admitted: " + Patient.getTotalPatients());

        scanner.close();
    }
}
