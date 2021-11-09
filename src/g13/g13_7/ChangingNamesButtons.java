package g13.g13_7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *  Создать форму с набором кнопок так, чтобы надпись на первой кнопке
 * при ее нажатии передавалась на следующую, и т.д.
 */
public class ChangingNamesButtons extends JFrame {
    public int width = 200;
    public int height = 300;

    public ChangingNamesButtons(int count) throws HeadlessException {
        //Cтанндартные установки окна
        this.setTitle("Рассчет значения функции");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocation(600, 600);
        this.setSize((new Dimension(width, height)));
        this.setMinimumSize(new Dimension(width, height-100));
        this.setVisible(true);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JButton[] buttons = new JButton[count];
        for (int i = 0; i < count; i++) {
            JButton button = new JButton("Button " + (i + 1));
            c.add(button);
            buttons[i] = button;
        }

        for (int i = 0; i < count; i++) {
            int finalI = i;
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (finalI == (count - 1)) {
                        buttons[0].setText(buttons[finalI].getText());
                    } else {
                        buttons[finalI + 1].setText(buttons[finalI].getText());
                    }
                }
            });
        }

    }

    public static void main(String[] args) {
        ChangingNamesButtons window = new ChangingNamesButtons(5);
    }
}
