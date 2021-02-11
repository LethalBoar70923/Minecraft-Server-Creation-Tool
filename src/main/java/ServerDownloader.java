import com.serverjars.api.Response;
import com.serverjars.api.request.JarRequest;
import java.io.File;
import java.io.IOException;

public class ServerDownloader {


    private final String type = GUI.typecomboBox.getSelectedItem().toString();
    private final String version = GUI.versioncomboBox.getSelectedItem().toString();


    public ServerDownloader() throws IOException {


        Response jarResponse = new JarRequest(type.toLowerCase(), version, new File(type + " " + version + ".jar")).send();
        if (jarResponse.isSuccess()) {

            System.out.println("Download finished successfully!");

        } else {
            System.out.println(jarResponse.getErrorTitle() + ": " + jarResponse.getErrorMessage());
        }

    }
}
