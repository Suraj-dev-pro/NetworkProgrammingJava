// Java program to illustrate various
// URI class methods
import java.net.*;

class RelativeURISolver
{
    public static void main(String[] args) throws Exception
    {
        String uribase = "https://www.geeksforgeeks.org/";
        String urirelative = "languages/../java";
        String str = "https://www.google.co.in/?gws_rd=ssl#"+ "q=networking+in+java+geeksforgeeks"+"&spf=1496918039682";

        // Constructor to create a new URI
        // by parsing the string
        URI uriBase = new URI(uribase);

        // create() method
        URI uri = URI.create(str);

        // toString() method
        System.out.println("Base URI = " + uriBase);

        URI uriRelative = new URI(urirelative);
        System.out.println("Relative URI = " + uriRelative);

        // resolve() method
        URI uriResolved = uriBase.resolve(uriRelative);
        System.out.println("Resolved URI = " + uriResolved);

        // relativized() method
        URI uriRelativized = uriBase.relativize(uriResolved);
        System.out.println("Relativized URI = " + uriRelativized);

        // normalize() method
        System.out.println(uri.normalize());

        // getScheme() method
        System.out.println("Scheme = " + uri.getScheme());

        // getRawShemeSpecific() method
        System.out.println("Raw Scheme = " + uri.getRawSchemeSpecificPart());

        // getSchemeSpecificPart() method
        System.out.println("Scheme-specific part = " + uri.getSchemeSpecificPart());

        // getRawUserInfo() method
        System.out.println("Raw User Info = " + uri.getRawUserInfo());

        // getUserInfo() method
        System.out.println("User Info = " + uri.getUserInfo());

        // getAuthority() method
        System.out.println("Authority = " + uri.getAuthority());

        // getRawAuthority() method
        System.out.println("Raw Authority = " + uri.getRawAuthority());

    }
}
