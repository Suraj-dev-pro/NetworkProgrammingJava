import java.io.*;
import java.net.*;

public class UDPClientNumber {
    public static void main(String[] args) {
        try {
            // Server address and port
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 5000;

            // Create socket
            DatagramSocket socket = new DatagramSocket();

            // Read user input from console
            BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter a number: ");
            String userInput = userInputReader.readLine();

            // Convert user input to bytes
            byte[] sendData = userInput.getBytes();

            // Create datagram packet for sending data to the server
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);

            // Send the packet to the server
            socket.send(sendPacket);

            // Create a byte array to receive the server's response
            byte[] receiveData = new byte[1024];

            // Create a datagram packet for receiving data from the server
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            // Receive the packet from the server
            socket.receive(receivePacket);

            // Get the server's response as a string
            String serverResponse = new String(receivePacket.getData(), 0, receivePacket.getLength());

            // Print the server's response
            System.out.println("Server response: " + serverResponse);

            // Close the socket
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
