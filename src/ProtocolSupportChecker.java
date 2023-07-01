import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ProtocolSupportChecker {

    public static void main(String[] args) {
        checkProtocolSupport("http", "www.example.com", 80);
        checkProtocolSupport("https", "www.example.com", 443);
        checkProtocolSupport("ftp", "ftp.example.com", 21);
        checkProtocolSupport("sftp", "sftp.example.com", 22);
    }

    private static void checkProtocolSupport(String protocol, String host, int port) {
        try (Socket socket = new Socket(host, port)) {
            System.out.println(protocol + " is supported.");
        } catch (UnknownHostException e) {
            System.out.println(protocol + " is not supported. Unknown host: " + host);
        } catch (IOException e) {
            System.out.println(protocol + " is not supported. " + e.getMessage());
        }
    }
}
