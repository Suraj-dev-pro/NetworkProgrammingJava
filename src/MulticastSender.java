import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastSender {
    public static void main(String[] args) {
        try {
            InetAddress group = InetAddress.getByName("224.0.0.1"); // Multicast group address
            int port = 8888; // Multicast group port

            MulticastSocket socket = new MulticastSocket();

            String message = "Hello, multicast world!";
            byte[] buffer = message.getBytes();

            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, port);

            socket.send(packet);

            System.out.println("Sent multicast message: " + message);

            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
