package g12.g12_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class RadioItemListener implements ItemListener {
    private  Paint paint;

    public RadioItemListener(Paint paint) {
        this.paint = paint;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        JRadioButton button = (JRadioButton) e.getSource();
        Color color = button.getBackground();
        paint.setColor(color);
        paint.drawLines();
    }
}
