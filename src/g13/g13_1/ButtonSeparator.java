package g13.g13_1;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicBorders;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Создать апплет. Поместить на него текстовое поле JTextField, кнопку
 * JButton и метку JLabel. В метке отображать все введенные симво-
 * лы, разделяя их пробелами.
 */
public class ButtonSeparator extends JFrame {
    public static int width = 200;
    public static int height = 400;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //pack();
    }

    public ButtonSeparator() {
        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        JTextField textField = new JTextField("текст");
        textField.setSize(new Dimension(width, 200));

        JButton button = new JButton("РАЗДЕЛИТЬ!");
        button.setMinimumSize(new Dimension(width, 100));
        button.setMaximumSize(new Dimension(width, 100));
        button.setPreferredSize(new Dimension(100,100));

        JLabel label = new JLabel(" ", JLabel.RIGHT);
        label.setVerticalAlignment(JLabel.TOP);
        label.setPreferredSize(new Dimension(200,100));
        Border border = BorderFactory.createLineBorder(Color.RED);
        label.setBorder(border);
        label.setBackground(Color.pink);
        label.setForeground(Color.BLUE);

        c.add(textField, BorderLayout.NORTH);
        c.add(button, BorderLayout.CENTER);
        c.add(label, BorderLayout.SOUTH);

        //Listener
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String result ="";
                String text = textField.getText();
                for (char symbol: text.toCharArray()) {
                    result += symbol + " ";
                }
                label.setText(result);
            }
        });
    }

    public static void main(String[] args) {
        ButtonSeparator buttonSeparator = new ButtonSeparator();
        buttonSeparator.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        buttonSeparator.setSize(width, height);
        buttonSeparator.setLocation(300,300);
        buttonSeparator.setVisible(true);
    }
}
