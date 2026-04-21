import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SimpleClient {
    public static void main(String[] args) {
        final String SERVER_HOST = "localhost"; // or server IP
        final int SERVER_PORT = 5000;

        try {
            InetAddress serverAddress = InetAddress.getByName(SERVER_HOST);
            System.out.println("Attempting to connect to server " +
                    SERVER_HOST + " on port " + SERVER_PORT + "...");

            try (Socket socket = new Socket(serverAddress, SERVER_PORT)) {
                System.out.println("Connected to server: " +
                        socket.getInetAddress().getHostAddress());
            }
        } catch (UnknownHostException e) {
            System.out.println("Unknown host: " + SERVER_HOST);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("I/O error while connecting to server.");
            e.printStackTrace();
        }
    }
}
