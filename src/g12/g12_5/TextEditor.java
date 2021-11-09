package g12.g12_5;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TextEditor extends JFrame {
    //public static Font font = new Font("Verdana", Font.PLAIN, 20);
    public static JTextArea textArea = new JTextArea();
    private FileChooserAdapter fileChooser;

    public static void setMenu(JFrame frame) {
        JMenuBar menuBar = new JMenuBar();

        //1
        JMenu fileMenu = new JMenu("File");

        JMenu newMenu = new JMenu("New");
        JMenu saveMenu = new JMenu("Save");
        saveMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textArea.getText();
                System.out.println(text);
            }
        });
        JMenu openItem = new JMenu("Open");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        JMenuItem txtFileItem = new JMenuItem("Text file");
        txtFileItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });
        JMenuItem imgFileItem = new JMenuItem("Image file");
        JMenuItem folderItem = new JMenuItem("Folder");


        newMenu.add(txtFileItem);
        newMenu.add(imgFileItem);
        newMenu.add(folderItem);


        fileMenu.add(newMenu);
        fileMenu.add(saveMenu);
        fileMenu.addSeparator();
        fileMenu.add(openItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        //2
        JMenuItem infoMenu = new JMenuItem("Info");
        infoMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Разработано компанией Warden");
            }
        });

        //Интеграция
        menuBar.add(fileMenu);
        menuBar.add(infoMenu);
        frame.setJMenuBar(menuBar);


        //Базовые установки
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                System.exit(0);
            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(400, 400, 300, 200);
        frame.setTitle("TextEditor");
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void createGUI() {
        JFrame frame = new JFrame();
        setMenu(frame);
        JScrollPane sp = new JScrollPane(textArea);
        frame.add(sp);
        textArea.setBorder(new TitledBorder(new EtchedBorder(), "FileName"));
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                createGUI();
            }
        });
    }


}
