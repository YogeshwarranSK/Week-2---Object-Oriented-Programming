package Day9;
import java.util.*;

class Patient {
    String name;

    Patient(String name) {
        this.name = name;
    }
    void display() {
        System.out.println("Patient: " + name);
    }
}
class Doctor {
    String name;
    List<Patient> patients = new ArrayList<>();
    Doctor(String name) {
        this.name = name;
    }
    void consult(Patient p) {
        patients.add(p);
        System.out.println("Doctor " + name + " consulted patient " + p.name);
    }
    void showPatients() {
        System.out.println("Doctor " + name + "'s Patients:");
        for (Patient p : patients) {
            p.display();
        }
    }
}
class Hospital {
    String hospitalName;
    List<Doctor> doctors = new ArrayList<>();
    List<Patient> patients = new ArrayList<>();
    Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
    }
    void addDoctor(Doctor d) {
        doctors.add(d);
    }
    void addPatient(Patient p) {
        patients.add(p);
    }
    void displayHospital() {
        System.out.println("Hospital: " + hospitalName);
        System.out.println("Doctors:");
        for (Doctor d : doctors) {
            System.out.println("- " + d.name);
        }
        System.out.println("Patients:");
        for (Patient p : patients) {
            System.out.println("- " + p.name);
        }
    }
}
public class HospitalManagement {
    public static void main(String[] args) {
        Hospital h = new Hospital("AIMS Hospital");
        Doctor d1 = new Doctor("Dr. Supriya");
        Doctor d2 = new Doctor("Dr. Rajath");
        Patient p1 = new Patient("Sai");
        Patient p2 = new Patient("Sid");
        h.addDoctor(d1);
        h.addDoctor(d2);
        h.addPatient(p1);
        h.addPatient(p2);
        d1.consult(p1);
        d1.consult(p2);
        d2.consult(p1);
        d1.showPatients();
        d2.showPatients();
        h.displayHospital();
    }
}