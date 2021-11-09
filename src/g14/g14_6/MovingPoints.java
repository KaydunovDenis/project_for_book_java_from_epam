package g14.g14_6;

import javax.swing.*;
import java.awt.*;

/**
 * Изобразить точку, пересекающую с постоянной скоростью окно слева
 направо (справа налево) параллельно горизонтальной оси. Как только
 точка доходит до границы окна, в этот момент от левого (правого) края
 с вертикальной координатной y, выбранной с помощью датчика слу-
 чайных чисел, начинает свое движение другая точка и т.д. Цвет точки
 также можно выбирать с помощью датчика случайных чисел. Для каж-
 дой точки создается собственный поток.
 */
public class MovingPoints extends JFrame {


    public MovingPoints() throws HeadlessException {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(200, 200, 600, 400);
        setVisible(true);
        Container c = getContentPane();
        JPanel panel = new JPanel();
        panel.setBackground(Color.GREEN);
        c.add(panel);

        ThreadPoint point = new ThreadPoint(panel);
        point.start();
    }



    public static void main(String[] args) {
        MovingPoints window = new MovingPoints();


    }
}
