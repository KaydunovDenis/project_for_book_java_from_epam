package g11.g11_10;



import java.awt.*;

public class Point extends AnyFigure {
    public boolean isInside = false;
    public int x;
    public int y;
    public int direct;
    public String text;


    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(int x, int y, String text) {
        this.x = x;
        this.y = y;
        this.text = text;
    }

    public Point() {
        this.x = (int) (Math.random() * (width - 2 * diam)) + diam;
        this.y = (int)(Math.random()* (height - 2 * diam)) + diam;
    }


    public void draw(Graphics g) {
        g.drawOval(x-sizePoint/2, y-sizePoint/2, sizePoint,sizePoint);
    }

    @Override
    public String toString() {
        return "Point " + text + " {x=" + x +", y=" + y + "}";
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


}
