import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

public class FileManager {

    public void createFile(Scanner scanner) {
        System.out.print("Enter file name to create (relative or absolute path): ");
        String fileName = scanner.nextLine().trim();
        if (fileName.isEmpty()) {
            System.out.println("File name cannot be empty.");
            return;
        }

        Path filePath = Paths.get(fileName);
        System.out.println("Enter file content. Type a single line with 'EOF' to finish:");

        StringBuilder contentBuilder = new StringBuilder();
        while (true) {
            String line = scanner.nextLine();
            if ("EOF".equalsIgnoreCase(line)) {
                break;
            }
            contentBuilder.append(line).append(System.lineSeparator());
        }

        try {
            if (Files.notExists(filePath)) {
                if (filePath.getParent() != null && Files.notExists(filePath.getParent())) {
                    Files.createDirectories(filePath.getParent());
                }
            }
            Files.write(filePath, contentBuilder.toString().getBytes(StandardCharsets.UTF_8));
            System.out.println("File created successfully: " + filePath.toAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }
    }

    public void readFile(Scanner scanner) {
        System.out.print("Enter file name to read: ");
        String fileName = scanner.nextLine().trim();
        if (fileName.isEmpty()) {
            System.out.println("File name cannot be empty.");
            return;
        }
        Path filePath = Paths.get(fileName);
        if (Files.notExists(filePath)) {
            System.out.println("File does not exist: " + filePath.toAbsolutePath());
            return;
        }

        try {
            List<String> lines = Files.readAllLines(filePath, StandardCharsets.UTF_8);
            System.out.println("----- File Contents -----");
            for (String line : lines) {
                System.out.println(line);
            }
            System.out.println("----- End of File -----");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public void appendToFile(Scanner scanner) {
        System.out.print("Enter file name to append to: ");
        String fileName = scanner.nextLine().trim();
        if (fileName.isEmpty()) {
            System.out.println("File name cannot be empty.");
            return;
        }
        Path filePath = Paths.get(fileName);
        if (Files.notExists(filePath)) {
            System.out.println("File does not exist: " + filePath.toAbsolutePath());
            return;
        }

        System.out.println("Enter content to append. Type a single line with 'EOF' to finish:");
        StringBuilder contentBuilder = new StringBuilder();
        while (true) {
            String line = scanner.nextLine();
            if ("EOF".equalsIgnoreCase(line)) {
                break;
            }
            contentBuilder.append(line).append(System.lineSeparator());
        }

        try {
            Files.write(filePath, contentBuilder.toString().getBytes(StandardCharsets.UTF_8),
                    StandardOpenOption.APPEND);
            System.out.println("Content appended successfully.");
        } catch (IOException e) {
            System.out.println("Error appending to file: " + e.getMessage());
        }
    }

    public void createFolder(Scanner scanner) {
        System.out.print("Enter folder name to create (relative or absolute path): ");
        String folderName = scanner.nextLine().trim();
        if (folderName.isEmpty()) {
            System.out.println("Folder name cannot be empty.");
            return;
        }

        Path folderPath = Paths.get(folderName);
        try {
            if (Files.exists(folderPath)) {
                System.out.println("Folder already exists: " + folderPath.toAbsolutePath());
                return;
            }
            Files.createDirectories(folderPath);
            System.out.println("Folder created successfully: " + folderPath.toAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error creating folder: " + e.getMessage());
        }
    }

    public void removeFolder(Scanner scanner) {
        System.out.print("Enter folder name to remove: ");
        String folderName = scanner.nextLine().trim();
        if (folderName.isEmpty()) {
            System.out.println("Folder name cannot be empty.");
            return;
        }

        Path folderPath = Paths.get(folderName);
        if (Files.notExists(folderPath)) {
            System.out.println("Folder does not exist: " + folderPath.toAbsolutePath());
            return;
        }

        try {
            Files.delete(folderPath);
            System.out.println("Folder removed successfully: " + folderPath.toAbsolutePath());
        } catch (DirectoryNotEmptyException e) {
            System.out.println("Cannot remove folder because it is not empty.");
        } catch (IOException e) {
            System.out.println("Error removing folder: " + e.getMessage());
        }
    }

    public void deleteFile(Scanner scanner) {
        System.out.print("Enter file name to delete: ");
        String fileName = scanner.nextLine().trim();
        if (fileName.isEmpty()) {
            System.out.println("File name cannot be empty.");
            return;
        }

        Path filePath = Paths.get(fileName);
        if (Files.notExists(filePath)) {
            System.out.println("File does not exist: " + filePath.toAbsolutePath());
            return;
        }

        try {
            Files.delete(filePath);
            System.out.println("File deleted successfully: " + filePath.toAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error deleting file: " + e.getMessage());
        }
    }

    public void showFolderContents(Scanner scanner) {
        System.out.print("Enter folder path to list contents (leave empty for current directory): ");
        String folderName = scanner.nextLine().trim();

        Path folderPath;
        if (folderName.isEmpty()) {
            folderPath = Paths.get(".").toAbsolutePath().normalize();
        } else {
            folderPath = Paths.get(folderName);
        }

        if (Files.notExists(folderPath) || !Files.isDirectory(folderPath)) {
            System.out.println("Folder does not exist or is not a directory: " + folderPath.toAbsolutePath());
            return;
        }

        System.out.println("Contents of folder: " + folderPath.toAbsolutePath());
        try {
            Files.list(folderPath).forEach(path -> {
                String type = Files.isDirectory(path) ? "[DIR] " : "[FILE]";
                System.out.println(type + " " + path.getFileName());
            });
        } catch (IOException e) {
            System.out.println("Error listing folder contents: " + e.getMessage());
        }
    }
}
