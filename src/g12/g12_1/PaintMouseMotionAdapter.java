package g12.g12_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Collections;

public class PaintMouseMotionAdapter extends MouseMotionAdapter {
    private Paint paint;

    public PaintMouseMotionAdapter(Paint paint) {
        this.paint = paint;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //System.out.println("mouseDragged");
        JPanel panel = paint.getGraficPanel();
        //находится ли в окне?

        if (e.getX() > 0 && e.getX()<panel.getWidth() && e.getY() > 0 && e.getY() < panel.getHeight()) {
            Graphics g = panel.getGraphics();
            Color color = paint.getColor();
            g.setColor(color);
            Line line = new Line(paint.getWidthLine(), color, paint.getPrevX(), paint.getPrevY(), e.getX(), e.getY());
            Collections.addAll(paint.getListLines(), line);
            line.draw(g);
            paint.setPreviousCoordinates(e.getX(), e.getY());
            //System.out.println("mouseDragged, условие выполнено");

        }
    }
}
