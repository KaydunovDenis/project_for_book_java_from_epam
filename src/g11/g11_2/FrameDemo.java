package g11.g11_2;



import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

/**
 * TASK!
 *Создать классы Point и Line. Объявить массив из n объектов класса
 *Point и определить в методе, какая из точек находится дальше всех от
 *прямой линии.
 */

public class FrameDemo extends JFrame {
    public static String msg;
    public static int width;
    public static int height;
    public static Line line;
    public static Point[] massivPoint;
    public static int countPoint = 5;

    public void paint(Graphics g) {
        int diam = 0;//отступ

        //g.drawString(msg, 50, 50);
        //g.drawLine(0, diam + 55, width, diam + 55);
        g.setColor(Color.MAGENTA);
        g.drawOval(width/2, height/2, 10,10);
        Line lineX = new Line(0, height/2);
        Line lineY = new Line(100, height/2);
        g.setColor(Color.BLACK);
        lineX.draw(g, width, height);
        lineY.draw(g, width, height);

        //line.draw(g, width,height);
        g.setColor(Color.GREEN);
        /*for (Point point: massivPoint) {
            Line line2 = new Line(-1/line.a, point.x/line.a + point.y);
            line2.draw(g, width, height);
        }
        g.setColor(Color.RED);
        for (Point point: massivPoint) {
            g.drawOval(point.x, point.y, 5,5);
        }*/
    }



    private void analyzePointPosition(Graphics g, Point point) {
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
            massivPoint[i] = new Point(x, y);
            System.out.println(massivPoint[i].toString());

        }
    }

    public static void main(String[] args) {
        msg = "Задание 1 к главе 11.";
        width = 1000;
        height = 800;
        //countPoint = ask("Input count point: n=");

        //massivPoint = new Point[countPoint];
        //generatePoint();
        line = new Line(1, 10);



        FrameDemo fr = new FrameDemo();
        fr.setBackground(Color.white);
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
