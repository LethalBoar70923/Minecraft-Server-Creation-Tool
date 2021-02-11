import java.io.IOException;

public class ServerStart {


    ServerStart() throws IOException {

        String filepath = GUI.typecomboBox.getSelectedItem().toString() + " " + GUI.versioncomboBox.getSelectedItem().toString() + ".jar";

        ProcessBuilder pb = new ProcessBuilder("Java", "-jar", filepath, "-nogui");
        Process p = pb.start();


    }


}
