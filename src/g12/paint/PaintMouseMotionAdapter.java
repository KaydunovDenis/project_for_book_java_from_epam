package g12.paint;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

class PaintMouseMotionAdapter
        extends MouseMotionAdapter {
    private GUI gui;

    public PaintMouseMotionAdapter(GUI gui) {
        this.gui = gui;
    }

    public void mouseDragged(MouseEvent ev) {
        Graphics g = this.gui.getGraficsPane().getGraphics();
        for (Line line : this.gui.getLines()) {
            g.setColor(line.color);
            line.draw(g);
        }
        g.setColor(Color.BLACK);
        g.drawLine(this.gui.getPrevX(), this.gui.getPrevY(), ev.getX(), ev.getY());
        Line line = new Line(this.gui.getColor(), this.gui.getPrevX(), this.gui.getPrevY(), ev.getX(), ev.getY());
        this.gui.getLines().add(line);
        this.gui.setPreviousCoordinates(ev.getX(), ev.getY());
    }
}
