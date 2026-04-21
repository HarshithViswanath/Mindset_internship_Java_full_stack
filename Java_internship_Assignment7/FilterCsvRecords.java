import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterCsvRecords {
    public static void main(String[] args) {
        String fileName = "students.csv";
        double threshold = 75.0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            String header = br.readLine();
            if (header != null && header.toLowerCase().contains("marks")) {
                System.out.println("Header: " + header);
            } else {
                if (header != null) {
                    processLine(header, threshold);
                }
            }

            while ((line = br.readLine()) != null) {
                processLine(line, threshold);
            }
        } catch (IOException e) {
            System.err.println("CSV read error: " + e.getMessage());
        }
    }

    private static void processLine(String line, double threshold) {
        String[] parts = line.split(",");
        if (parts.length < 3) {
            return;
        }
        try {
            double marks = Double.parseDouble(parts[2].trim());
            if (marks > threshold) {
                System.out.println("Record: " + line);
            }
        } catch (NumberFormatException e) {
        }
    }
}
