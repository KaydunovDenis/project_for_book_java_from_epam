package g13.example_9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RadioBtnGroupEx extends JFrame {
    private ButtonGroup btnGroup = new ButtonGroup();
    private JLabel label = null;

    private class RadioItemListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            boolean selected = (e.getStateChange() == ItemEvent.SELECTED);
            AbstractButton button = (AbstractButton) e.getItemSelectable();
            if(selected){
                label.setText("Selected Button: "+ button.getActionCommand());
            }
            System.out.println("ITEM Choice Selected: " + selected
                    + ", Selection: " + button.getActionCommand());
        }
    }

    public RadioBtnGroupEx() throws HeadlessException {
        //Базовые установки
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                System.exit(0);
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 100, 500, 100);
        setTitle("Radion");
        setVisible(true);

        Container c = this.getContentPane();
        c.setLayout(new FlowLayout());

        JRadioButton red = new JRadioButton("Red");
        red.setSelected(true);
        btnGroup.add(red);
        c.add(red);

        label = new JLabel("Selected Button: Red");

        JRadioButton green = new JRadioButton("Green");
        btnGroup.add(green);
        c.add(green);

        JRadioButton blue = new JRadioButton("Blue");
        btnGroup.add(blue);
        c.add(blue);
        ItemListener itemListener = new RadioItemListener();
        red.addItemListener(itemListener);
        green.addItemListener(itemListener);
        blue.addItemListener(itemListener);

        c.add(label);
    }

    public static void main(String[] args) {
        RadioBtnGroupEx radioBtnGroupEx = new RadioBtnGroupEx();



    }



}
