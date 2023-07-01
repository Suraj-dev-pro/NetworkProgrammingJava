import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Random;

public class QuoteServer {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(5000);

            // Array of quotes to send as responses
            String[] quotes = {
                    "Quote 1",
                    "Quote 2",
                    "Quote 3",
                    "Quote 4",
                    "Quote 5"
            };

            Random random = new Random();

            while (true) {
                byte[] buffer = new byte[512];
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);

                socket.receive(request);

                // Get the client's address and port
                InetAddress clientAddress = request.getAddress();
                int clientPort = request.getPort();

                // Generate a random quote
                String quote = quotes[random.nextInt(quotes.length)];

                byte[] responseBytes = quote.getBytes();
                DatagramPacket response = new DatagramPacket(responseBytes, responseBytes.length, clientAddress, clientPort);

                socket.send(response);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
