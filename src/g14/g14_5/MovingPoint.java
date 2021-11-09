package g14.g14_5;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;


/**
 * Создать апплет с точкой, движущейся по окружности с постоянной
 * угловой скоростью. Сворачивание браузера должно приводить к из-
 * менению угловой скорости движения точки для следующего запуска
 * потока.
 */
public class MovingPoint extends JFrame implements Runnable {
    final public int WIDTH = 400, HEIGHT = 400;
    static double radius, circleX, circleY;
    static double w = 0.002; //угловая скорость
    static Container c;
    static ThreadPoint point;


    public MovingPoint() throws HeadlessException {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(200, 200, WIDTH, HEIGHT);
        setVisible(true);
        c = getContentPane();
        c.setBackground(Color.LIGHT_GRAY);

        c.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(e.getX() + " " + e.getY());
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        this.addWindowStateListener(new WindowStateListener() {
            @Override
            public void windowStateChanged(WindowEvent e) {
                if (e.getNewState() == JFrame.ICONIFIED) {
                    w = 0.001;
                }
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        radius = this.getRadius();
        circleX = c.getWidth() / 2 - radius + 8; //+8
        circleY = c.getHeight() / 2 - radius + 29;//+39

        g.setColor(c.getBackground());
        g.fillOval((int)point.getPreX() - 5, (int)point.getPreY() - 5, 10, 10);

        g.setColor(Color.BLACK);
        g.drawOval((int)circleX, (int)circleY, (int)radius*2, (int) (radius*2));

        g.setColor(Color.BLUE);
        g.fillOval((int)point.getX() - 5, (int)point.getY() - 5, 10, 10);

    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            repaint();
            try {
                Thread.sleep(1000/24);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread window = new Thread(new MovingPoint(), "MainThread");
        point = new ThreadPoint();
        window.start();
        point.start();

    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public double getRadius() {
        return radius = c.getWidth() > c.getHeight() ? c.getHeight()/4 : c.getWidth()/4;
    }

    public static double getW() {
        return w;
    }


}
