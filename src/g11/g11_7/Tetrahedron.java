package g11.g11_7;

import java.awt.*;

public class Tetrahedron extends Triangle {
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
        pointDepth.draw(g);
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
