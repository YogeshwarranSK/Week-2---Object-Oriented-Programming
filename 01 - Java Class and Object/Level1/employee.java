package Day6.Level1;
import java.util.Scanner;
class Employee{
    String name;
    int id;
    double salary;

    Employee(String name, int id,double salary){
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
    void Details(){
        System.out.println("Employee name: "+name);
        System.out.println("Employee id: "+id);
        System.out.println("Employee salary: "+salary);
    }
}
public class employee {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name = sc.nextLine();
        System.out.println("Enter employee id: ");
        int id = sc.nextInt();
        System.out.println("Enter salary:");
        double sal = sc.nextDouble();
        Employee emp = new Employee(name,id,sal);
        emp.Details();
    }
}
