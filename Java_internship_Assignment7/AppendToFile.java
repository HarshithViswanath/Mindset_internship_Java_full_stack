import java.io.FileWriter;
import java.io.IOException;

public class AppendToFile {
    public static void main(String[] args) {
        String fileName = "details.txt";
        String newContent = "\nCourse: B.Tech in Computer Science";

        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(newContent);
            System.out.println("Appended data to " + fileName);
        } catch (IOException e) {
            System.err.println("Error appending to file: " + e.getMessage());
        }
    }
}
