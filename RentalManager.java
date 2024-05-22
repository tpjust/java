//vehicle rental system

import java.util.*;
// Define the Rentable interface
interface Rentable {
    void rent();
    void returnVehicle();
    double calculateRentalCost(int days);
    String getVehicleDetails();
}

// Car class implementing the Rentable interface
class Car implements Rentable {
    private String model;
    private double dailyRate;
    private boolean isRented;

    public Car(String model, double dailyRate) {
        this.model = model;
        this.dailyRate = dailyRate;
        this.isRented = false;
    }

    @Override
    public void rent() {
        if (!isRented) {
            isRented = true;
            System.out.println(model + " has been rented.");
        } else {
            System.out.println(model + " is already rented.");
        }
    }

    @Override
    public void returnVehicle() {
        if (isRented) {
            isRented = false;
            System.out.println(model + " has been returned.");
        } else {
            System.out.println(model + " was not rented.");
        }
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * dailyRate;
    }

    @Override
    public String getVehicleDetails() {
        return "Car: " + model + ", Daily Rate: $" + dailyRate + ", Rented: " + isRented;
    }
}

// Motorcycle class implementing the Rentable interface
class Motorcycle implements Rentable {
    private String model;
    private double dailyRate;
    private boolean isRented;

    public Motorcycle(String model, double dailyRate) {
        this.model = model;
        this.dailyRate = dailyRate;
        this.isRented = false;
    }

    @Override
    public void rent() {
        if (!isRented) {
            isRented = true;
            System.out.println(model + " has been rented.");
        } else {
            System.out.println(model + " is already rented.");
        }
    }

    @Override
    public void returnVehicle() {
        if (isRented) {
            isRented = false;
            System.out.println(model + " has been returned.");
        } else {
            System.out.println(model + " was not rented.");
        }
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * dailyRate;
    }

    @Override
    public String getVehicleDetails() {
        return "Motorcycle: " + model + ", Daily Rate: $" + dailyRate + ", Rented: " + isRented;
    }
}

// Bicycle class implementing the Rentable interface
class Bicycle implements Rentable {
    private String model;
    private double dailyRate;
    private boolean isRented;

    public Bicycle(String model, double dailyRate) {
        this.model = model;
        this.dailyRate = dailyRate;
        this.isRented = false;
    }

    @Override
    public void rent() {
        if (!isRented) {
            isRented = true;
            System.out.println(model + " has been rented.");
        } else {
            System.out.println(model + " is already rented.");
        }
    }

    @Override
    public void returnVehicle() {
        if (isRented) {
            isRented = false;
            System.out.println(model + " has been returned.");
        } else {
            System.out.println(model + " was not rented.");
        }
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * dailyRate;
    }

    @Override
    public String getVehicleDetails() {
        return "Bicycle: " + model + ", Daily Rate: $" + dailyRate + ", Rented: " + isRented;
    }
}

// RentalManager class to manage the rental process
public class RentalManager {
    private List<Rentable> vehicles;

    public RentalManager() {
        vehicles = new ArrayList<>();
    }

    public void addVehicle(Rentable vehicle) {
        vehicles.add(vehicle);
        System.out.println("Added: " + vehicle.getVehicleDetails());
    }

    public void rentVehicle(Rentable vehicle) {
        vehicle.rent();
    }

    public void returnVehicle(Rentable vehicle) {
        vehicle.returnVehicle();
    }

    public void displayVehicles() {
        for (Rentable vehicle : vehicles) {
            System.out.println(vehicle.getVehicleDetails());
        }
    }

    public static void main(String[] args) {
        RentalManager manager = new RentalManager();

        Car car = new Car("Tata Nano", 50);
        Motorcycle motorcycle = new Motorcycle("Hero Splendor", 30);
        Bicycle bicycle = new Bicycle("B-Twin", 10);

        manager.addVehicle(car);
        manager.addVehicle(motorcycle);
        manager.addVehicle(bicycle);

        manager.displayVehicles();

        System.out.println("\nRenting vehicles:");
        manager.rentVehicle(car);
        manager.rentVehicle(motorcycle);

        manager.displayVehicles();

        System.out.println("\nReturning vehicles:");
        manager.returnVehicle(car);
        manager.returnVehicle(motorcycle);

        manager.displayVehicles();
    }
}
