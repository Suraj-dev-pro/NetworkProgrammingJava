import java.io.*;
import java.net.*;

public class UDPClient {
    public static void main(String[] args) {
        try {
            // Server address and port
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 5000;

            // Create socket
            DatagramSocket socket = new DatagramSocket();

            // Message to send
            String message = "Hello, server!";
            byte[] sendData = message.getBytes();

            // Create packet with the message and server details
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);

            // Send the packet to the server
            socket.send(sendPacket);

            // Receive response from the server
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);

            // Extract and print the response message
            String responseMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Server response: " + responseMessage);

            // Close the socket
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
