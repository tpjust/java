//calculator , static block instance block
import java.util.*;
 class calci {
    static final double pi;//static and final
    static{
        pi=3.14;
        System.out.println("Welcome to the Calculator!");
    }
    {
        System.out.println("New calculator instance");
    }
    double add(double num1, double num2) {
        return num1 + num2;
    }
    double subtract(double num1, double num2) {
        return num1 - num2;
    }
    double multiply(double num1, double num2) {
        return num1 * num2;
    }
    double divide(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return num1 / num2;
    }
}


public class calculator{
    public static void main(String[] args) {
        calci calculator=new calci();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number:");
        double num1 = scanner.nextDouble();
        System.out.print("Enter second number:");
        double num2 = scanner.nextDouble();
        System.out.println("Choose operation: +, -, *, /");
        char operation = scanner.next().charAt(0);//used for char 
        switch (operation) {
            case '+':
                System.out.println(calculator.add(num1, num2)); 
                break;
            case '-':
                System.out.println(calculator.subtract(num1, num2));
                break;
            case '*':
                System.out.println(calculator.multiply(num1, num2));
                break;
            case '/':
                try {
                    System.out.println(calculator.divide(num1, num2));
                } catch (ArithmeticException e) {
                    System.out.println(e.getMessage());
                }
                break;
            default:
                System.out.println("Invalid operation");
        }

        scanner.close();
    }
    
}

