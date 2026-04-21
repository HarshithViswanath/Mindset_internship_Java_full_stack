class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class UserDefinedExceptionDemo {
    static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above to vote");
        } else {
            System.out.println("Valid age. You can vote");
        }
    }

    public static void main(String[] args) {
        try {
            validateAge(16);
        } catch (InvalidAgeException ex) {
            System.out.println("Caught custom exception: " + ex.getMessage());
        }

        System.out.println("Program continues");
    }
}

