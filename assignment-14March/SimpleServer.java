import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    public static void main(String[] args) {
        final int PORT = 5000;

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started. Waiting for client on port " + PORT + "...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected from: " +
                    clientSocket.getInetAddress().getHostAddress());

            clientSocket.close();
        } catch (IOException e) {
            System.out.println("Server error.");
            e.printStackTrace();
        }
    }
}
