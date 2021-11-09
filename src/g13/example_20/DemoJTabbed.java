package g13.example_20;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DemoJTabbed extends JFrame {
    JTabbedPane tabs;
    JPanel pan1, pan2;
    public DemoJTabbed() {
        Container c = getContentPane();
        tabs = new JTabbedPane();
        pan1 = new JPanel();
        Button button = new Button("Button");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabs.setSelectedIndex(1);
            }
        });
        pan1.add(button);
        tabs.addTab("One", pan1); //добавление первой закладки
        pan2 = new JPanel();
        pan2.add(new JCheckBox("CheckBox"));
        tabs.addTab("Two", pan2);//добавление второй закладки
        c.add(tabs);
    }

    public static void main(String[] args) {
        DemoJTabbed dt = new DemoJTabbed();
        dt.setSize(250, 150);
        dt.setLocation(200, 200);
        dt.setVisible(true);
    }
}