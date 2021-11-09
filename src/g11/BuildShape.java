package g11;
import g11.g11_10.Triangle;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.JApplet;

public class BuildShape extends JApplet {
    public void init() {
        setSize(200, 205);
    }
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        setBackground(Color.LIGHT_GRAY);

        g2.rotate(Math.PI / 6);
        drawChessBoard(g);
//поворот
        g2.rotate(-Math.PI / 6);
        g.setXORMode(new Color(200, 255, 250));
        Shape e = new Ellipse2D.Float(70, 75, 70, 50);
//рисование эллипса
        g2.fill(e);
    }
    //рисование шахматной доски
    public void drawChessBoard(Graphics g) {
        int size = 16;
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                if ((x + y) % 2 == 0)
                    g.setColor(Color.BLUE);
                else
                    g.setColor(Color.WHITE);
                g.fillRect(75 + x * size, y * size - 25, size, size);
            }
            g.setColor(Color.BLACK);

            g.drawString(new Character(
                    (char) ('8' - y)).toString(), 66, y * size - 13);
            g.drawString(new Character(
                            (char) (y + 'a')).toString(),
                    79 + y * size, 8 * size - 14);
        }
    }

    public static class Tetrahedron extends Triangle {
        private Triangle triangle;
        private Point pointDepth;

        public Tetrahedron(Triangle triangle, Point pointDepth) {
            this.triangle = triangle;
            this.pointDepth = pointDepth;
        }


        @Override
        public void draw(Graphics g) {
            g.setColor(Color.RED);
            super.draw(g);
            triangle.draw(g);
            System.out.println(triangle.toString());
            System.out.println(pointDepth.toString());
            for (int i = 0; i < 3; i++) {
                g.drawLine(pointDepth.x, pointDepth.y, massivPointsTriangle[i].x, massivPointsTriangle[i].y);
            }


        }

        @Override


        public String toString() {
            return "Tetrahedron {" +
                    triangle.toString() +
                    ", pointDepth=" + pointDepth.toString() +
                    '}';
        }


    }
}