import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastReceiver {
    public static void main(String[] args) {
        try {
            InetAddress group = InetAddress.getByName("224.0.0.1"); // Multicast group address
            int port = 8888; // Multicast group port

            MulticastSocket socket = new MulticastSocket(port);
            socket.joinGroup(group);

            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            System.out.println("Waiting for multicast messages...");
            while (true) {
                socket.receive(packet);
                String message = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received: " + message);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
