import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomCookieStore implements CookieStore {

    private final Map<URI, List<HttpCookie>> cookieStore;

    public CustomCookieStore() {
        cookieStore = new HashMap<>();
    }

    @Override
    public void add(URI uri, HttpCookie cookie) {
        List<HttpCookie> cookies = cookieStore.getOrDefault(uri, new ArrayList<>());
        cookies.add(cookie);
        cookieStore.put(uri, cookies);
    }

    @Override
    public List<HttpCookie> get(URI uri) {
        return cookieStore.getOrDefault(uri, new ArrayList<>());
    }

    @Override
    public List<HttpCookie> getCookies() {
        List<HttpCookie> allCookies = new ArrayList<>();
        for (List<HttpCookie> cookies : cookieStore.values()) {
            allCookies.addAll(cookies);
        }
        return allCookies;
    }

    @Override
    public List<URI> getURIs() {
        return new ArrayList<>(cookieStore.keySet());
    }

    @Override
    public boolean remove(URI uri, HttpCookie cookie) {
        List<HttpCookie> cookies = cookieStore.get(uri);
        if (cookies != null) {
            return cookies.remove(cookie);
        }
        return false;
    }

    @Override
    public boolean removeAll() {
        cookieStore.clear();
        return true;
    }

    public static void main(String[] args) {
        // Create a custom CookieStore instance
        CookieStore cookieStore = new CustomCookieStore();

        // Add cookies
        URI uri = URI.create("https://example.com");
        HttpCookie cookie1 = new HttpCookie("name", "Suraj");
        HttpCookie cookie2 = new HttpCookie("age", "25");
        cookieStore.add(uri, cookie1);
        cookieStore.add(uri, cookie2);

        // Read cookies for a specific URI
        List<HttpCookie> cookies = cookieStore.get(uri);
        for (HttpCookie cookie : cookies) {
            System.out.println("Cookie: " + cookie);
        }

        // Delete a specific cookie
        boolean removed = cookieStore.remove(uri, cookie1);
        if (removed) {
            System.out.println("Cookie removed successfully");
        } else {
            System.out.println("Cookie removal failed");
        }

        // Delete all cookies
        cookieStore.removeAll();
        System.out.println("All cookies removed");
    }
}
