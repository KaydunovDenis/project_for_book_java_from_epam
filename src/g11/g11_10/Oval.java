package g11.g11_10;

import java.awt.*;



public class Oval extends Point {
    int widthOval;
    int heightOval;

    public Oval(int x, int y, int width, int height) {
        super(x, y);
        this.widthOval = width;
        this.heightOval = height;
        this.direct = 1;
        this.offset = 1;
    }

    @Override
    public void draw(Graphics g) {
        if (x == width + diam) {
            direct = -1;
        }
        if (x == 0 + diam) {
            direct = 1;
        }
        //g.drawOval(x, y, widthOval, heightOval);
        g.translate(offset += offset + direct, 0);
    }
}
