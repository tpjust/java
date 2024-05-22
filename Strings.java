//string operations 
import java.util.*;
public class Strings {

    // Method to concatenate two strings
    public static String concatenateStrings(String str1, String str2) {
        return str1 + str2;
    }

    // Method to find the length of a string
    public static int getStringLength(String str) {
        return str.length();
    }

    // Method to convert a string to uppercase
    public static String convertToUpperCase(String str) {
        return str.toUpperCase();
    }

    // Method to convert a string to lowercase
    public static String convertToLowerCase(String str) {
        return str.toLowerCase();
    }

    // Method to check if a string contains a specific substring
    public static boolean containsSubstring(String str, String substr) {
        return str.contains(substr);
    }

    // Method to replace a substring with another substring in a string
    public static String replaceSubstring(String str, String oldSubstr, String newSubstr) {
        return str.replace(oldSubstr, newSubstr);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display menu
        System.out.println("String Operations:");
        System.out.println("A. Concatenate two strings");
        System.out.println("B. Find the length of a string");
        System.out.println("C. Convert a string to uppercase");
        System.out.println("D. Convert a string to lowercase");
        System.out.println("E. Check if a string contains a specific substring");
        System.out.println("F. Replace a substring with another substring in a string");
        System.out.print("Choose an option (A-F): ");

        char choice = scanner.next().charAt(0);
        scanner.nextLine();  // Consume the newline

        switch (choice) {
            case 'A':
                System.out.print("Enter the first string: ");
                String str1 = scanner.nextLine();
                System.out.print("Enter the second string: ");
                String str2 = scanner.nextLine();
                System.out.println("Concatenated string: " + concatenateStrings(str1, str2));
                break;
            case 'B':
                System.out.print("Enter the string: ");
                String strLength = scanner.nextLine();
                System.out.println("Length of the string: " + getStringLength(strLength));
                break;
            case 'C':
                System.out.print("Enter the string: ");
                String strUpper = scanner.nextLine();
                System.out.println("Uppercase string: " + convertToUpperCase(strUpper));
                break;
            case 'D':
                System.out.print("Enter the string: ");
                String strLower = scanner.nextLine();
                System.out.println("Lowercase string: " + convertToLowerCase(strLower));
                break;
            case 'E':
                System.out.print("Enter the main string: ");
                String mainStr = scanner.nextLine();
                System.out.print("Enter the substring to check: ");
                String substr = scanner.nextLine();
                System.out.println("Contains substring: " + containsSubstring(mainStr, substr));
                break;
            case 'F':
                System.out.print("Enter the main string: ");
                String mainString = scanner.nextLine();
                System.out.print("Enter the substring to replace: ");
                String oldSubstr = scanner.nextLine();
                System.out.print("Enter the new substring: ");
                String newSubstr = scanner.nextLine();
                System.out.println("Modified string: " + replaceSubstring(mainString, oldSubstr, newSubstr));
                break;
            default:
                System.out.println("Invalid option. Please choose A-F.");
                break;
        }

        scanner.close();
    }
}


