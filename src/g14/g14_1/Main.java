package g14.g14_1;

import javax.swing.*;
import java.awt.*;

/**
 * Cоздать апплет с использованием потоков: строка движется горизон-
 * тально, отражаясь от границ апплета и меняя при этом случайным об-
 * разом свой цвет.
 */
public class Main extends JFrame {

    public Main() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(200, 200, 600, 400);
        setVisible(true);
        Container c = getContentPane();
        JPanel panel = new JPanel();
        panel.setBackground(Color.GREEN);
        //panel.setBackground(Color.GRAY);
        c.add(panel);

        ThreadString textElement = new ThreadString(panel);
        textElement.start();
    }

    public static void main(String[] args) {
        Main main = new Main();
    }
}
