package g12.example1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKey extends JApplet {
    private String msg = " ";
    private  int x = 0, y = 20;

    @Override
    public void paint(Graphics g) {
        g.drawString(msg, x, y);
    }

    @Override
    public void init() {
        addKeyListener(new AppletKeyListener());
        requestFocus();
    }

    private class AppletKeyListener implements KeyListener{


        @Override
        public void keyTyped(KeyEvent e) {
            msg += e.getKeyChar();
            repaint();
        }

        @Override
        public void keyPressed(KeyEvent e) {
            showStatus("Key Down");
        }

        @Override
        public void keyReleased(KeyEvent e) {
            showStatus("Key Up");
        }
    }

}
