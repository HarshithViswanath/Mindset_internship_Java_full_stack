import java.util.Scanner;

public class AuthManager {

    private static final String VALID_USERNAME = "USER1";
    private static final String VALID_PASSWORD = "USER1";

    private final LogManager logManager;

    public AuthManager(LogManager logManager) {
        this.logManager = logManager;
    }

    public boolean performLogin(Scanner scanner) {
        int attempts = 0;
        while (attempts < 5) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine().trim();
            System.out.print("Enter password: ");
            String password = scanner.nextLine().trim();

            if (VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password)) {
                logManager.logSuccess(username);
                System.out.println("Login successful.");
                return true;
            } else {
                attempts++;
                logManager.logFailure(username);
                System.out.println("Invalid credentials. Attempt " + attempts + " of 5.");
            }
        }
        return false;
    }
}
