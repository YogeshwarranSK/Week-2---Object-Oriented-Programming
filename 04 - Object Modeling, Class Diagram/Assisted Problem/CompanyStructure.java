package Day9;
import java.util.*;
class Company {
    String name;
    List<Department> departments = new ArrayList<>();
    Company(String name) {
        this.name = name;
    }
    void addDepartment(String deptName) {
        departments.add(new Department(deptName));
    }
    void showCompanyStructure() {
        System.out.println("Company: " + name);
        for (Department d : departments) {
            d.showEmployees();
        }
    }
    void deleteCompany() {
        departments.clear();
        System.out.println("Company '" + name + "' removed along with its departments and employees.");
    }
    static class Department {
        String deptName;
        List<Employee> employees = new ArrayList<>();

        Department(String deptName) {
            this.deptName = deptName;
        }
        void addEmployee(String empName) {
            employees.add(new Employee(empName));
        }
        void showEmployees() {
            System.out.println("Department: " + deptName);
            for (Employee e : employees) {
                System.out.println("Employee: " + e.name);
            }
        }
        static class Employee {
            String name;
            Employee(String name) {
                this.name = name;
            }
        }
    }
}
public class CompanyStructure {
    public static void main(String[] args) {
        Company company = new Company("Google");
        company.addDepartment("HR");
        company.addDepartment("IT");
        company.departments.get(0).addEmployee("Nikhil");
        company.departments.get(1).addEmployee("Siddhu");
        company.showCompanyStructure();
        company.deleteCompany();
    }
}

