import java.util.Scanner;
import java.util.StringTokenizer;

public class WordCountWithStringTokenizer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String sentence = scanner.nextLine();

        StringTokenizer tokenizer = new StringTokenizer(sentence);
        int wordCount = tokenizer.countTokens();

        System.out.println("Total number of words: " + wordCount);

        scanner.close();
    }
}

