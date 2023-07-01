import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebsiteReachability {
    public static void main(String[] args) {
        String websiteURL = "https://www.example.com"; // Replace with the website URL you want to check

        try {
            URL url = new URL(websiteURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("Website is reachable.");
            } else {
                System.out.println("Website is not reachable. Response code: " + responseCode);
            }
        } catch (IOException e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }
}
