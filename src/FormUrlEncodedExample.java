import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class FormUrlEncodedExample {
    public static void main(String[] args) {
        String requestUrl = "http://localhost:8080/submit"; // Replace with the URL of the server-side program

        try {
            // Create the form data
            String formData = "name=" + URLEncoder.encode("John Doe", StandardCharsets.UTF_8) +
                    "&email=" + URLEncoder.encode("john@example.com", StandardCharsets.UTF_8);

            // Create a URL object with the request URL
            URL url = new URL(requestUrl);

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            // Set the Content-Type header to indicate form data
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            // Write the form data to the request body
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(formData.getBytes(StandardCharsets.UTF_8));
            outputStream.close();

            // Get the response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Read the response from the server
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Print the response
            System.out.println("Response: " + response);

            // Disconnect from the server
            connection.disconnect();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
