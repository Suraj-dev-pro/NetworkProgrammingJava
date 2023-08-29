import java.net.*;

public class InetAddressExample {
    public static void main(String[] args) {
        try {
            InetAddress ipAddr = InetAddress.getLocalHost();

            System.out.println("Instagram IP: " + ipAddr.getByName("instagram.com"));

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
