package g14.g14_7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Изобразить в приложении правильные треугольники, вращающиеся
 в плоскости экрана вокруг своего центра. Каждому объекту соответ-
 ствует поток с заданным приоритетом.

 Условие предыдущей задачи изменяется таким образом, что центр
 вращения перемещается от одного края окна до другого с постоянной
 скоростью параллельно горизонтальной оси.
 */
public class Window extends JFrame {
    JPanel panel;
    String[] shapes = {"Circle", "Square", "Triangle"};
    static String shape = "Circle";
    boolean isAlive = true;



    public Window() throws HeadlessException {
        setBounds(100, 100, 800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        JComboBox<String> box = new JComboBox<>(shapes);
        c.add(box, BorderLayout.NORTH);
        panel = new JPanel();
        c.add(panel, BorderLayout.CENTER);

        box.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isAlive = false;
                JComboBox box = (JComboBox) e.getSource();
                shape = (String) box.getSelectedItem();

            }
        });

        generate();

    }

    public void generate() {
        int i = 0;
        while (isAlive){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ThreadShape newTri = new ThreadShape(panel);
            newTri.setPosX(160 + i++ * 10);
            newTri.start();
        }
    }

    @Override
    public void repaint() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ((Graphics2D)this.getGraphics()).rotate(Math.toRadians(10),400, 300);
        }
    }


    public static String getNameShape() {
        return shape;
    }

    public static void main(String[] args) {
        Window window = new Window();
        window.repaint();
    }
}
