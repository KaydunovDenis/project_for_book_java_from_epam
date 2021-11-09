package g13.example_18;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JTableDemo extends JFrame {

    static ArrayList<Object[]> list = new ArrayList<Object[]>();
    JTable table;
    DataModel dataModel = new DataModel();

    public JTableDemo() {
        dataModel.addRow("Агеев", 5);
        dataModel.addRow("Смирнов", 2);
        table = new JTable(dataModel);
        getContentPane().add(new JScrollPane(table));
        JButton insertBtn = new JButton("Добавить строку");
        insertBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                dataModel.addRow("", 0);
            }
        });
        getContentPane().add(insertBtn, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        JTableDemo frame = new JTableDemo();
        frame.setBounds(100, 100, 300, 300);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}



