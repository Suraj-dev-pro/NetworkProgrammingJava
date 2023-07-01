import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpCookie;
import java.net.URI;

public class CustomCookiePolicy implements CookiePolicy {

    @Override
    public boolean shouldAccept(URI uri, HttpCookie cookie) {
        String domain = uri.getHost();
        // Block cookies from .gov domains
        // Allow cookies from other domains
        return domain == null || !domain.toLowerCase().endsWith(".gov");
    }

    public static void main(String[] args) {
        // Create a custom CookieManager with the custom CookiePolicy
        CookieManager cookieManager = new CookieManager(null, new CustomCookiePolicy());
        java.net.CookieHandler.setDefault(cookieManager);

        // Perform HTTP requests and handle cookies
        // ...
    }
}
