
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BufferChannelExample {
    public static void main(String[] args) {
        try {
            // Create a RandomAccessFile object in read/write mode
            RandomAccessFile file = new RandomAccessFile("text.txt", "rw");

            // Get the FileChannel from the RandomAccessFile
            FileChannel channel = file.getChannel();

            // Create a ByteBuffer with a capacity of 48 bytes
            ByteBuffer buffer = ByteBuffer.allocate(48);

            // Read data from the channel into the buffer
            int bytesRead = channel.read(buffer);
            while (bytesRead != -1) {
                System.out.println("Read " + bytesRead + " bytes");

                // Flip the buffer to prepare for reading
                buffer.flip();

                // Read bytes from the buffer
                while (buffer.hasRemaining()) {
                    System.out.print((char) buffer.get());
                }

                // Clear the buffer for the next read
                buffer.clear();

                // Read more data from the channel into the buffer
                bytesRead = channel.read(buffer);
            }

            // Write data to the channel from a buffer
            String data = "Hello, World!";
            buffer.clear();
            buffer.put(data.getBytes());
            buffer.flip();
            channel.write(buffer);

            // Close the channel and file
            channel.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
