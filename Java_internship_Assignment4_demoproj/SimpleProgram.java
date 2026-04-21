package mydemo;  // user-defined package

import java.util.Scanner;

// Interface with one method
interface Calculator {
    // Uses wrapper classes and declares it may throw an exception
    Double divide(Integer a, Integer b) throws ArithmeticException;
}

// Main public class (file name must be SimpleProgram.java)
public class SimpleProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Read first number from user as String
            System.out.print("Enter first integer: ");
            String firstInput = scanner.nextLine();

            // Convert String to Integer (wrapper class)
            Integer x = Integer.valueOf(firstInput);  // may throw NumberFormatException

            // Read second number from user as String
            System.out.print("Enter second integer: ");
            String secondInput = scanner.nextLine();

            // Convert String to Integer
            Integer y = Integer.valueOf(secondInput); // may throw NumberFormatException

            // Interface reference to implementing class
            Calculator calc = new SimpleCalculator();

            try {
                // Perform division (may throw ArithmeticException)
                Double result = calc.divide(x, y);
                System.out.println("Result = " + result);
            } catch (ArithmeticException e) {
                // Handle divide-by-zero or other arithmetic errors
                System.out.println("Error while dividing: " + e.getMessage());
            }

        } catch (NumberFormatException e) {
            // Handle invalid integer input
            System.out.println("You did not enter a valid integer. " +
                               "Details: " + e.getMessage());
        } finally {
            // This block always runs
            System.out.println("Program finished.");
            scanner.close();
        }
    }
}

// Class that implements the interface
class SimpleCalculator implements Calculator {

    @Override
    public Double divide(Integer a, Integer b) throws ArithmeticException {
        // Explicit check for division by zero
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }

        // Use wrapper methods to convert to double and return result
        return a.doubleValue() / b.doubleValue();
    }
}
