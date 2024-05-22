//user defined exception handling 
import java.util.*;

class InvalidTemperatureException extends Exception{
    InvalidTemperatureException(String message){
        super(message);
    }
}

class Converter{
    static double celsiustofar(double celsius) throws InvalidTemperatureException{
        if (celsius < -273.15 || celsius > 1000) {
            throw new InvalidTemperatureException("Invalid temperature value: " + celsius + "C");
        }
        return (celsius * 9 / 5) + 32;

    }

    static double fartocelsius(double far) throws InvalidTemperatureException{
        double celsius = (far - 32) * 5 / 9;
        if (celsius < -273.15 || celsius > 1000) {
            throw new InvalidTemperatureException("Invalid temperature value: " + celsius + "C");
        }
        return celsius;
    }
}
public class exception {
    public static void main(String[] args) throws InvalidTemperatureException {//need to mention that it can throw this exception if try catch block is not there
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter the temperature in Celsius: ");
            double celsiusInput = scanner.nextDouble();
            double fahrenheitOutput = Converter.celsiustofar(celsiusInput);
            System.out.println(celsiusInput + "C is equal to " + fahrenheitOutput + "F");
            System.out.print("Enter the temperature in Fahrenheit: ");
            double fahrenheitInput = scanner.nextDouble();
            double celsiusOutput = Converter.fartocelsius(fahrenheitInput);
            System.out.println(fahrenheitInput + "F is equal to " + celsiusOutput + "C");
        } catch (InvalidTemperatureException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Invalid input");
        } finally {
            scanner.close();
        }

    }
}
