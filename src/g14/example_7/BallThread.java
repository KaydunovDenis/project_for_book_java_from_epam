package g14.example_7;

import javax.swing.*;
import java.awt.*;

class BallThread extends Thread {
    JPanel panel;
    private int posX, posY;
    private final int BALL_SIZE = 10;
    private double alpha;
    private int SPEED = 1;

    BallThread(JPanel p) {
        this.panel = p;
        //задание рандомной начальной позиции и рандомного направления шарика
        posX = (int)((panel.getWidth() - BALL_SIZE)* Math.random());
        posY = (int)((panel.getHeight() - BALL_SIZE)* Math.random());
        alpha = Math.random() * 10;
    }

    //просчет значений для отрисовки
    public void run() {
        while(true) {
            //вычисление координат
            posX += (int)(SPEED * Math.cos(alpha));
            posY += (int)(SPEED * Math.sin(alpha));
            //вычисление угла отражения
            if( posX >= panel.getWidth() - BALL_SIZE )
                alpha = alpha + Math.PI - 2 * alpha;
            else if( posX <= 0 )
                alpha = Math.PI - alpha;
            if( posY >= panel.getHeight() - BALL_SIZE )
                alpha = -alpha;
            else if( posY <= 0 )
                alpha = -alpha;
            paint(panel.getGraphics());
        }
    }

    //отрисовка
    public void paint(Graphics g) {
        //прорисовка шарика
        g.setColor(Color.BLACK);
        g.fillArc(posX, posY, BALL_SIZE, BALL_SIZE, 0, 360);
        g.setColor(Color.RED);
        g.drawArc(posX + 2, posY + 2, BALL_SIZE,
                BALL_SIZE, 120, 30);
        try {
            sleep(100);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        //удаление шарика
        g.setColor(panel.getBackground());
        g.fillArc(posX, posY, BALL_SIZE, BALL_SIZE, 0, 360);
    }
}
