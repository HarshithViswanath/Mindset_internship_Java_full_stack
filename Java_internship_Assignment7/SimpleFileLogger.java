import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SimpleFileLogger {

    private static final String LOG_FILE = "activity.log";
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;

            while (running) {
                System.out.println("\n=== Simple File Logger ===");
                System.out.println("1. Login");
                System.out.println("2. Logout");
                System.out.println("3. Transaction");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");

                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        System.out.print("Enter username: ");
                        String loginUser = scanner.nextLine();
                        log("LOGIN", "User " + loginUser + " logged in.");
                        System.out.println("Login event logged.");
                        break;
                    case "2":
                        System.out.print("Enter username: ");
                        String logoutUser = scanner.nextLine();
                        log("LOGOUT", "User " + logoutUser + " logged out.");
                        System.out.println("Logout event logged.");
                        break;
                    case "3":
                        System.out.print("Enter username: ");
                        String txnUser = scanner.nextLine();
                        System.out.print("Enter transaction details: ");
                        String details = scanner.nextLine();
                        log("TRANSACTION", "User " + txnUser + ": " + details);
                        System.out.println("Transaction event logged.");
                        break;
                    case "4":
                        running = false;
                        System.out.println("Exiting logger.");
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        }
    }

    private static void log(String type, String message) {
        String timeStamp = LocalDateTime.now().format(FORMATTER);
        String logEntry = timeStamp + " [" + type + "] " + message;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            bw.write(logEntry);
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Logging error: " + e.getMessage());
        }
    }
}
