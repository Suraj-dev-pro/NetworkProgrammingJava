import java.net.*;

public class CanonicalNameExample {
    public static void main(String[] args) {
        try {
            String hostName = "www.google.com";
            InetAddress address = InetAddress.getByName(hostName);

            System.out.println("Canonical Host Name: " + address.getCanonicalHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
