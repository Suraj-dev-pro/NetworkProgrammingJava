import java.io.*;
import java.net.*;

public class UDPServerNumber {
    public static void main(String[] args) {
        try {
            // Server port
            int serverPort = 5000;

            // Create server socket
            DatagramSocket socket = new DatagramSocket(serverPort);

            System.out.println("Server started. Waiting for incoming connections...");

            while (true) {
                // Create a byte array to receive client data
                byte[] receiveData = new byte[1024];

                // Create a datagram packet for receiving data from the client
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

                // Receive the packet from the client
                socket.receive(receivePacket);

                // Get the client's address and port
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                // Extract the received data from the packet
                String clientData = new String(receivePacket.getData(), 0, receivePacket.getLength());

                // Parse the client data as an integer
                int number = Integer.parseInt(clientData);

                // Determine if the number is even or odd
                String reply;
                if (number % 2 == 0) {
                    reply = "Even";
                } else {
                    reply = "Odd";
                }

                // Convert the reply to bytes
                byte[] sendData = reply.getBytes();

                // Create a datagram packet for sending the reply to the client
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);

                // Send the packet to the client
                socket.send(sendPacket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
