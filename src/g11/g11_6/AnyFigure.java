package g11.g11_6;

import g11.g11_10.Oval;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class AnyFigure extends JFrame {
    public static AnyFigure[] anyFigures;
    public static String msg;
    public static int width;
    public static int height;
    public static Point[] massivPoint;
    public  static Oval oval;
    public static int countPoint;
    public static int sizePoint = 5;
    public static int diam = 100;//отступ
    String text = "";

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawString(msg, 100, 50);
        g.drawLine(0, 50 , width, 55);

      for (AnyFigure anyFigure : anyFigures) {
          anyFigure.draw(g);
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
        msg = "Задание 5 к главе 11.";
        width = 500;
        height = 500;
        //countPoint = ask("Input count point: n=");
        int countLines = ask("Input count lines countLinew = ");
        anyFigures = new AnyFigure[countLines];
        massivPoint = new Point[countLines * 2];
        generatePoint(massivPoint, countLines*2);
        for (int i = 0; i < anyFigures.length; i++) {
            anyFigures[i] = new Line(massivPoint[i], massivPoint[i + countLines]);
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
