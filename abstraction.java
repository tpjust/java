//abstraction
import java.util.*;

abstract class Shape {
    abstract double calculateArea();
    abstract double calculatePerimeter();
    abstract void displayDetails();
}

class Circle extends Shape{
    int radius;
    Circle(int radius){
        this.radius=radius;
    }
    @Override
    double calculateArea() {
        return 3.14*radius*radius;
    }
    @Override
    double calculatePerimeter() {
        return 3.14*2*radius;
    }
    @Override
    void displayDetails() {
        System.out.println("Shape: Circle");
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + calculateArea());
        System.out.println("Perimeter: " + calculatePerimeter());
    }
}

class Reactangle extends Shape{
    int length;
    int breadth;
    Reactangle(int length, int breadth){
        this.length=length;
        this.breadth=breadth;
    }
    @Override
    double calculateArea() {
        return length*breadth;
    }
    @Override
    double calculatePerimeter() {
        return 2*(length+breadth);
    }
    @Override
    void displayDetails() {
        System.out.println("Shape: Rectangle");
        System.out.println("Length: " + length);
        System.out.println("Width: " + breadth);
        System.out.println("Area: " + calculateArea());
        System.out.println("Perimeter: " + calculatePerimeter());

    }
}

class Triangle extends Shape{
    double side1;
    double side2;
    double side3;
    Triangle(double side1,double side2, double side3){
        this.side1=side1;
        this.side2=side2;
        this.side3=side3;
    }

    @Override
    double calculateArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));

    }

    @Override
    double calculatePerimeter() {
        return side1+side2+side3;
    }

    @Override
    void displayDetails() {
        
        System.out.println("Shape: Triangle");
        System.out.println("Side A: " + side1);
        System.out.println("Side B: " + side2);
        System.out.println("Side C: " + side3);
        System.out.println("Area: " + calculateArea());
        System.out.println("Perimeter: " + calculatePerimeter());

    }
}


public class abstraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the radius of the circle: ");
        int circleRadius = scanner.nextInt();
        Shape circle = new Circle(circleRadius);
        System.out.print("Enter the length of the rectangle: ");
        int rectangleLength = scanner.nextInt();
        System.out.print("Enter the width of the rectangle: ");
        int rectangleWidth = scanner.nextInt();
        Shape rectangle = new Reactangle(rectangleLength, rectangleWidth);
        System.out.print("Enter the side A of the triangle: ");
        double sideA = scanner.nextDouble();
        System.out.print("Enter the side B of the triangle: ");
        double sideB = scanner.nextDouble();
        System.out.print("Enter the side C of the triangle: ");
        double sideC = scanner.nextDouble();
        Shape triangle = new Triangle(sideA, sideB, sideC);
        System.out.println();
        circle.displayDetails();
        System.out.println();
        rectangle.displayDetails();
        System.out.println();
        triangle.displayDetails();
        scanner.close();

    }
    
}
