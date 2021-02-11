import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SettingsGUI {


    static JButton close = new JButton();
    static JFrame settingsFrame;
    static JPanel settingsPanel = new JPanel();

    static void Start() {

        settingsFrame = new JFrame("Minecraft Server Creation Tool");
        settingsFrame.setContentPane(settingsPanel);
        settingsFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        settingsPanel.setLayout(null);


        //Misc.
        settingsFrame.setFocusableWindowState(true);
        settingsFrame.isAlwaysOnTop();

        //Add Text
        close.setText("close");

        //Add JObjects to panel
        settingsPanel.add(close);

        //Set bounds of all JObjects
        settingsFrame.setBounds(300, 300, 400, 400);
        close.setBounds(280, 335, 100, 20);


        //Make all JObjects visible
        settingsPanel.setVisible(true);
        settingsFrame.setVisible(true);
        close.setVisible(true);


        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                settingsFrame.dispose();

            }
        });


    }


}
