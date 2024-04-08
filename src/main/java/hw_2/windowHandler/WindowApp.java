package hw_2.windowHandler;

import hw_2.controllers.FileHandler;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class WindowApp extends JFrame {
    private JButton openFileButton;
    private JButton processFileButton;
    private JLabel openFileLabel;
    private JLabel destinationFileLabel;
    private JLabel doneLabel;

    private final JFileChooser fileChooser = new JFileChooser();
    private final FileHandler fileHandler = new FileHandler();

    private boolean isFileOpen = false;


    public WindowApp(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setTitle("Character Counter");

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        openFileLabel = new JLabel("No source file selected");
        contentPanel.add(openFileLabel);

        openFileButton = new JButton("Source file");
        openFileButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, openFileButton.getPreferredSize().height));
        contentPanel.add(openFileButton);

        destinationFileLabel = new JLabel("No destination file selected");
        contentPanel.add(destinationFileLabel);

        processFileButton = new JButton("Destination file");
        processFileButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, processFileButton.getPreferredSize().height));
        processFileButton.setEnabled(isFileOpen);
        contentPanel.add(processFileButton);

        doneLabel = new JLabel("Done");
        doneLabel.setVisible(false);
        contentPanel.add(doneLabel);

        JPanel mainPanel = new JPanel(new GridLayout(0, 1));
        mainPanel.add(contentPanel);

        setContentPane(mainPanel);

        openFileButton.addActionListener(e -> {
            doneLabel.setVisible(false);
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir") + "/src/main/java/hw_2/files"));

            int result = fileChooser.showOpenDialog(WindowApp.this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();

                if (!file.exists()) {
                    System.out.println("incorrect path");
                    return;
                }

                fileHandler.setFile(file);
                openFileLabel.setText(fileHandler.getPath());
                processFileButton.setEnabled(true);
            }
        });

        processFileButton.addActionListener(e -> {
            fileHandler.countSymbols();

            fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir") + "/src/main/java/hw_2/files"));
            int result = fileChooser.showOpenDialog(WindowApp.this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                fileHandler.setFile(file);
                destinationFileLabel.setText(fileHandler.getPath());
                fileHandler.writeSymbols(file);
                doneLabel.setVisible(true);
            }
        });
    }
}