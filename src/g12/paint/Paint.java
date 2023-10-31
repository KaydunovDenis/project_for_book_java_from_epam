package g12.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Paint extends JFrame {
    private int width = 300;
    private int height = 200;
    private static GUI gui;

    @Override
    public void paint(Graphics g) {
        for (Line line : gui.getLines()) {
            g.setColor(line.color);
            line.draw(g);
        }
    }

    public static void main(String[] args) {
        Paint paint = new Paint();
        gui = new GUI();
        paint.setContentPane(gui.getPanel());

        ActionListener listener = new ButtonActionListener(paint);
        gui.getChange().addActionListener(listener);
        gui.getWidthButton().addActionListener(listener);
        gui.getChange().setName("Color");
        gui.getWidthButton().setName("Width");
        gui.getGraficsPane().addMouseListener(new PaintMouseAdapter());
        gui.getGraficsPane().addMouseMotionListener(new PaintMouseMotionAdapter(gui));
        paint.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev)
            {
                System.exit(0);
            }
        });
        paint.setBounds(800, 700, paint.width, paint.height);
        paint.setTitle("Paint");
        //paint.setJMenuBar(new JMenuBar());
        paint.setVisible(true);

    }
}