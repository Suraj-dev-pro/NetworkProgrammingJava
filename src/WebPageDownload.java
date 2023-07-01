import java.io.*;
import java.net.URL;

public class WebPageDownload {
    public  static void main(String[]args){
        String url = "https://www.facebook.com";
        String savePath = "src/web.html";
        try{
            downloadWebPage(url,savePath);
            System.out.println("Webpage downloaded successfully");
        }catch (IOException e) {
            System.out.println("An error occured while downloading the webpage: " + e.getMessage());
        }
    }
    private static void downloadWebPage(String url,String savePath) throws IOException{
        URL webpageUrl = new URL(url);
        BufferedReader reader = new BufferedReader(new InputStreamReader(webpageUrl.openStream()));
        BufferedWriter writer = new BufferedWriter(new FileWriter(savePath));

        String line;
        while((line = reader.readLine()) != null){
            writer.write(line);
            writer.newLine();
        }
        reader.close();
        writer.close();
    }
}
