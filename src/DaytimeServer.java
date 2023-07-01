import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class DaytimeServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            System.out.println("Server started. Listening on port 9999...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

                // Create a new thread to handle client requests
                Thread thread = new Thread(() -> {
                    try {
                        // Get the current date and time
                        LocalDateTime now = LocalDateTime.now();
                        String dateTimeString = now.toString();

                        // Send the date and time to the client
                        OutputStream outputStream = clientSocket.getOutputStream();
                        outputStream.write(dateTimeString.getBytes());
                        outputStream.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            clientSocket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });

                // Start the thread to handle client requests
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
