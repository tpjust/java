//interfaces-multiple inheritance
import java.util.*;

interface Drawable {
    void draw();
}

interface Resizable{
    void resize(double factor);
}

class Circle implements Drawable,Resizable{
    double radius;
    Circle(double radius){
        this.radius=radius;
    }
    @Override
    public void resize(double factor) {
        radius *= factor;
        System.out.println("Resized circle to new radius: " + radius);

    }
    @Override
    public void draw() {
        System.out.println("Drawing a circle with radius: " + radius);
    }
}

class Rectangle implements Drawable{
    double length;
    double breadth;
    Rectangle(double length,double breadth){
        this.length=length;
        this.breadth=breadth;
    }
   
    @Override
    public void draw() {  
        System.out.println("Drawing a rectangle with width: " + breadth + " and height: " + length);
    }
}



public class interfaces {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the radius of the circle: ");
        double circleRadius = scanner.nextDouble();
        Circle circle = new Circle(circleRadius);
        circle.draw();
        circle.resize(2.0);
        circle.draw();

        System.out.print("Enter the length of the rectangle: ");
        double rectangleLength = scanner.nextDouble();
        System.out.print("Enter the width of the rectangle: ");
        double rectangleWidth = scanner.nextDouble();
        Rectangle rectangle = new Rectangle(rectangleLength,rectangleWidth);
        rectangle.draw();
        scanner.close();


    }
    
}
