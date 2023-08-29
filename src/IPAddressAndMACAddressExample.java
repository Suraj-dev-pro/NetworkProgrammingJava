import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class IPAddressAndMACAddressExample {
    public static void main(String[] args) {
        try {
            // Get the IP address
            InetAddress ipAddress = InetAddress.getLocalHost();
            System.out.println("IP Address: " + ipAddress.getHostAddress());

            // Get the MAC address
            NetworkInterface networkInterface = NetworkInterface.getByInetAddress(ipAddress);
            byte[] macAddressBytes = networkInterface.getHardwareAddress();

            // Convert MAC address bytes to string
            StringBuilder macAddressBuilder = new StringBuilder();
            for (int i = 0; i < macAddressBytes.length; i++) {
                macAddressBuilder.append(String.format("%02X%s", macAddressBytes[i], (i < macAddressBytes.length - 1) ? "-" : ""));
            }
            String macAddress = macAddressBuilder.toString();

            System.out.println("MAC Address: " + macAddress);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
