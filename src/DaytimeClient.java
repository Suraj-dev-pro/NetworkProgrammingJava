import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class DaytimeClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 9999);
            System.out.println("Connected to server.");

            // Read the date and time from the server
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String dateTimeString = reader.readLine();

            System.out.println("Current date and time: " + dateTimeString);

            socket.close();
            System.out.println("Connection closed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
