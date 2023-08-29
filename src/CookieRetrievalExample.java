import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class CookieRetrievalExample {
    public static void main(String[] args) {
        try {
            // Create a URL object
            URL url = new URL("https://www.example.com");

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set up request properties
            connection.setRequestMethod("GET");

            // Send the request
            int responseCode = connection.getResponseCode();

            // Get the cookies from the response headers
            Map<String, List<String>> headerFields = connection.getHeaderFields();
            List<String> cookiesHeader = headerFields.get("Set-Cookie");

            if (cookiesHeader != null) {
                System.out.println("Cookies in the response:");
                for (String cookie : cookiesHeader) {
                    System.out.println(cookie);
                }
            } else {
                System.out.println("No cookies found in the response.");
            }

            // Close the connection
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

