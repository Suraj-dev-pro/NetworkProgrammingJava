import java.net.InetAddress;
import java.net.UnknownHostException;

public class WebsiteIPChecker {
    public static void main(String[] args) {
        String websiteURL = "www.geeksforgeeks.org"; // Replace with the website URL

        try {
            InetAddress address = InetAddress.getByName(websiteURL);

            System.out.println("IP Address of " + websiteURL + ": " + address.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
