import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketFactoryExample {
    public static void main(String[] args) {
        try {
            // Using a factory method to create a Socket instance
            Socket socket = SocketFactory.createSocket("www.example.com", 80);

            // Get the output stream of the socket
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Send a request to the server
            out.println("GET / HTTP/1.1");
            out.println("Host: www.example.com");
            out.println();

            // Read the response from the server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String responseLine;
            while ((responseLine = in.readLine()) != null) {
                System.out.println(responseLine);
            }

            // Close the streams and the socket
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SocketFactory {
    public static Socket createSocket(String host, int port) throws IOException {
        // Custom logic for creating a Socket instance
        // For example, you can apply additional configurations or checks before creating the socket
        return new Socket(host, port);
    }
}
