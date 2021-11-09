package g15_internet.g15_1;

import javax.swing.*;
import java.awt.*;

public class MyGraphics {

    public static void setPosition(Component c){
        PointerInfo pointerInfo = MouseInfo.getPointerInfo();
        int x = pointerInfo.getLocation().x;
        int y = pointerInfo.getLocation().y;
        c.setBounds(x, y, c.getWidth(), c.getHeight());
    }

    public static void setBasicSetting(JFrame frame) {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle(frame.getName());
        frame.setBackground(Color.GRAY);
        frame.setFont(new Font("arial", 0, 16));
    }

}
