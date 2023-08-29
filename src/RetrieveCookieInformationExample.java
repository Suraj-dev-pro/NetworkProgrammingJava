import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.util.List;

public class RetrieveCookieInformationExample {
    public static void main(String[] args) {
        // Create a CookieManager
        CookieManager cookieManager = new CookieManager();

        // Retrieve the default CookieStore
        CookieStore cookieStore = cookieManager.getCookieStore();

        // Retrieve the cookies for a specific URI
        URI uri = URI.create("https://app.hackernoon.com/");
        List<HttpCookie> cookies = cookieStore.get(uri);

        // Display the retrieved cookies
        if (cookies.isEmpty()) {
            System.out.println("No cookies found for the specified URI.");
        } else {
            System.out.println("Retrieved Cookies:");
            for (HttpCookie cookie : cookies) {
                System.out.println("Name: " + cookie.getName());
                System.out.println("Value: " + cookie.getValue());
                System.out.println("Domain: " + cookie.getDomain());
                System.out.println("Path: " + cookie.getPath());
                System.out.println("Max Age: " + cookie.getMaxAge());
                System.out.println("Secure: " + cookie.getSecure());
                System.out.println("Http Only: " + cookie.isHttpOnly());
                System.out.println();
            }
        }
    }
}
