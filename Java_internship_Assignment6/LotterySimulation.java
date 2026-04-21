import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LotterySimulation {
    public static void main(String[] args) {
        Random random = new Random();
        Set<Integer> lotteryNumbers = new HashSet<>();

        while (lotteryNumbers.size() < 6) {
            int number = random.nextInt(49) + 1; // 1 to 49
            lotteryNumbers.add(number);
        }

        System.out.println("Lottery numbers (6 unique numbers between 1 and 49):");
        for (int num : lotteryNumbers) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

