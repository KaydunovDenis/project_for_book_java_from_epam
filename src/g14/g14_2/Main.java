package g14.g14_2;

import javax.swing.*;
import java.awt.*;

/**
 2. Cоздать апплет с использованием потоков: строка движется по диаго-
 нали. При достижении границ апплета все символы строки случайным
 образом меняют регистр.
 */
public class Main extends JFrame {

    public Main() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(200, 200, 600, 400);
        setVisible(true);
        Container c = getContentPane();
        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);
        c.add(panel);

        ThreadString textElement = new ThreadString(panel);
        textElement.start();
    }

    public static void main(String[] args) {
        Main main = new Main();
    }
}
