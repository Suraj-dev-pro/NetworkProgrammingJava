import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPFileServer {
    private static final int PORT = 12345;
    private static final String FILE_PATH = "object.txt";

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                sendFile(clientSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendFile(Socket clientSocket) throws IOException {
        try (
                FileInputStream fileInputStream = new FileInputStream(FILE_PATH);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                OutputStream outputStream = clientSocket.getOutputStream();
        ) {
            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = bufferedInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            outputStream.flush();
            System.out.println("File sent to client.");
        }
    }
}
