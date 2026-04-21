import java.util.Scanner;

public class BuiltInPackagesDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        double value = scanner.nextDouble();

        double sqrt = Math.sqrt(value);
        System.out.println("Square root: " + sqrt);

        scanner.close();
    }
}

