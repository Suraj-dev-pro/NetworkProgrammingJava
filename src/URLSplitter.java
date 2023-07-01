import java.net.MalformedURLException;
import java.net.URL;

public class URLSplitter {
    public static void main(String[]args){
        String urlString ="https://www.example.com:88080/path/to/resource?param1=value&param2=value2#fragment";
        try{
            URL url = new URL(urlString);
            String protocol = url.getProtocol();
            String host = url.getHost();
            int port = url.getPort();
            String path = url.getPath();
            String query = url.getQuery();
            String fragment = url.getRef();

            System.out.println("Protocol: "+protocol);
            System.out.println("Host: "+host);
            System.out.println("Port: "+port);
            System.out .println("Path: "+path);
            System.out.println("Query: "+query);
            System.out.println("Fragment: "+fragment);
        }
        catch (MalformedURLException e){
            System.out.println("Invalid URL:"+e.getMessage());
        }
    }
}
