//method overloading 
import java.util.*;


public class overloading {
    static void calculateArea(int length, int breadth) {
        int area = length * breadth;
        System.out.println("Area of the rectangle is " + area);
    }
    static void calculateArea(double radius) {
        double area = Math.PI * radius * radius;
        System.out.println("Area of the circle is " + area);
    }
    static void calculateArea(double base, double height) {
        double area = 0.5 * base * height;
        System.out.println("Area of the triangle is " + area);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length and breadth of the rectangle:");
        int length = sc.nextInt();
        int breadth = sc.nextInt();
        calculateArea(length, breadth);
        System.out.print("Enter radius of the circle:");
        double radius = sc.nextDouble();
        calculateArea(radius);
        System.out.print("Enter base and height of the triangle:");
        double base = sc.nextDouble();
        double height = sc.nextDouble();
        calculateArea(base, height);
        sc.close();

    }
}
