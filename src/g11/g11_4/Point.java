package g11.g11_4;

public class Point {
    public boolean isInside;
    int x;
    int y;
    String text = "";

    public Point(int x, int y, int i) {
        this.x = x;
        this.y = y;
    }

    public Point(int x, int y, String text) {
        this.x = x;
        this.y = y;
        this.text = text;
    }

    @Override
    public String toString() {
        return text + " x=" + x +", y=" + y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
