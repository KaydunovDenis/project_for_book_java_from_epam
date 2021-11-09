package g14.g14_6;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 *
 */
public class ThreadPoint extends Thread {
    private static final int BALL_SIZE = 30;
    private int x, y;
    private JPanel panel;
    Random rand = new Random();
    private Color color;
    private int speed;

    public ThreadPoint(JPanel panel) {
        this.panel = panel;
        x = 0;
        int width = panel.getHeight();
        y = (int)(Math.random()*width);
        color = randomChangeColor();
        speed = (int) (Math.random()*2  )+1;
    }

    @Override
    public void run() {
        while (true) {
            paint();
            x = x + speed;
            if (x == panel.getWidth()) {
                x = 0;
                ThreadPoint newPoint = new ThreadPoint(panel);
                newPoint.start();
            }
        }
    }

    public void paint() {
        Graphics g = panel.getGraphics();
        g.setColor(color);
        g.fillOval(x, y, BALL_SIZE, BALL_SIZE);
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        g.setColor(panel.getBackground());
        g.fillOval(x, y, BALL_SIZE, BALL_SIZE);
    }

    public Color randomChangeColor() {
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        return Color.getHSBColor(r, g, b);
    }


}
