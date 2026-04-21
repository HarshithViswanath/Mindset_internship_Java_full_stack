import java.util.StringTokenizer;

public class StringTokenizerSum {
    public static void main(String[] args) {
        String data = "100-200-300-400";
        StringTokenizer tokenizer = new StringTokenizer(data, "-");

        int sum = 0;
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            int value = Integer.parseInt(token);
            sum += value;
        }

        System.out.println("String: " + data);
        System.out.println("Sum of numbers: " + sum);
    }
}

