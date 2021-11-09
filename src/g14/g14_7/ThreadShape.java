package g14.g14_7;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ThreadShape extends Thread {
    Graphics2D g;
    JPanel panel;
    int a = 50;
    int posY = 150;
    int posX = 150;

    public ThreadShape(JPanel panel) {
        this.panel = panel;
        g = (Graphics2D) panel.getGraphics();
    }


    @Override
    public void run() {
        paint();
    }

    public void paint() {
        g.setColor(Color.black);
        int centreX = posX + a / 2;
        int centreY = (int) (posY + a*Math.sqrt(3)/6);
        while (true) {
            a += 3;
            g.setColor(randomChangeColor());
            //
            String shape = Window.getNameShape();
            draw(shape);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            g.setColor(panel.getBackground());
            draw(shape);
            g.rotate(Math.toRadians(5), centreX++, centreY );
        }
    }

    private void draw(String shape) {
        if (shape.equals("Circle")) {
            drawOval();
        } else if (shape.equals("Triangle")) {
            drawTriangle();
        } else if (shape.equals("Square")) {
            drawSquare();
        }
    }

    private void drawSquare() {
        g.drawRect(posX, posY, a, a);

    }

    private void drawTriangle() {
        Polygon tri = new Polygon(
                new int[] {posX, posX + a/2, posX + a},
                new int[] {posY, (int) (posY + a*Math.sqrt(3)/2), posY},
                3);
        g.fill(tri);
    }

    private void drawOval() {
        g.drawOval(posX, posY, a, a);
    }

    public Color randomChangeColor() {
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        return Color.getHSBColor(r, g, b);
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }
}
