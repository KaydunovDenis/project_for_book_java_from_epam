package g11.g11_5;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class AnyFigure extends JFrame {
    public static AnyFigure[] anyFigures = new AnyFigure[3];
    public static String msg;
    public static int width;
    public static int height;
    public static g11.g11_5.Point[] massivPoint;
    public static int countPoint = 5;
    public static int sizePoint = 5;
    public static int diam = 100;//отступ
    String text = "";

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawString(msg, 100, 50);
        g.drawLine(0, 50 , width, 55);
        anyFigures[0].draw(g);
        anyFigures[1].draw(g);
        anyFigures[2].draw(g);

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
            massivPoint[i] = new g11.g11_5.Point(x, y, i + "");
        }
    }

    public void analyzePointRelaiveLine(Graphics g, Line line, g11.g11_5.Point point) {
        if (point.y > line.getYofX(point.x, height)) {
            g.setColor(Color.red);
        } else {
            g.setColor(Color.cyan);
        }
    }

    public static void main(String[] args) {
        msg = "Задание 5 к главе 11.";
        width = 500;
        height = 500;
        //countPoint = ask("Input count point: n=");

        anyFigures[0] = new g11.g11_5.Point();
        //anyFigures[1] = new Triangle();
        //anyFigures[2] = new Tetrahedron(new Triangle(), new Point());

        //Output the coordinates
        for (AnyFigure anyFigure : anyFigures) {
            System.out.println(anyFigure.toString());
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
