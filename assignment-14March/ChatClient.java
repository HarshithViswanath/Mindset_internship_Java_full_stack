import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {
    public static void main(String[] args) {
        final String SERVER_HOST = "localhost"; // or server IP
        final int SERVER_PORT = 6000;
        final String MESSAGE = "Hello from client!";

        try {
            InetAddress serverAddress = InetAddress.getByName(SERVER_HOST);

            try (Socket socket = new Socket(serverAddress, SERVER_PORT);
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

                System.out.println("Connected to chat server.");
                out.println(MESSAGE);
                System.out.println("Message sent to server: " + MESSAGE);
            }
        } catch (UnknownHostException e) {
            System.out.println("Unknown host: " + SERVER_HOST);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("I/O error in chat client.");
            e.printStackTrace();
        }
    }
}
