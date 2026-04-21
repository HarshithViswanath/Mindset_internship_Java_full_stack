import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ScannerToFile {
    public static void main(String[] args) {
        String fileName = "user_input.txt";

        try (Scanner scanner = new Scanner(System.in);
             FileWriter writer = new FileWriter(fileName)) {

            System.out.println("Enter some text (type 'exit' on a new line to finish):");

            while (true) {
                String line = scanner.nextLine();
                if ("exit".equalsIgnoreCase(line.trim())) {
                    break;
                }
                writer.write(line + System.lineSeparator());
            }

            System.out.println("User input saved to " + fileName);
        } catch (IOException e) {
            System.err.println("Error writing user input to file: " + e.getMessage());
        }
    }
}
