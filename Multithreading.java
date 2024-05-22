//multithreading
import java.util.*;
public class Multithreading {

    // Method to create and start 5 threads
    public static void createThreads() {
        for (int i = 1; i <= 5; i++) {
            Thread t = new Thread(new SimpleThread(i));
            t.start();
            try {
                Thread.sleep(100); // To simulate some delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Synchronized method to print 2's table
    public synchronized void printTableOf2() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("2 x " + i + " = " + (2 * i));
            try {
                Thread.sleep(100); // To simulate some delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Synchronized method to print 5's table
    public synchronized void printTableOf5() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("5 x " + i + " = " + (5 * i));
            try {
                Thread.sleep(100); // To simulate some delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Method to demonstrate daemon thread
    public static void daemonThreadDemo() {
        DaemonThread daemonRunnable = new DaemonThread();
        Thread daemonThread = new Thread(daemonRunnable);
        daemonThread.setDaemon(true);
        daemonThread.start();

        try {
            // Main thread sleeps for 1 second, then terminates
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Interrupt the daemon thread
        daemonThread.interrupt();
        System.out.println("Main thread finished.");
        try {
            Thread.sleep(100); // Small delay to ensure proper ordering
        } catch (InterruptedException e) {
            e.printStackTrace();
        } 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Multithreading mainObj = new Multithreading();
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Create 5 Threads");
            System.out.println("2. Print 2's Table");
            System.out.println("3. Print 5's Table");
            System.out.println("4. Demonstrate Daemon Thread");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createThreads();
                    break;
                case 2:
                    mainObj.printTableOf2();
                    break;
                case 3:
                    mainObj.printTableOf5();
                    break;
                case 4:
                    daemonThreadDemo();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}

class SimpleThread implements Runnable {
    private int threadNumber;

    public SimpleThread(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        System.out.println("Thread " + threadNumber + " is running.");
    }
}

class DaemonThread implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Daemon thread is running...");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // Daemon thread was interrupted, exit the loop gracefully
                System.out.println("Daemon thread interrupted.");
                break;
            }
        }
    }
}


