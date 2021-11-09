package g11.g11_5;

import java.awt.*;

/**
 * Создать класс Triangle и класс Point. Объявить массив из n объектов
 * класса Point, написать функцию, определяющую, какая из точек лежит
 * внутри, а какая – снаружи треугольника.
 */
public class Triangle extends Point {
    public Point[] massivPointsTriangle;

    Point point1;
    Point point2;
    Point point3;

    Line line12;
    Line line23;
    Line line31;



    public Triangle() {

        massivPointsTriangle = new Point[3];
        generatePoint(massivPointsTriangle, 3);

        point1 = massivPointsTriangle[0];
        point2 = massivPointsTriangle[1];
        point3 = massivPointsTriangle[2];

        line12 = new Line(point1, point2);
        line23 = new Line(point2, point3);
        line31 = new Line(point3, point1);
    }

    public Triangle(int x, int y, String text) {
        super(x, y, text);
    }



    public void analyzePointRelativeTriangle(Point point) {
        int x0 = point.x;
        int y0 = point.y;
        int x1 = point1.x;
        int y1 = point1.y;
        int x2 = point2.x;
        int y2 = point2.y;
        int x3 = point3.x;
        int y3 = point3.y;

        int a = (x1 - x0) * (y2 - y1) - (x2 - x1) * (y1 - y0);
        int b = (x2 - x0) * (y3 - y2) - (x3 - x2) * (y2 - y0);
        int c = (x3 - x0) * (y1 - y3) - (x1 - x3) * (y3 - y0);

        if ((a >= 0 && b >= 0 && c >= 0) || (a <= 0 && b <= 0 && c <= 0)) {
            point.isInside = true;
        }



    }

    @Override
    public void draw(Graphics g) {
        for (Point point: massivPointsTriangle) {
            point.draw(g);
        }

        line12.draw(g);
        line23.draw(g);
        line31.draw(g);
    }

    @Override
    public String toString() {
        return "Triangle {" +
                point1.toString() + " " +
                point2.toString() + " " +
                point3.toString() + " " +
                '}';
    }




}
