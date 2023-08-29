import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class DownloadWebPage {
    public static void main(String[]args){
        String urlStr ="https://example.com";

        try {
            //create URL object
            URL url = new URL(urlStr);
            //open a connection to the webpage
            URLConnection connection = url.openConnection();

            //Read the properties of the webpage
            System.out.println("Content Type:" + connection.getContentType());
            System.out.println("Content Length: " + connection.getContentLength());
            System.out.println("Last Modified:" + connection.getLastModified());

            //Download and read the web page content
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
