import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) {
        try {
            // Server address and port
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 5000;

            // Create socket
            Socket socket = new Socket(serverAddress, serverPort);

            // Create reader and writer for socket communication
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            // Read user input from console
            BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter a message: ");
            String userInput = userInputReader.readLine();

            // Send user input to the server
            writer.println(userInput);

            // Read and print response from the server
            String serverResponse = reader.readLine();
            System.out.println("Server response: " + serverResponse);

            // Close the socket and streams
            reader.close();
            writer.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
