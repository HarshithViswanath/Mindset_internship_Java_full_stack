import java.net.InetAddress;
import java.net.UnknownHostException;

public class WebsiteInfo {
    public static void main(String[] args) {
        String website = "www.google.com"; // you can change this

        try {
            InetAddress inetAddress = InetAddress.getByName(website);

            System.out.println("Host Name: " + inetAddress.getHostName());
            System.out.println("IP Address: " + inetAddress.getHostAddress());
        } catch (UnknownHostException e) {
            System.out.println("Unable to resolve host: " + website);
            e.printStackTrace();
        }
    }
}
