package g12.example4;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ButtonActionListener implements ActionListener {
    private Paint paint;

    public ButtonActionListener(Paint paint) {
        this.paint = paint;
    }

    public void actionPerformed(ActionEvent e) {
        Component component = (Component)e.getSource();
        String nameComponent = component.getName();
       /* if (nameComponent.equals("Color")) {
            System.out.println("Change color");
            paint.getGlassPane().getGraphics().setColor(JColorChooser.
                    showDialog(((Component) e.getSource()).getParent(), "Palette", paint.getGlassPane().getGraphics().getColor()));
        }
        if (nameComponent.equals("Width")) {
            int selectedWidth = ((JComboBox<Object>)e.getSource()).
                    getSelectedIndex() + 1;
            System.out.println(selectedWidth);
            ((Graphics2D)paint.getGraphics()).setStroke(new BasicStroke(selectedWidth));*/
            //не графику а бадущую линию
    }



}
