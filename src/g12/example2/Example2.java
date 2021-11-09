package g12.example2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Example2 extends JFrame {
    public static Rectangle rect;

    public void paint(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(rect.x, rect.y,
                rect.width, rect.height);
    }



    private static class AppletMouseListener implements MouseListener {

        /* реализация всех пяти методов интерфейса MouseListener */
        public void mouseClicked(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            if (rect.contains(x, y)) {
                System.out.println("клик в синем прямоугольнике");
            } else {
                System.out.println("клик в белом фоне");
            }
        }

        public void mouseEntered(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            if (rect.contains(x, y)) {
                System.out.println("entered в синем прямоугольнике");
            } else {
                System.out.println("entered в белом фоне");
            }
        }
        public void mouseExited(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            if (rect.contains(x, y)) {
                System.out.println("exited в синем прямоугольнике");
            } else {
                System.out.println("exited в белом фоне");
            }
        }
        public void mousePressed(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            if (rect.contains(x, y)) {
                System.out.println("pressed в синем прямоугольнике");
            } else {
                System.out.println("pressed в белом фоне");
            }
        }
        public void mouseReleased(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            if (rect.contains(x, y)) {
                System.out.println("relised в синем прямоугольнике");
            } else {
                System.out.println("relised в белом фоне");
            }
        }
    }

    public static void main(String[] args) {
        Example2 example = new Example2();
        example.rect = new Rectangle(20, 20, 100, 60);

        example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        example.setBounds(200, 100, 300, 200);
        example.setTitle("MicroPaint");
        example.setVisible(true);

        example.setBackground(Color.WHITE);
        /* регистрация блока прослушивания */
        example.addMouseListener(new AppletMouseListener());
        example.repaint();


    }
}
