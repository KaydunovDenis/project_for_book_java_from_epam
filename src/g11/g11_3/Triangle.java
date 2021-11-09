package g11.g11_3;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

/**
 * Создать класс Triangle и класс Point. Объявить массив из n объектов
 * класса Point, написать функцию, определяющую, какая из точек лежит
 * внутри, а какая – снаружи треугольника.
 */
public class Triangle extends JFrame {
    public static String msg;
    public static int width;
    public static int height;
    public static g11.g11_3.Point[] massivPoint;
    public static int countPoint = 5;
    public static int sizePoint = 5;
    public g11.g11_3.Point[] massivPointsTriangle;
    public static int diam = 100;//отступ


    g11.g11_3.Point point1;
    g11.g11_3.Point point2;
    g11.g11_3.Point point3;

    Line line12;
    Line line23;
    Line line31;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawString(msg, 50, 50);
        g.drawLine(0, diam , width, diam);



        for (g11.g11_3.Point point: massivPoint) {

            this.analyzePointRelativeTriangle(point);
            if (point.isInside) {
                g.setColor(Color.BLUE);
            } else {
                g.setColor(Color.ORANGE);
            }
            g.drawOval(point.getX(), point.getY(), sizePoint,sizePoint);
            g.drawString(point.text, point.getX(), point.getY());
        }

        g.setColor(Color.GREEN);
        for (g11.g11_3.Point point: massivPointsTriangle) {
            g.drawOval(point.getX()-sizePoint/2, point.getY()-sizePoint/2, sizePoint, sizePoint);
        }

        line12.drawByPoints(g, width, height);
        line23.drawByPoints(g, width, height);
        line31.drawByPoints(g, width, height);
    }

    public Triangle() {
        massivPointsTriangle = new g11.g11_3.Point[3];
        generatePoint(massivPointsTriangle, 3);

        point1 = massivPointsTriangle[0];
        point2 = massivPointsTriangle[1];
        point3 = massivPointsTriangle[2];

        line12 = new Line(point1, point2);
        line23 = new Line(point2, point3);
        line31 = new Line(point3, point1);
    }

    public void analyzePointRelativeTriangle(g11.g11_3.Point point) {
        int x0 = point.x;
        int y0 = point.y;
        int x1 = point1.x;
        int y1 = point1.y;
        int x2 = point2.x;
        int y2 = point2.y;
        int x3 = point3.x;
        int y3 = point3.y;

        int a = (x1 - x0) * (y2 - y1) - (x2 - x1) * (y1 - y0);
        int b = (x2 - x0) * (y3 - y2) - (x3 - x2) * (y2 - y0);
        int c = (x3 - x0) * (y1 - y3) - (x1 - x3) * (y3 - y0);

        if ((a >= 0 && b >= 0 && c >= 0) || (a <= 0 && b <= 0 && c <= 0)) {
            point.isInside = true;
        }

    }

    public static int ask(String msg) {
        Scanner sc = new Scanner(System.in);
        System.out.print(msg);
        int n = sc.nextInt();
        return n;
    }

    public static void generatePoint(g11.g11_3.Point[] massivPoint, int countPoint) {
        for (int i = 0; i < countPoint; i++) {
            int x = (int) (Math.random() * (width - 2 * diam)) + diam;
            int y = (int)(Math.random()* (height - 2 * diam)) + diam;
            massivPoint[i] = new g11.g11_3.Point(x, y, i + "");
            System.out.println(massivPoint[i].toString());
        }
    }

    public void analyzePointRelaiveLine(Graphics g, Line line, g11.g11_3.Point point) {
        if (point.y > line.getYofX(point.x, height)) {
            g.setColor(Color.red);
        } else {
            g.setColor(Color.cyan);
        }
    }

    public static void main(String[] args) {
        msg = "Задание 3 к главе 11.";
        width = 500;
        height = 500;
        //countPoint = ask("Input count point: n=");
        countPoint = 30;
        massivPoint = new Point[countPoint];
        generatePoint(massivPoint, countPoint);


        Triangle triangle = new Triangle();
        triangle.setBackground(Color.GRAY);
        // устанавливается размер окна. Желательно!
        triangle.setSize(new Dimension(width, height));
        // заголовок
        triangle.setTitle(msg);
        triangle.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // установка видимости. Обязательно!
        triangle.setVisible(true);
        // перерисовка - вызов paint()
        triangle.repaint();
    }
}
