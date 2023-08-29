import java.net.*;

public class LocalHostExample {
    public static void main(String[] args) {
        try {
            InetAddress localAddress = InetAddress.getLocalHost();

            System.out.println("Local Host Name: " + localAddress.getHostName());
            System.out.println("Local IP Address: " + localAddress.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
