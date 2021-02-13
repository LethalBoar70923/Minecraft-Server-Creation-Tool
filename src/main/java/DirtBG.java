import javax.swing.*;
import java.awt.*;

public class DirtBG extends JPanel {

    public static JPanel dirtPanel(Image image) {

        JPanel jpanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {

                super.paintComponent(g);
                g.drawImage(image, 0, 0, null);

            }
        };

        return jpanel;

    }
}