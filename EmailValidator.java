//Email validator 

import java.util.*;

class InvalidEmailException extends Exception {
    public InvalidEmailException(String message) {
        super(message);
    }
}

public class EmailValidator {

    // Method to validate email address
    public static void validateEmail(String email) throws InvalidEmailException {
        if (email == null || !email.contains("@") || !email.contains(".")) {
            throw new InvalidEmailException("Email must contain '@' and '.'");
        }
        int atIndex = email.indexOf('@');
        int dotIndex = email.indexOf('.');
        if (atIndex > dotIndex || atIndex == -1 || dotIndex == -1) {
            throw new InvalidEmailException("Invalid email format. '@' should come before '.'");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an email address: ");
        String email = scanner.nextLine();

        try {
            validateEmail(email);
            System.out.println("Email address is valid.");
        } catch (InvalidEmailException e) {
            System.out.println("InvalidEmailException: " + e.getMessage());
        }

        scanner.close();
    }
}

