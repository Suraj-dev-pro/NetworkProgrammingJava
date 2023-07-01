import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;


public class URLConnectionExample1 {
    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            URL url = new URL("http://www.example.com");
            URLConnection connection = url.openConnection();

            if (connection instanceof HttpURLConnection httpConnection) {

                // Get the content type
                String contentType = connection.getContentType();
                System.out.println("Content Type: " + contentType);

                // Get the content length
                int contentLength = connection.getContentLength();
                System.out.println("Content Length: " + contentLength);

                // Read the content from the server
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                System.out.println("Content:");
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }

                // Get the response code
                int responseCode = httpConnection.getResponseCode();
                System.out.println("Response Code: " + responseCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
