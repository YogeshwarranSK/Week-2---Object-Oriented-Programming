package Day7.Level1;
import java.util.Scanner;

class Circle{
    double radius;
    void Area(){
         System.out.println("Area of Circle: "+3.14*radius*radius);
    }
}
public class CircleAreaCalculator {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter radius of Circle:");
        double radius;
        double custom_radius = sc.nextDouble();
        Circle c = new Circle();
        c.radius= custom_radius;
        c.Area();
    }
}
