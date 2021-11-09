package g12.g12_1;

import java.awt.*;

public class Line {
    private float width;
    private Color color;
    private int x1, y1, x2, y2;

    public Line(float width, Color color, int x1, int y1, int x2, int y2) {
        this.width = width;
        this.color = color;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(width));//set width
        g2.setColor(color);
        g2.drawLine(x1, y1, x2, y2);
    }

    public void setWidth(float width) {
        this.width = width;
    }
}

