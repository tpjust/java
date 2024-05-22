//armstrong  anagrams  comapre DOB prime check 

import java.util.*;
import java.time.*;//LocalDate
import java.time.format.*;//DateTimeFormatter

public class logic {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Armstrong number check
        System.out.print("Enter a number to check if it's an Armstrong number: ");
        int armstrongNumber = scanner.nextInt();
        System.out.println(isArmstrong(armstrongNumber) 
            ? armstrongNumber + " is an Armstrong number." 
            : armstrongNumber + " is not an Armstrong number.");
        
        scanner.nextLine(); // consume newline

        // Anagram check
        System.out.print("Enter first string for anagram check: ");
        String str1 = scanner.nextLine();
        System.out.print("Enter second string for anagram check: ");
        String str2 = scanner.nextLine();
        System.out.println(areAnagrams(str1, str2) 
            ? "The strings are anagrams." 
            : "The strings are not anagrams.");

        // Compare DOB
        System.out.print("Enter first date of birth (yyyy-MM-dd): ");
        String dob1 = scanner.nextLine();
        System.out.print("Enter second date of birth (yyyy-MM-dd): ");
        String dob2 = scanner.nextLine();
        System.out.println(compareDOB(dob1, dob2));

        // Prime number check
        System.out.print("Enter a number to check if it's a prime number: ");
        int primeNumber = scanner.nextInt();
        System.out.println(isPrime(primeNumber) 
            ? primeNumber + " is a prime number." 
            : primeNumber + " is not a prime number.");

        scanner.close();
    }

    // Method to check if a number is an Armstrong number
    static boolean isArmstrong(int number) {
        int originalNumber = number;
        int sum = 0;
        int digits = Integer.toString(number).length();

        while (number != 0) {
            int remainder = number % 10;
            sum += Math.pow(remainder, digits);
            number /= 10;
        }

        return sum == originalNumber;
    }

    // Method to check if two strings are anagrams
    public static boolean areAnagrams(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        return Arrays.equals(charArray1, charArray2);
    }

    // Method to compare two dates of birth
    public static String compareDOB(String dob1, String dob2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");// format of dob
        LocalDate date1 = LocalDate.parse(dob1, formatter);
        LocalDate date2 = LocalDate.parse(dob2, formatter);

        if (date1.isBefore(date2)) {
            return "First person is elder.";
        } else if (date1.isAfter(date2)) {
            return "First person is younger.";
        } else {
            return "Both persons are of the same age.";
        }
    }

    // Method to check if a number is prime
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
