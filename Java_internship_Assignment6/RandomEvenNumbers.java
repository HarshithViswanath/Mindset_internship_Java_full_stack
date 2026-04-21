import java.util.Random;

public class RandomEvenNumbers {
    public static void main(String[] args) {
        Random random = new Random();

        System.out.println("20 random numbers between 1 and 50 (only even numbers shown):");
        for (int i = 0; i < 20; i++) {
            int number = random.nextInt(50) + 1; // 1 to 50
            if (number % 2 == 0) {
                System.out.println("Even number: " + number);
            }
        }
    }
}

