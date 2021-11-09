package g11.g11_7;

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
    public static Point[] massivPoint;
    public static int countPoint;
    public static int sizePoint = 5;
    public static int diam = 100;//отступ
    String text = "";
    public static int maxSquare = 0;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawString(msg, 100, 50);
        g.drawLine(0, 50 , width, 55);


        for (AnyFigure anyFigure : anyFigures) {
            if (((Triangle) anyFigure).square == maxSquare) {
                g.setColor(Color.BLACK);
            } else g.setColor(Color.RED);
            anyFigure.draw(g);
            System.out.println(((Triangle) anyFigure).square);
        }

    }

    public void draw(Graphics g) {
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

    public void analyzePointRelaiveLine(Graphics g, Line line, Point point) {
        if (point.y > line.getYofX(point.x, height)) {
            g.setColor(Color.red);
        } else {
            g.setColor(Color.cyan);
        }
    }

    public static void main(String[] args) {
        msg = "Задание 7 к главе 11.";
        width = 500;
        height = 500;



        int countTriangles = ask("Input count triangles countTriangles = ");
        anyFigures = new AnyFigure[countTriangles];
        for (int i = 0; i < anyFigures.length; i++) {
            anyFigures[i] = new Triangle();
            ((Triangle)anyFigures[i]).getSquare();
            if (maxSquare < ((Triangle) anyFigures[i]).square) {
                maxSquare = (int) ((Triangle)anyFigures[i]).square;
            }


        }

        AnyFigure anyFigure = new AnyFigure();
        anyFigure.setBackground(Color.GRAY);
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
