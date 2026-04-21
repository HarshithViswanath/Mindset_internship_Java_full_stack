import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountFileStats {
    public static void main(String[] args) {
        String fileName = "details.txt"; // change if needed

        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                lineCount++;
                charCount += line.length();
                String[] words = line.trim().split("\\s+");
                if (!line.trim().isEmpty()) {
                    wordCount += words.length;
                }
            }

            System.out.println("File: " + fileName);
            System.out.println("Lines: " + lineCount);
            System.out.println("Words: " + wordCount);
            System.out.println("Characters: " + charCount);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
