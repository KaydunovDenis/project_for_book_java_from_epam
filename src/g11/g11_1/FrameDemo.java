package g11.g11_1;

import javax.swing.*;
import java.awt.*;
import java.awt.Point;
import java.util.Scanner;

/**
 * TASK!
 * Создать классы Point и Line. Объявить массив из n объектов класса
 * Point. Для объекта класса Line определить, какие из объектов Point ле-
 * жат на одной стороне от прямой линии и какие на другой. Реализовать
 * ввод данных для объекта Line и случайное задание данных для объекта
 * Point.
 */

public class FrameDemo extends JFrame {
    public static String msg;
    public static int width;
    public static int height;
    private static Line line;
    public static java.awt.Point[] massivPoint;
    public static int countPoint = 5;

    public void paint(Graphics g) {
        int diam = 0;//отступ

        //g.drawString(msg, 50, 50);
        //g.drawLine(0, diam + 55, width, diam + 55);

        g.drawLine(0,height - line.b, width, (int) (height - (line.a * width + line.b)));
        g.setColor(Color.GREEN);
        for (java.awt.Point point: massivPoint
             ) {
            analyzePointPosition(g, point);
            g.drawOval(point.x, point.y, 3,3);
        }

    }

    private void analyzePointPosition(Graphics g, java.awt.Point point) {
        if (point.y > line.getYofX(point.x, height)) {
            g.setColor(Color.red);
        } else {
            g.setColor(Color.cyan);
        }
    }

    public static int ask(String msg) {
        Scanner sc = new Scanner(System.in);
        System.out.print(msg);
        int n = sc.nextInt();
        return n;
    }

    public static void generatePoint() {
        for (int i = 0; i < countPoint; i++) {
            int x = (int) (Math.random() * width);
            int y = (int)(Math.random()* height);
            massivPoint[i] = new java.awt.Point(x, y);
            System.out.println(massivPoint[i].toString());

        }
    }

    public static void main(String[] args) {
        msg = "Задание 1 к главе 11.";
        width = 250;
        height = 300;
        countPoint = ask("Input count point: n=");

        massivPoint = new Point[countPoint];
        generatePoint();
        line = new Line();



        FrameDemo fr = new FrameDemo();
        fr.setBackground(Color.GRAY);
        // устанавливается размер окна. Желательно!
        fr.setSize(new Dimension(width, height));
        // заголовок
        fr.setTitle(msg);
        // установка видимости. Обязательно!
        fr.setVisible(true);
        // перерисовка - вызов paint()
        fr.repaint();
    }





}
