package g11;
import javax.swing.*;
import java.awt.*;

public class DemoLC extends JApplet {
    private int starX[] =
            { 112, 87, 6, 71, 47, 112, 176, 151, 215, 136 };

    private int starY[] =
            { 0, 76, 76, 124, 200, 152, 200, 124, 76, 76 };

    private int i;
    private Color c;

    public void init() {
        c = new Color(0, 0, 255);
        setBackground(Color.LIGHT_GRAY);
        i = 1;
    }
    public void start() {
        int j = i * 25;
        if (j < 255)
            c = new Color(j, j, 255 - j);
        else i = 1;
    }
    public void paint(Graphics g) {
        g.setColor(c);
        g.fillPolygon(starX, starY, starX.length);






        g.setColor(Color.BLACK);
        g.drawPolygon(starX, starY, starX.length);
    }
    public void stop() {
        i++;
    }
}