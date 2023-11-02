package g12.g12_1_paint;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PaintMouseAdapter extends MouseAdapter {
    private Paint paint;

    public PaintMouseAdapter(Paint paint) {
        this.paint = paint;
    }

    public void mousePressed(MouseEvent e) {
        //System.out.println("PRESSmouse");
        JPanel panel = paint.getGraficPanel();
        if (e.getX() > 0 && e.getX()<panel.getWidth() && e.getY() > 0 && e.getY() < panel.getHeight()) {
            paint.setPreviousCoordinates(e.getX(), e.getY());
            //System.out.println("mousePressed, условие выполнено");
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        super.mouseExited(e);
        //System.out.println("EXIT from component");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        super.mouseEntered(e);
        paint.setPreviousCoordinates(e.getX(), e.getY());
        //System.out.println("ENTER from component");
    }
}
