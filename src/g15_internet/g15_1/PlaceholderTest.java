package g15_internet.g15_1;

import javax.swing.*;
import java.awt.*;

public class PlaceholderTest {

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Placeholder test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField field = new PlaceholderTextField("Пиши сюда...");
        frame.add(field);
        field.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        JButton button = new JButton("Применить");
        button.addActionListener(e -> frame.setTitle(field.getText()));
        frame.add(button, BorderLayout.SOUTH);

        frame.setSize(300, 100);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}


