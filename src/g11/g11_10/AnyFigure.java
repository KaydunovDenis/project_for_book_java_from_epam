package g11.g11_10;

import g11.g11_10.Oval;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

/**
 * Определить классы Triangle и NAngle. Определить, какой из
 * m-введенных n-угольников имеет наибольшую площадь:
 *
 */
public class AnyFigure extends JFrame {
    public static AnyFigure[] anyFigures;
    public static String msg;
    public static int width;
    public static int height;
    public static Point massivPoint;
    public static Oval oval;
    public static int countPoint;
    public static int sizePoint = 5;
    public static int diam = 100;//отступ
    String text = "";
    public static int maxSquare = 0;
    public static int offset = 0;
    public int direct;


    @Override
    public void paint(Graphics g) {

        g.drawString(msg, 100, 50);
        g.drawLine(0, 55 , width, 55);
        //g.setColor(Color.RED);
        //g.drawOval(100, 100, 100, 100);
        //for (int i = 0; i < 1000; i++) {
          //  g.drawOval(100, 100, 100, 100);
            //oval.getGraphics().translate(10+ i, 10+ i);

        //}
    }


    public static int ask(String msg) {
        Scanner sc = new Scanner(System.in);
        System.out.print(msg);
        int n = sc.nextInt();
        return n;
    }

    public static void generatePoint(Point[] massivPoint, int countPoint) {
        for (int i = 0; i < countPoint; i++) {
            int x = (int) (Math.random() * (width - 2 * diam)) + diam;
            int y = (int)(Math.random()* (height - 2 * diam)) + diam;
            massivPoint[i] = new Point(x, y, i + "");
        }
    }

    public int generateRandomSignOffset() {
        int max = 1;
        int min = 0;
        int random_int = (int)(Math.random() * (max - min + 1) + min);
        return random_int == 0 ? 1 : -1;
    }

    public void analyzePointRelaiveLine(Graphics g, Line line, Point point) {
        if (point.y > line.getYofX(point.x, height)) {
            g.setColor(Color.red);
        } else {
            g.setColor(Color.cyan);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        msg = "Задание 7 к главе 11.";
        width = 500;
        height = 500;

        oval = new Oval(200, 300, 100, 100);



        AnyFigure anyFigure = new AnyFigure();

        //Устанавливает цвет заднего фона окна
        //anyFigure.setBackground();
        // устанавливается размер окна. Желательно!
        anyFigure.setSize(new Dimension(width, height));
        // заголовок
        anyFigure.setTitle(msg);
        anyFigure.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // установка видимости. Обязательно!
        anyFigure.setVisible(true);
        // перерисовка - вызов paint()
        anyFigure.repaint();

    }
}
