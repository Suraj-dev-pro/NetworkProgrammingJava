import java.io.IOException;
import java.net.ServerSocket;

public class OpenPortsScanner {

    public static void main(String[] args) {
        int fromPort = 1; // Starting port number
        int toPort = 65535; // Ending port number

        for (int port = fromPort; port <= toPort; port++) {
            try {
                ServerSocket serverSocket = new ServerSocket(port);
                serverSocket.close();
                System.out.println("Port " + port + " is open.");
            } catch (IOException e) {
                // Port is already in use or unavailable
            }
        }
    }
}
