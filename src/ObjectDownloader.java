import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class ObjectDownloader {
    public static void main(String[] args) {
        String objectURL = "https://www.instagram.com/";  // Replace with the URL of the object you want to download
        String savePath = "src/object.txt";  // Replace with the local file path to save the object

        try {
            downloadObject(objectURL, savePath);
            System.out.println("Object downloaded successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while downloading the object: " + e.getMessage());
        }
    }

    private static void downloadObject(String objectURL, String savePath) throws IOException {
        URL url = new URL(objectURL);
        ReadableByteChannel channel = Channels.newChannel(url.openStream());
        FileOutputStream outputStream = new FileOutputStream(savePath);

        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = channel.read(ByteBuffer.wrap(buffer))) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }

        channel.close();
        outputStream.close();
    }
}
