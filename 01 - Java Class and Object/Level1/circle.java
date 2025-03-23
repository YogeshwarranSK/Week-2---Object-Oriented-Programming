package Day6.Level1;
import java.util.Scanner;
class Circle{
    double radius;
    Circle(double radius){
        this.radius = radius;
    }
    void Area(){
        double area = 3.14*radius*radius;
        System.out.println("Area of Circle: "+area);
    }
    void Circumference(){
        double perimeter = 2 * 3.14 * radius;
        System.out.println("Circumference of circle: "+perimeter);
    }
}
public class circle {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter radius of circle: ");
        double radius = sc.nextDouble();
        Circle cir = new Circle(radius);
        cir.Area();
        cir.Circumference();
        sc.close();
    }

}
