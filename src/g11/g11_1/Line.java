package g11.g11_1;

import java.util.Scanner;

/**
 * y = a * x + b
 */
public class Line {
    double a;
    int b;
    int x1;
    int x2;
    int y1;
    int y2;

    public Line() {
        askDataOfLine();
    }

    public void askDataOfLine(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input corner of line: a = ");
        a = sc.nextDouble();
        System.out.print("Input hieght of line: b = ");
        b = sc.nextInt();
        System.out.printf("Your number: y = %fx + %d", a, b);
    }

    public int getYofX(int x, int height) {
        return (int)(height - a *x - b);
    }


}
