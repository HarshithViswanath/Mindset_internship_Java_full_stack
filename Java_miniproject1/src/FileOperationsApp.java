import java.util.Scanner;

public class FileOperationsApp {

    public static void main(String[] args) {
        LogManager logManager = new LogManager();
        AuthManager authManager = new AuthManager(logManager);
        FileManager fileManager = new FileManager();

        try (Scanner scanner = new Scanner(System.in)) {
            boolean loggedIn = authManager.performLogin(scanner);
            if (!loggedIn) {
                System.out.println("Too many failed attempts. Access restricted.");
                return;
            }
            showMenu(scanner, logManager, fileManager);
        }
    }

    private static void showMenu(Scanner scanner, LogManager logManager, FileManager fileManager) {
        while (true) {
            System.out.println();
            System.out.println("==== File Operations Menu ====");
            System.out.println("1. Create a File");
            System.out.println("2. Read a File");
            System.out.println("3. Append to a File");
            System.out.println("4. Create a Folder");
            System.out.println("5. Remove Folder");
            System.out.println("6. Delete a File");
            System.out.println("7. Show Contents of a Folder");
            System.out.println("8. Show Login Logs & Statistics");
            System.out.println("9. Quit");
            System.out.print("Enter your choice (1-9): ");

            String choiceInput = scanner.nextLine().trim();
            int choice;
            try {
                choice = Integer.parseInt(choiceInput);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number between 1 and 9.");
                continue;
            }

            switch (choice) {
                case 1:
                    fileManager.createFile(scanner);
                    break;
                case 2:
                    fileManager.readFile(scanner);
                    break;
                case 3:
                    fileManager.appendToFile(scanner);
                    break;
                case 4:
                    fileManager.createFolder(scanner);
                    break;
                case 5:
                    fileManager.removeFolder(scanner);
                    break;
                case 6:
                    fileManager.deleteFile(scanner);
                    break;
                case 7:
                    fileManager.showFolderContents(scanner);
                    break;
                case 8:
                    logManager.showLoginLogsAndStats();
                    break;
                case 9:
                    System.out.println("Exiting the application. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please select between 1 and 9.");
            }
        }
    }
}
