import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class WebServerLogProcessor {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide the path to the log file as a command-line argument.");
            return;
        }

        String logFilePath = args[0];

        try (BufferedReader reader = new BufferedReader(new FileReader(logFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Process the log line
                processLogLine(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the log file: " + e.getMessage());
        }
    }

    private static void processLogLine(String logLine) {
        // Split the log line into fields
        String[] fields = logLine.split(" ");

        // Extract the desired information from the log line
        String ipAddress = fields[0];
        String timestamp = fields[3];
        String requestMethod = fields[5];
        String requestUrl = fields[6];
        String responseCode = fields[8];
        String responseSize = fields[9];

        // Perform further processing or analysis on the extracted information
        // For example, you can store the information in a data structure, perform calculations, etc.
        // Here, we will just print the extracted information
        System.out.println("IP Address: " + ipAddress);
        System.out.println("Timestamp: " + timestamp);
        System.out.println("Request Method: " + requestMethod);
        System.out.println("Request URL: " + requestUrl);
        System.out.println("Response Code: " + responseCode);
        System.out.println("Response Size: " + responseSize);
        System.out.println("---------------------------");
    }
}
