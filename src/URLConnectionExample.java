import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.example.com");
            URLConnection connection = url.openConnection();

            // Retrieve and parse the "Content-Length" header field as an integer
            int contentLength = connection.getHeaderFieldInt("Content-Length", -1);

            if (contentLength != -1) {
                System.out.println("Content-Length: " + contentLength + " bytes");
            } else {
                System.out.println("Content-Length not available");
            }

            connection.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
