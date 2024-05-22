// thread calculator 

import java.util.*;

public class Threadcalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Validate user input for the first number
        double num1;
        while (true) {
            try {
                System.out.print("Enter first number: ");
                num1 = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        // Validate user input for the second number
        double num2;
        while (true) {
            try {
                System.out.print("Enter second number: ");
                num2 = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        System.out.println("Choose an operation:");
        System.out.println("1. Addition");
        System.out.println("2. Substarction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        // Create and start threads based on the chosen operation
        switch (choice) {
            case 1:
                Thread additionThread = new Thread(new AdditionTask(num1, num2));
                additionThread.start();
                break;
            case 2:
                Thread subtractionThread = new Thread(new SubtractionTask(num1, num2));
                subtractionThread.start();
                break;
            case 3:
                Thread multiplicationThread = new Thread(new MultiplicationTask(num1, num2));
                multiplicationThread.start();
                break;
            case 4:
                Thread divisionThread = new Thread(new DivisionTask(num1, num2));
                divisionThread.start();
                break;
            default:
                System.out.println("Invalid operation. Please choose a valid arithmetic operation.");
        }

        scanner.close();
    }
}

class AdditionTask implements Runnable {
    private final double num1;
    private final double num2;

    public AdditionTask(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public void run() {
        double result = num1 + num2;
        System.out.println("Addition Result: " + result);
    }
}

class SubtractionTask implements Runnable {
    private final double num1;
    private final double num2;

    public SubtractionTask(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public void run() {
        double result = num1 - num2;
        System.out.println("Subtraction Result: " + result);
    }
}

class MultiplicationTask implements Runnable {
    private final double num1;
    private final double num2;

    public MultiplicationTask(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public void run() {
        double result = num1 * num2;
        System.out.println("Multiplication Result: " + result);
    }
}

class DivisionTask implements Runnable {
    private final double num1;
    private final double num2;

    public DivisionTask(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public void run() {
        if (num2 == 0) {
            System.out.println("Division Result: Error! Division by zero is not allowed.");
        } else {
            double result = num1 / num2;
            System.out.println("Division Result: " + result);
        }
    }
}
