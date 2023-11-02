package g12.g12_1_paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ButtonActionListener implements ActionListener {
    private Paint paint;

    public ButtonActionListener(Paint paint) {
        this.paint = paint;
    }

    /**
     * Метод определяет что было нажата и применяет соответствующие действия.
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        String nameBox = e.getActionCommand();
        System.out.println("Select " + nameBox);
        switch (nameBox) {
            case "Clear":
                paint.setListLines(new ArrayList<>());
                System.out.println("Очищено");
                paint.repaint();
                break;
            case "ColorChooser":
                Component component = ((Component) e.getSource()).getParent();
                Color color = JColorChooser.showDialog(component, "ColorChooser", paint.getColor());
                paint.setColor(color);
                /*if (paint.isColors(color)) {
                    //Если выбранный цвет соответствует цвету быстрого доступа => установить выделение
                    // соответствующего цвета
                    //paint
                } else {
                    //Если цвета не на панели быстрог доступа то снимаем выделение
                    //paint.getBtnGroupColor().clearSelection();
                }
                System.out.println("ColorChjoser " + color);*/

                break;
            case "comboBoxChanged":
                JComboBox box = (JComboBox) e.getSource();
                String item = (String) box.getSelectedItem();
                int widthLine = Integer.parseInt(item);
                paint.setWidthLine(widthLine);
                System.out.println("Wifh line change: " + widthLine);

                break;
        }
        paint.repaint();
    }

}
