import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class LogManager {

    private final Path logDir;
    private final Path successLog;
    private final Path failureLog;
    private final DateTimeFormatter formatter;

    public LogManager() {
        this.logDir = Paths.get("logs");
        this.successLog = logDir.resolve("login_success.log");
        this.failureLog = logDir.resolve("login_failure.log");
        this.formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        ensureLogDirectory();
    }

    private void ensureLogDirectory() {
        try {
            if (Files.notExists(logDir)) {
                Files.createDirectories(logDir);
            }
        } catch (IOException e) {
            System.out.println("Warning: Could not create log directory: " + e.getMessage());
        }
    }

    public void logSuccess(String username) {
        logLoginAttempt(successLog, username, true);
    }

    public void logFailure(String username) {
        logLoginAttempt(failureLog, username, false);
    }

    private void logLoginAttempt(Path logFile, String username, boolean success) {
        String status = success ? "SUCCESS" : "FAILURE";
        String timestamp = LocalDateTime.now().format(formatter);
        String line = String.format("%s - %s - user=%s%n", timestamp, status, username);
        try {
            if (Files.notExists(logFile)) {
                Files.createFile(logFile);
            }
            Files.write(logFile, line.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Warning: Could not write to log file: " + e.getMessage());
        }
    }

    public void showLoginLogsAndStats() {
        System.out.println();
        System.out.println("==== Login Logs & Statistics ====");

        long successCount = 0;
        long failureCount = 0;

        System.out.println();
        System.out.println("-- Successful Login Attempts --");
        if (Files.exists(successLog)) {
            try {
                List<String> successLines = Files.readAllLines(successLog, StandardCharsets.UTF_8);
                successCount = successLines.size();
                if (successLines.isEmpty()) {
                    System.out.println("No successful login attempts recorded.");
                } else {
                    for (String line : successLines) {
                        System.out.println(line);
                    }
                }
            } catch (IOException e) {
                System.out.println("Error reading success log: " + e.getMessage());
            }
        } else {
            System.out.println("No success log file found yet.");
        }

        System.out.println();
        System.out.println("-- Failed Login Attempts --");
        if (Files.exists(failureLog)) {
            try {
                List<String> failureLines = Files.readAllLines(failureLog, StandardCharsets.UTF_8);
                failureCount = failureLines.size();
                if (failureLines.isEmpty()) {
                    System.out.println("No failed login attempts recorded.");
                } else {
                    for (String line : failureLines) {
                        System.out.println(line);
                    }
                }
            } catch (IOException e) {
                System.out.println("Error reading failure log: " + e.getMessage());
            }
        } else {
            System.out.println("No failure log file found yet.");
        }

        System.out.println();
        System.out.println("==== Summary ====");
        System.out.println("Total successful login attempts: " + successCount);
        System.out.println("Total failed login attempts    : " + failureCount);
        System.out.println("================================");
    }
}
