import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.List;

public class UDPServer {
    private static final int PORT = 12345;
    private static List<DatagramPacket> clients = new ArrayList<>();

    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                byte[] receiveBuffer = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                socket.receive(receivePacket);

                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Received from " + receivePacket.getAddress() + ": " + message);

                clients.add(receivePacket);
                broadcast(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void broadcast(String message) throws IOException {
        for (DatagramPacket client : clients) {
            DatagramSocket socket = new DatagramSocket();
            DatagramPacket sendPacket = new DatagramPacket(message.getBytes(), message.length(),
                    client.getAddress(), client.getPort());
            socket.send(sendPacket);
            socket.close();
        }
    }
}
