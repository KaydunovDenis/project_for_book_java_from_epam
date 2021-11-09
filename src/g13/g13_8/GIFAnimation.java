package g13.g13_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Создать форму с выпадающим списком так, чтобы при выборе элемен-
 * та списка на экране появлялись GIF-изображения, двигающиеся в слу-
 * чайно выбранном направлении по апплету.
 */
public class GIFAnimation extends JFrame {
    private ClassLoader ldr = this.getClass().getClassLoader();
    //img
    //private java.net.URL iconURL = ldr.getResource("src/g13/g13_8/resources/image.gif");
    public ImageIcon icon;
    public Image image;
    // scale it the smooth way
    //Image newimg1 = image.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH);
    //ImageIcon imageIcon11 = new ImageIcon(newimg1);  // transform it back

    public void paint(Graphics g) {
        for (int i = 0; ; i++) {
            g.drawImage(image, i, 0, null);
        }

    }

    public GIFAnimation(String name) throws HeadlessException {
        //Cтанндартные установки окна
        int width = 200;
        int height = 200;
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle(name);
        this.setLocation(500, 500);
        this.setSize((new Dimension(width, height)));
        this.setMinimumSize(new Dimension(width, height-100));
        this.setVisible(true);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        String country[]={"India","Aus","U.S.A","England","Newzealand"};
        JComboBox comboBox = new JComboBox(country);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Action!");
                image = (new ImageIcon("src/g13/g13_8/resources/image.gif")).getImage();
                repaint();
            }
        });
        //add
        c.add(comboBox);
    }

    public static void main(String[] args) {
        GIFAnimation window = new GIFAnimation("Анимация");
    }
}
