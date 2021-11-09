package g15_internet.g15_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * @author Kaydunov Denis
 * 09.11.2021
 */
public
class PlaceholderTextField extends JTextField implements FocusListener {
    private String placeholder;
    private Font placeholderFont;
    private Color placeholderColor;

    public PlaceholderTextField(String placeholder) {
        this(placeholder, Color.GRAY);
    }

    public PlaceholderTextField(String placeholder, Color placeholderColor) {
        super();
        this.placeholder = placeholder;
        this.placeholderColor = placeholderColor;
        addFocusListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        if (getText().isEmpty() && !hasFocus()) {
            Insets in = getInsets();
            if (placeholderFont == null) {
                placeholderFont = getFont().deriveFont(Font.ITALIC);
            }
            FontMetrics m = g.getFontMetrics(placeholderFont);
            int textHeightTillBaseline = m.getHeight() - m.getDescent();
            int clientSpace = getHeight() - in.top - in.bottom;
            int margin = (clientSpace - textHeightTillBaseline) / 2;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.setFont(placeholderFont);
            g.setColor(placeholderColor);
            g.drawString(placeholder, in.left, margin + textHeightTillBaseline);
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        repaint();
    }

    @Override
    public void focusLost(FocusEvent e) {
        repaint();
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    public Color getPlaceholderColor() {
        return placeholderColor;
    }

    public void setPlaceholderColor(Color placeholderColor) {
        this.placeholderColor = placeholderColor;
    }

    @Override
    public void setFont(Font f) {
        placeholderFont = null;
        super.setFont(f);
    }
}
