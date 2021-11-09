package g11.g11_2;

import java.awt.*;
import java.util.Scanner;

/**
 * y = a * x + b
 */
public class Line {
    double a;
    double b;
    int x1;
    int x2;
    int y1;
    int y2;

    public Line(double a, double b) {
        this.a = a;
        this.b = b;
        System.out.println(toString());
    }

    public Line() {
        askDataOfLine();
    }

    public void draw(Graphics g, int width, int height) {
        g.drawLine(0, (int) (height - this.b), width, (int) (height - (this.a * width + this.b)));
    }

    public void askDataOfLine(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input corner of line: a = ");
        a = sc.nextDouble();
        System.out.print("Input hieght of line: b = ");
        b = sc.nextDouble();
        System.out.println(toString());
    }

    public int getYofX(int x, int height) {
        return (int)(height - a *x - b);
    }

    @Override
    public String toString() {
        return "y = " + a + "х + " + b;
    }
}
