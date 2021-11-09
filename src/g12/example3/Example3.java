package g12.example3;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Example3 extends JFrame {
    private JButton additionBtn = new JButton("Сложить");
    private JButton substractBtn = new JButton("Вычесть");
    private JTextField txtField1 = new JTextField(3);
    private JTextField txtField2 = new JTextField(3);
    private JLabel answer = new JLabel();

    public Example3() {
        Container c = getContentPane();
        setLayout(new FlowLayout());
        c.add(txtField1);
        c.add(txtField2);
        // регистрация блока прослушивания события
        additionBtn.addActionListener(new ButtonListener());
        substractBtn.addActionListener(new ButtonListener());
        c.add(additionBtn);
        c.add(substractBtn);
        c.add(answer);
    }

    private class ButtonListener implements ActionListener {
        // реализация класса- обработчика события
        public void actionPerformed(ActionEvent ev) {
            try {
                int t1 = Integer.parseInt(txtField1.getText());
                int t2 = Integer.parseInt(txtField2.getText());
                int result;
                if (ev.getSource() == additionBtn) {
                    result = t1 + t2;
                } else result = t1 - t2;
                answer.setText("Ответ: " + result);
                System.out.println("Выполнено успешно!");
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода!");
            }
        }
    }

    public static void main(String[] args) {
        Example3 example = new Example3();
        example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        example.setBounds(200, 100, 300, 200);
        example.setTitle("MicroCalc");
        example.setVisible(true);
        example.setBackground(Color.GRAY);
        example.repaint();
    }
}
