package g12.example4;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class PaintMouseAdapter extends MouseAdapter {
    public void mousePressed(MouseEvent event) {
       // event.getSource().setPreviousCoordinates(event.getX(), event.getY());
    }
}
