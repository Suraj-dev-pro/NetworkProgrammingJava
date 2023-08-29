import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class HttpHeaderPrinter {
    public static void main(String[] args) {
        String urlString = "https://www.example.com"; // Replace with the URL of the web page

        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Print response code and message
            int responseCode = connection.getResponseCode();
            String responseMessage = connection.getResponseMessage();
            System.out.println("Response Code: " + responseCode);
            System.out.println("Response Message: " + responseMessage);

            // Print all headers
            Map<String, java.util.List<String>> headers = connection.getHeaderFields();
            for (Map.Entry<String, java.util.List<String>> entry : headers.entrySet()) {
                String key = entry.getKey();
                java.util.List<String> values = entry.getValue();
                for (String value : values) {
                    System.out.println(key + ": " + value);
                }
            }

            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
