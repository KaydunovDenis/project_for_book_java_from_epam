package g14.g14_1;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ThreadString extends Thread {
    JPanel panel;
    boolean direct = true;//true = right. false == left
    int x = 50;
    int y = 200;
    String message = "LIZA YOU ARE BEAUTIFULLY!!";
    int message_width;
    Color colorText = Color.BLACK;
    int speed = 6;

    public ThreadString(JPanel panel) {
        this.panel = panel;
        Font font = new Font("serif", Font.BOLD, 30);
        FontMetrics fontMetrics = panel.getFontMetrics(font);
        message_width = fontMetrics.stringWidth(message);

        panel.setFont(font);

    }

    @Override
    public void run() {
        while (true) {
            paint();
            if (x >= panel.getWidth() - message_width || x <= 0) {
                colorText = randomChangeColor();
                if (x >= panel.getWidth() - message_width) {
                    direct = false;
                } else direct = true;
            }
            x += direct ? speed : -speed;
        }
    }


    private void paint() {
        Graphics g = panel.getGraphics();
        g.setColor(colorText);

        g.drawString(message, x, y);
        try {
            Thread.sleep(1000/24);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        g.setColor(panel.getBackground());
        g.drawString(message,x, y);
    }

    public Color randomChangeColor() {
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        return Color.getHSBColor(r, g, b);
    }
}
