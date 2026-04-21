import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    public static void main(String[] args) {
        final int PORT = 6000;

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Chat server started. Waiting for client on port " + PORT + "...");

            try (Socket clientSocket = serverSocket.accept();
                 BufferedReader in = new BufferedReader(
                         new InputStreamReader(clientSocket.getInputStream()))) {

                System.out.println("Client connected from: " +
                        clientSocket.getInetAddress().getHostAddress());

                String message = in.readLine();
                System.out.println("Received message from client: " + message);
            }
        } catch (IOException e) {
            System.out.println("Chat server error.");
            e.printStackTrace();
        }
    }
}
