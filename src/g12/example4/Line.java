package g12.example4;

import java.awt.*;

public class Line  {
    private float width;
    Color color;
    int prevX;
    int prevY;
    int nextX;
    int nextY;

    public Line(Color color, int prevX, int prevY, int nextX, int nextY) {
        width = 1.0f;
        this.color = color;
        this.prevX = prevX;
        this.prevY = prevY;
        this.nextX = nextX;
        this.nextY = nextY;
    }

    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(width));  // толщина равна 10
        g2.drawLine(prevX, prevY, nextX, nextY);
    }

    public void setWidth(float width) {
        this.width = width;
    }
}
