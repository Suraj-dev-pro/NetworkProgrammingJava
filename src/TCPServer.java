import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) {
        try {
            // Server port
            int serverPort = 5000;

            // Create server socket
            ServerSocket serverSocket = new ServerSocket(serverPort);

            System.out.println("Server started. Waiting for incoming connections...");

            // Wait for client connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            // Create reader and writer for socket communication
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read client message and print
            String clientMessage = reader.readLine();
            System.out.println("Client message: " + clientMessage);

            // Send response to the client
            writer.println("Hello, client!");

            // Close the socket and streams
            reader.close();
            writer.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
