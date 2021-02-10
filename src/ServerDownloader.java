import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;


public class ServerDownloader {

    private URL url = new URL("placeholder.foo");
    ReadableByteChannel readableByteChannel = Channels.newChannel(url.openStream());


    public ServerDownloader() throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream("server.jar");
        FileChannel fileChannel = fileOutputStream.getChannel();

        fileOutputStream.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);

    }
}
