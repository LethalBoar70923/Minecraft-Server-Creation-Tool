import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

public class GUI {
    static String[] typecomboArr = new String[]{"Vanilla", "Bukkit", "Spigot", "PaperMC",};
    static String[] versioncomboArr = new String[]{"Latest", "1.16.5", "1.16.4", "1.16.3", "1.16.2", "1.16.1", "1.16", "1.15.2", "1.15.1", "1.15", "1.14.4", "1.14.3", "1.14.2", "1.14.1", "1.14", "1.13.2", "1.13.1", "1.13", "1.12.2", "1.12.1", "1.12", "1.11.2", "1.11.1", "1.11", "1.10.2", "1.10.1", "1.10", "1.9.4", "1.9.3", "1.9.2", "1.9.1", "1.9", "1.8.9", "1.8.8", "1.8.7", "1.8.6", "1.8.5", "1.8.4", "1.8.3", "1.8.2", "1.8.1", "1.8", "1.7.10", "1.7.9", "1.7.8", "1.7.7", "1.7.6", "1.7.5", "1.7.4", "1.7.3", "1.7.2", "1.6.4", "1.6.2", "1.6.1", "1.5.2", "1.5.1", "1.5", "1.4.7", "1.4.6", "1.4.5", "1.4.4", "1.4.2", "1.3.2", "1.3.1", "1.2.5", "1.2.4", "1.2.3", "1.2.2", "1.2.1"};
    static JFrame frame;

    static JPanel panel = new JPanel();

    static JButton createServer = new JButton();
    static JButton editProperties = new JButton();
    static JComboBox typecomboBox = new JComboBox();
    static JComboBox versioncomboBox = new JComboBox();
    static DefaultComboBoxModel<String> typeModel = new DefaultComboBoxModel<>(typecomboArr);
    static DefaultComboBoxModel<String> versionModel = new DefaultComboBoxModel<>(versioncomboArr);
    static JFileChooser fileChooser = new JFileChooser();
    static JLabel image = new JLabel();


    GUI() throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        frame = new JFrame("Minecraft Server Creation Tool");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panel);
        panel.setLayout(null);

        //Add all JObjects to Panel
        panel.add(createServer);
        panel.add(typecomboBox);
        panel.add(versioncomboBox);
        panel.add(fileChooser);
        panel.add(editProperties);
        panel.add(image);

        //Add text to buttons
        createServer.setText("Create Server");
        editProperties.setText("Server Settings");


        //Set bounds of all JObjects
        frame.setBounds(500, 500, 385, 275);
        createServer.setBounds(50, 125, 125, 20);
        editProperties.setBounds(200, 125, 125, 20);
        typecomboBox.setBounds(50, 165, 125, 20);
        versioncomboBox.setBounds(200, 165, 125, 20);
        fileChooser.setBounds(500, 300, 300, 50);
        image.setBounds(10, 0, 1034, 146);


        //Misc.
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        versioncomboBox.setModel(versionModel);
        typecomboBox.setModel(typeModel);
        System.out.println(versioncomboArr.length);
        image.setIcon(new ImageIcon("image.png"));


        //Set JObjects to be visible
        frame.setVisible(true);
        panel.setVisible(true);
        typecomboBox.setVisible(true);
        createServer.setVisible(true);
        versioncomboBox.setVisible(true);


        createServer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new ServerDownloader();

                try {
                    new ServerStart();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            }
        });


        editProperties.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                SettingsGUI.Start();
                SettingsGUI.settingsFrame.addWindowListener(new WindowListener() {
                    @Override
                    public void windowOpened(WindowEvent e) {

                        frame.setFocusableWindowState(false);
                        frame.setEnabled(false);

                    }

                    @Override
                    public void windowClosing(WindowEvent e) {


                    }

                    @Override
                    public void windowClosed(WindowEvent e) {
                        frame.setFocusableWindowState(true);
                        frame.setEnabled(true);
                        frame.isAlwaysOnTop();
                    }

                    @Override
                    public void windowIconified(WindowEvent e) {

                    }

                    @Override
                    public void windowDeiconified(WindowEvent e) {

                    }

                    @Override
                    public void windowActivated(WindowEvent e) {

                    }

                    @Override
                    public void windowDeactivated(WindowEvent e) {

                    }

                });
            }
        });

        typecomboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                int y = typecomboBox.getSelectedIndex();

                switch (y) {


                    case 1:

                        versioncomboBox.removeAllItems();

                        for (int i = 1; i < 33; i++) {

                            versioncomboBox.addItem(versioncomboArr[i]);
                        }

                        versioncomboBox.addItem("1.8");

                        break;
                    case 2:
                    case 3:

                        versioncomboBox.removeAllItems();
                        for (int i = 0; i < 33; i++) {

                            versioncomboBox.addItem(versioncomboArr[i]);
                        }

                        break;

                }

            }
        });


    }


}




