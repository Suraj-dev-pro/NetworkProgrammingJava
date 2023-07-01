import java.net.InetAddress;
import java.net.Socket;

public class SocketInformationExample {
    public static void main(String[] args) {
        try {
            // Create a socket with a remote address and port
            Socket socket = new Socket("www.example.com", 80);

            // Get the remote address and port
            InetAddress remoteAddress = socket.getInetAddress();
            int remotePort = socket.getPort();

            // Get the local address and port
            InetAddress localAddress = socket.getLocalAddress();
            int localPort = socket.getLocalPort();

            // Display the socket information
            System.out.println("Remote Address: " + remoteAddress.getHostAddress());
            System.out.println("Remote Port: " + remotePort);
            System.out.println("Local Address: " + localAddress.getHostAddress());
            System.out.println("Local Port: " + localPort);

            // Close the socket
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
