import com.serverjars.api.JarDetails;
import com.serverjars.api.Response;
import com.serverjars.api.request.JarRequest;
import com.serverjars.api.request.LatestRequest;
import com.serverjars.api.response.LatestResponse;

import java.io.File;

public class ServerDownloader {


    private final String type = GUI.typecomboBox.getSelectedItem().toString();
    private final String version = GUI.versioncomboBox.getSelectedItem().toString();


    public ServerDownloader() {


        if (version.equals("Latest")) {

            LatestResponse latestResponse = new LatestRequest(type.toLowerCase()).send();
            if (latestResponse.isSuccess()) {

                JarDetails jarDetails = latestResponse.getLatestJar();
                System.out.println(jarDetails.toString());
            } else {

                System.out.println(latestResponse.getErrorTitle() + ": " + latestResponse.getErrorMessage());
            }

        } else {

            Response jarResponse = new JarRequest(type.toLowerCase(), version, new File(type + " " + version + ".jar")).send();
            if (jarResponse.isSuccess()) {

                System.out.println(jarResponse.toString());
                System.out.println("Download finished successfully!");

            } else {
                System.out.println(jarResponse.getErrorTitle() + ": " + jarResponse.getErrorMessage());
            }

        }


    }
}
