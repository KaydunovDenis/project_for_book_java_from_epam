package g13.g13_9;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MovingComponentThread extends Thread {
    public JPanel panel;
    public Color colorComponent = Color.BLACK;
    public Random rand = new Random();
    private int posX, posY, preX, preY, prepreX, prepreY;

    private int ballSize = 70;
    private double alpha;
    private double SPEED = 0.5;
    boolean isAlive = true;

    /**
     * Конструктор с заданной скоростью
     * @param panel
     * @param SPEED - speed movement component
     */
    MovingComponentThread(JPanel panel, int SPEED) {
        this.panel = panel;
        this.SPEED = SPEED;
        posX = (int)((panel.getWidth() - ballSize)* Math.random());
        posY = (int)((panel.getHeight() - ballSize)* Math.random());
        alpha = Math.random() * 6.28;

    }

    MovingComponentThread(JPanel panel) {
        this.panel = panel;
        SPEED++;
        //задание рандомной начальной позиции и рандомного направления шарика
        posX = (int)((panel.getWidth() - ballSize)* Math.random());
        posY = (int)((panel.getHeight() - ballSize)* Math.random());
        alpha = Math.random() * 6.28;
        System.out.println(alpha*360/2/Math.PI);


    }

    //просчет значений для отрисовки
    public void run() {
        while(isAlive) {
            //вычисление координат
            posX += (int)(SPEED * Math.cos(alpha));
            posY += (int)(SPEED * Math.sin(alpha));
            //System.out.println(posX + " " + posY);
            //вычисление угла отражения
            if( posX >= panel.getWidth() - ballSize)
                alpha = alpha + Math.PI - 2 * alpha;
            else if( posX <= 0 )
                alpha = Math.PI - alpha;
            if( posY >= panel.getHeight() - ballSize)
                alpha = -alpha;
            else if( posY <= 0 )
                alpha = -alpha;
            paint(panel.getGraphics());
        }
        deadComponent(panel.getGraphics());


    }

    //отрисовка
    public void paint(Graphics g) {
        removeComponent(g);
        drawComponent(g);
        try {
            sleep(5);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        prepreX = preX;
        prepreY = preY;
        preX = posX;
        preY = posY;
        if (!isAlive) {
            drawComponent(g);
        }
    }

    public void changeDirrect() {
        alpha = alpha + Math.PI;
    }

    public void randomChangeColor() {
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        setColorComponent(Color.getHSBColor(r, g, b));
    }

    public void removeComponent(Graphics g) {
        g.setColor(panel.getBackground());
        g.fillArc(prepreX, prepreY, ballSize, ballSize, 0,360);
    }

    public void deadComponent(Graphics g) {
        removeComponent(g);
        g.setColor(panel.getBackground());
        g.fillArc(preX, preY, ballSize, ballSize, 0,360);
        g.setColor(panel.getBackground());
        g.fillArc(posX, posY, ballSize, ballSize, 0,360);


    }

    public void drawComponent(Graphics g) {
        g.setColor(colorComponent);
        g.fillArc(posX, posY, ballSize, ballSize, 0,360);
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public Color getColorComponent() {
        return colorComponent;
    }

    public void setColorComponent(Color colorComponent) {
        this.colorComponent = colorComponent;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getPreX() {
        return preX;
    }

    public int getPreY() {
        return preY;
    }

    public int getBallSize() {
        return ballSize;
    }

    public void setBallSize(int ballSize) {
        this.ballSize = ballSize;
    }
}
