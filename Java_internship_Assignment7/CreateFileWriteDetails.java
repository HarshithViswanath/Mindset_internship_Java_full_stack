import java.io.FileWriter;
import java.io.IOException;

public class CreateFileWriteDetails {
    public static void main(String[] args) {
        String fileName = "details.txt";
        String content = "Name: Your Name\nCollege: Your College Name";

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
            System.out.println("Data written to " + fileName);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
