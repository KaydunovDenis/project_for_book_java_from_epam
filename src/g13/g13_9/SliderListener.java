package g13.g13_9;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.ArrayList;

public class SliderListener implements ChangeListener {
    JLabel eastLabel;
    ArrayList<MovingComponentThread> listComponent;

    public SliderListener(JLabel eastLabel, ArrayList<MovingComponentThread> listComponent) {
        this.eastLabel = eastLabel;
        this.listComponent = listComponent;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        int sliderValue = ((JSlider) e.getSource()).getValue();
        eastLabel.setText("Size: " + sliderValue);
        for (MovingComponentThread component : listComponent) {
            component.setBallSize(sliderValue);
        }
    }
}
