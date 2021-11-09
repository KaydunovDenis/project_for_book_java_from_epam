package s173_lotto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lotto extends JFrame implements ActionListener {
    // Компоненты.
    ClassLoader ldr = this.getClass().getClassLoader();

    JTextArea text = new JTextArea("Метод-обработчик для кнопки \nзапускает алгоритм выбора последова-\n" +
            "тельности из шести случайных чисел\n в диапазоне от 1 до 49, которые \n" +
            "будут отображаться в\n компоненте «текстовое поле».");


    java.net.URL iconURL = ldr.getResource("s173_lotto/Lotto.png");
    ImageIcon icon = new ImageIcon(iconURL);
    Image image = icon.getImage(); // transform it
    Image newImg = image.getScaledInstance(325, 200, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
    ImageIcon newIcon = new ImageIcon(newImg);  // transform it back


    JLabel img = new JLabel(newIcon);
    JTextField txt = new JTextField("", 18);
    JButton btn = new JButton("Показать счастливые номера");
    JPanel pnl = new JPanel();

    // Конструктор.
    public Lotto() {
        super("Приложение Lotto");
        setSize(352, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        text.setSize(250, 10);
        text.setFocusable(false);
        pnl.add(text);
        pnl.add(img);
        pnl.add(txt);
        pnl.add(btn);
        btn.addActionListener(this);
        add(pnl);
        setVisible(true);
    }

    // Обработчик событий.
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == btn) {
            int[] nums = new int[50];
            String str = "";
            for (int i = 1; i < 50; i++) {
                nums[i] = i;
            }
            for (int i = 1; i < 50; i++) {
                int r = (int) (49 * Math.random()) + 1;
                int temp = nums[i];
                nums[i] = nums[r];
                nums[r] = temp;
            }
            for (int i = 1; i < 7; i++) {
                str += " " + Integer.toString(nums[i]) + " ";
            }
            txt.setText(str);
        }
    }

    // Точка входа.
    public static void main(String[] args) {
        Lotto lotto = new Lotto();
    }
}