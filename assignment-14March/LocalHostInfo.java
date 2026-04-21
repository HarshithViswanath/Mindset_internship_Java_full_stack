import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalHostInfo {
    public static void main(String[] args) {
        try {
            InetAddress localHost = InetAddress.getLocalHost();

            System.out.println("Local Host Name: " + localHost.getHostName());
            System.out.println("Local IP Address: " + localHost.getHostAddress());
        } catch (UnknownHostException e) {
            System.out.println("Unable to get local host information.");
            e.printStackTrace();
        }
    }
}
