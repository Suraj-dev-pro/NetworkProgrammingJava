import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class CachedExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.example.com");
            URLConnection connection = url.openConnection();

            // Enable web caching
            connection.setUseCaches(true);

            // Configure cache control
            connection.addRequestProperty("Cache-Control", "max-age=3600");

            // Read the content from the server
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            System.out.println("Content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
