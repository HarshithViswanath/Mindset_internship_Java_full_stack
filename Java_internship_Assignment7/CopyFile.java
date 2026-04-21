import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {
    public static void main(String[] args) {
        String sourceFile = "details.txt";
        String destFile = "details_copy.txt";

        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destFile)) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("Copied from " + sourceFile + " to " + destFile);
        } catch (IOException e) {
            System.err.println("File copy error: " + e.getMessage());
        }
    }
}
