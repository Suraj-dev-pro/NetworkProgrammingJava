import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class URLConnectionExample2 {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.example.com");
            URLConnection connection = url.openConnection();

            // Retrieve specific header fields
            String contentType = connection.getHeaderField("Content-Type");
            String contentLength = connection.getHeaderField("Content-Length");

            System.out.println("Content-Type: " + contentType);
            System.out.println("Content-Length: " + contentLength);

            System.out.println("---");

            // Retrieve arbitrary header fields
            Map<String, java.util.List<String>> headers = connection.getHeaderFields();
            for (Map.Entry<String, java.util.List<String>> entry : headers.entrySet()) {
                String key = entry.getKey();
                java.util.List<String> values = entry.getValue();

                if (key != null) {
                    System.out.println(key + ":");
                    for (String value : values) {
                        System.out.println("  " + value);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

