package Day11;
import java.util.*;

interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

abstract class Patient {
    private String patientId;
    private String name;
    private int age;
    private List<String> medicalHistory;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.medicalHistory = new ArrayList<>();
    }

    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    protected List<String> getMedicalHistory() { return medicalHistory; }

    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public abstract double calculateBill();
}

class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double roomChargePerDay;

    public InPatient(String patientId, String name, int age, int daysAdmitted, double roomChargePerDay) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
        this.roomChargePerDay = roomChargePerDay;
    }

    public double calculateBill() {
        return daysAdmitted * roomChargePerDay;
    }

    public void addRecord(String record) {
        getMedicalHistory().add(record);
    }

    public void viewRecords() {
        System.out.println("Medical Records:");
        for (String record : getMedicalHistory()) {
            System.out.println("- " + record);
        }
    }
}

class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;

    public OutPatient(String patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
    }

    public double calculateBill() {
        return consultationFee;
    }

    public void addRecord(String record) {
        getMedicalHistory().add(record);
    }

    public void viewRecords() {
        System.out.println("Medical Records:");
        for (String record : getMedicalHistory()) {
            System.out.println("- " + record);
        }
    }
}

public class HospitalManagement {
    public static void processPatients(List<Patient> patients) {
        for (Patient p : patients) {
            p.getPatientDetails();
            if (p instanceof MedicalRecord) {
                ((MedicalRecord) p).viewRecords();
            }
            System.out.println("Total Bill: " + p.calculateBill());
            System.out.println("---------------------------");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Patient> patients = new ArrayList<>();

        System.out.print("Enter number of patients: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for patient " + (i + 1));
            System.out.print("Patient type (In/Out): ");
            String type = sc.nextLine().trim().toLowerCase();

            System.out.print("Patient ID: ");
            String id = sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Age: ");
            int age = sc.nextInt();
            sc.nextLine();

            if (type.equals("in")) {
                System.out.print("Days Admitted: ");
                int days = sc.nextInt();
                System.out.print("Room Charge per Day: ");
                double charge = sc.nextDouble();
                sc.nextLine();
                InPatient ip = new InPatient(id, name, age, days, charge);

                System.out.print("Enter number of medical records: ");
                int r = sc.nextInt();
                sc.nextLine();
                for (int j = 0; j < r; j++) {
                    System.out.print("Record " + (j + 1) + ": ");
                    String record = sc.nextLine();
                    ip.addRecord(record);
                }
                patients.add(ip);

            } else if (type.equals("out")) {
                System.out.print("Consultation Fee: ");
                double fee = sc.nextDouble();
                sc.nextLine();
                OutPatient op = new OutPatient(id, name, age, fee);

                System.out.print("Enter number of medical records: ");
                int r = sc.nextInt();
                sc.nextLine();
                for (int j = 0; j < r; j++) {
                    System.out.print("Record " + (j + 1) + ": ");
                    String record = sc.nextLine();
                    op.addRecord(record);
                }
                patients.add(op);
            } else {
                System.out.println("Invalid patient type. Skipping.");
            }
        }

        System.out.println("\n=== Patient Billing Summary ===");
        processPatients(patients);
        sc.close();
    }
}
