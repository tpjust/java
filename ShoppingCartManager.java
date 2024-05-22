//online shopping cart

import java.util.*;

// Define the Purchasable interface
interface Purchasable {
    void addItem(int quantity);
    void removeItem(int quantity);
    double calculateTotalPrice();
    String getItemDetails();
}

// Electronics class implementing the Purchasable interface
class Electronics implements Purchasable {
    private String name;
    private double price;
    private int quantity;

    public Electronics(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantity = 0;
    }

    @Override
    public void addItem(int quantity) {
        this.quantity += quantity;
        System.out.println(quantity + " " + name + "(s) added to the cart.");
    }

    @Override
    public void removeItem(int quantity) {
        if (this.quantity >= quantity) {
            this.quantity -= quantity;
            System.out.println(quantity + " " + name + "(s) removed from the cart.");
        } else {
            System.out.println("Cannot remove " + quantity + " " + name + "(s). Only " + this.quantity + " in the cart.");
        }
    }

    @Override
    public double calculateTotalPrice() {
        return this.quantity * this.price;
    }

    @Override
    public String getItemDetails() {
        return name + ": $" + price + " x " + quantity + " = $" + calculateTotalPrice();
    }
}

// Clothing class implementing the Purchasable interface
class Clothing implements Purchasable {
    private String name;
    private double price;
    private int quantity;

    public Clothing(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantity = 0;
    }

    @Override
    public void addItem(int quantity) {
        this.quantity += quantity;
        System.out.println(quantity + " " + name + "(s) added to the cart.");
    }

    @Override
    public void removeItem(int quantity) {
        if (this.quantity >= quantity) {
            this.quantity -= quantity;
            System.out.println(quantity + " " + name + "(s) removed from the cart.");
        } else {
            System.out.println("Cannot remove " + quantity + " " + name + "(s). Only " + this.quantity + " in the cart.");
        }
    }

    @Override
    public double calculateTotalPrice() {
        return this.quantity * this.price;
    }

    @Override
    public String getItemDetails() {
        return name + ": $" + price + " x " + quantity + " = $" + calculateTotalPrice();
    }
}

// Book class implementing the Purchasable interface
class Book implements Purchasable {
    private String title;
    private double price;
    private int quantity;

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
        this.quantity = 0;
    }

    @Override
    public void addItem(int quantity) {
        this.quantity += quantity;
        System.out.println(quantity + " " + title + "(s) added to the cart.");
    }

    @Override
    public void removeItem(int quantity) {
        if (this.quantity >= quantity) {
            this.quantity -= quantity;
            System.out.println(quantity + " " + title + "(s) removed from the cart.");
        } else {
            System.out.println("Cannot remove " + quantity + " " + title + "(s). Only " + this.quantity + " in the cart.");
        }
    }

    @Override
    public double calculateTotalPrice() {
        return this.quantity * this.price;
    }

    @Override
    public String getItemDetails() {
        return title + ": $" + price + " x " + quantity + " = $" + calculateTotalPrice();
    }
}

// ShoppingCartManager class to manage the shopping cart
public class ShoppingCartManager {
    private List<Purchasable> cart;

    public ShoppingCartManager() {
        cart = new ArrayList<>();
    }

    public void addItemToCart(Purchasable item, int quantity) {
        item.addItem(quantity);
        if (!cart.contains(item)) {
            cart.add(item);
        }
    }

    public void removeItemFromCart(Purchasable item, int quantity) {
        item.removeItem(quantity);
        if (item.calculateTotalPrice() == 0) {
            cart.remove(item);
        }
    }

    public void displayCartItems() {
        if (cart.isEmpty()) {
            System.out.println("The cart is empty.");
        } else {
            System.out.println("Items in the cart:");
            for (Purchasable item : cart) {
                System.out.println(item.getItemDetails());
            }
        }
    }

    public void checkout() {
        if (cart.isEmpty()) {
            System.out.println("The cart is empty. Nothing to checkout.");
        } else {
            double total = 0;
            System.out.println("Checking out the following items:");
            for (Purchasable item : cart) {
                System.out.println(item.getItemDetails());
                total += item.calculateTotalPrice();
            }
            System.out.println("Total amount to be paid: $" + total);
            cart.clear();
        }
    }

    public static void main(String[] args) {
        ShoppingCartManager manager = new ShoppingCartManager();

        Electronics laptop = new Electronics("Laptop", 800);
        Clothing tshirt = new Clothing("T-Shirt", 20);
        Book novel = new Book("Novel", 15);

        manager.addItemToCart(laptop, 1);
        manager.addItemToCart(tshirt, 3);
        manager.addItemToCart(novel, 2);

        manager.displayCartItems();

        manager.removeItemFromCart(tshirt, 1);
        manager.displayCartItems();

        manager.checkout();
        manager.displayCartItems();
    }
}
