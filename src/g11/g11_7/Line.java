package g11.g11_7;

import java.awt.*;
import java.util.Scanner;

/**
 * y = a * x + b
 */
public class Line extends g11.g11_7.Point {
    double k;
    double b;
    int x1;
    int x2;
    int y1;
    int y2;

    public Line(g11.g11_7.Point point1, Point point2) {
        x1 = point1.x;
        y1 = point1.y;
        x2 = point2.x;
        y2 = point2.y;

    }

    public Line() {
        askDataOfLine();
    }

    /*public void draw(Graphics g, int width, int height) {
        g.drawLine(0, (int) (height - this.b), width, (int) (height - (this.k * width + this.b)));
    }*/

    @Override
    public void draw(Graphics g) {
        g.drawLine(x1, y1, x2, y2);
    }


    public void askDataOfLine(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input corner of line: k = ");
        k = sc.nextDouble();
        System.out.print("Input hieght of line: b = ");
        b = sc.nextInt();
        System.out.printf("Your number: y = %fx + %d", k, b);
    }

    public double getYofX(int x, int height) {
        k = (y1 - y2) / (x1 - x2);
        b = y1 - k * x1;
        return k * x + b;
    }

    @Override
    public String toString() {
        return "Line{" +
                "x1=" + x1 +
                ", x2=" + x2 +
                ", y1=" + y1 +
                ", y2=" + y2 +
                '}';
    }
}
