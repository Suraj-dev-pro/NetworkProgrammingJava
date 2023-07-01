import java.io.*;
import java.net.*;

public class UDPServer {
    public static void main(String[] args) {
        try {
            // Server port
            int serverPort = 5000;

            // Create socket
            DatagramSocket socket = new DatagramSocket(serverPort);

            System.out.println("Server started. Waiting for incoming messages...");

            while (true) {
                // Receive request from the client
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);

                // Extract the message and client details
                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                System.out.println("Received message from client: " + message);

                // Prepare the response message
                String responseMessage = "Hello, client!";

                // Convert the response message to bytes
                byte[] sendData = responseMessage.getBytes();

                // Create packet with the response message and client details
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);

                // Send the response to the client
                socket.send(sendPacket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
