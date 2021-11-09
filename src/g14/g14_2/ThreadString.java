package g14.g14_2;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ThreadString extends Thread {
    JPanel panel;
    boolean dirrectX = true;
    boolean dirrectY = true;
    int x = 50;
    int y = 200;
    String message = "YOU CHAMPION!";
    int message_width;
    Font font;
    int fontSize = 30;
    Color colorText = Color.BLACK;
    int speed = 6;
    Random rand = new Random();

    public ThreadString(JPanel panel) {
        this.panel = panel;
        Font font = new Font("serif", Font.BOLD, fontSize);
        FontMetrics fontMetrics = panel.getFontMetrics(font);
        message_width = fontMetrics.stringWidth(message);

        panel.setFont(font);

    }

    @Override
    public void run() {
        while (true) {
            paint();
            if (x >= panel.getWidth() - message_width || x <= 0 || y >= panel.getHeight() || y <= fontSize) {
                colorText = randomChangeColor();
                //fontSize = (int) rand.nextInt(100);
                //panel.setFont(new Font("serif", Font.ITALIC, fontSize));
                if (x >= panel.getWidth() - message_width || x <= 0) {
                    dirrectX = !dirrectX;
                }
                if (y >= panel.getHeight() || y <= fontSize) {
                    dirrectY = !dirrectY;
                }
            }
            x += dirrectX ? speed : -speed;
            y += dirrectY ? speed : -speed+4;
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
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        return Color.getHSBColor(r, g, b);
    }
}
