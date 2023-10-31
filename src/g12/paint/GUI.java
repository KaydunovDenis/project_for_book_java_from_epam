package g12.paint;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GUI {
    private JPanel panel;
    private JButton change;
    private JComboBox widthButton;
    private JScrollPane scrolPane;
    private JPanel graficsPane;

    private int prevX, prevY;
    private Color color = Color.BLACK;

    private ArrayList<Line> lines = new ArrayList<>();



    public ArrayList<Line> getLines() {
        return lines;
    }



    public GUI() {
    }

    public Color getColor() {
        return color;
    }

    public int getPrevX() {
        return prevX;
    }

    public int getPrevY() {
        return prevY;
    }

    public JPanel getPanel() {
        return panel;
    }

    public JButton getChange() {
        return change;
    }

    public JComboBox getWidthButton() {
        return widthButton;
    }

    public JScrollPane getScrolPane() {
        return scrolPane;
    }

    public JPanel getGraficsPane() {
        return graficsPane;
    }

    public void setPreviousCoordinates(int x, int y) {
        prevX = x;
        prevY = y;
    }
}
