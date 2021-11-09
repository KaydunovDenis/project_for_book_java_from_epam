package g13.g13_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TreeSet;


/**
 * 2. Поместить в апплет две панели JPanel и кнопку. Первая панель со-
 * держит поле ввода и метку “Поле ввода”; вторая – поле вывода и метку
 * “Поле вывода”. Для размещения в окне двух панелей и кнопки “Скопи-
 * ровать” использовать менеджер размещения BorderLayout.
 *
 * 3. Изменить задачу 2 так, чтобы при нажатии на кнопку “Скопировать”
 * текст из поля ввода переносился в поле вывода, а поле ввода очища-
 * лось.
 *
 * 4. Задача 2 модифицируется так, что при копировании поля ввода нужно,
 * кроме собственно копирования, организовать занесение строки из поля
 * ввода во внутренний список. При решении использовать коллекцию,
 * в частности ArrayList.
 *
 * 5. К условию задачи 2 добавляется еще одна кнопка с надписью “Печать”.
 * При нажатии на данную кнопку весь сохраненный список должен быть
 * выведен в консоль. При решении использовать коллекцию, в частности
 * TreeSet.
 */
public class InputData extends JFrame {
    public static int width = 500;
    public static int height = 300;
    public static ArrayList<String> list = new ArrayList<>();

    public InputData() throws HeadlessException {
        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        JLabel inputLabel = new JLabel("Поле ввода");
        JTextField inputTextField = new JTextField("тут будет текст", 20);
        inputPanel.add(inputLabel);
        inputPanel.add(inputTextField);

        JPanel buttonPanel = new JPanel();
        JButton button = new JButton("Скопировать");
        button.setToolTipText("Кнопка копирования");
        buttonPanel.add(button);

        JPanel outputPanel = new JPanel();
        JLabel outLabel = new JLabel("Поле вывода");
        JTextField outputTextField = new JTextField(20);
        inputTextField.setSize(200,200);
        outputTextField.setHorizontalAlignment((int) LEFT_ALIGNMENT);
        outputPanel.add(outLabel);
        outputPanel.add(outputTextField);

        JButton printButton = new JButton("Печать");
        printButton.setToolTipText("Вывод в консоль");

        //Add element
        c.add(inputPanel, BorderLayout.NORTH);
        c.add(buttonPanel, BorderLayout.CENTER);
        c.add(outputPanel, BorderLayout.SOUTH);
        c.add(printButton, BorderLayout.EAST);

        //Listeners
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = inputTextField.getText();
                outputTextField.setText(text);
                list.add(text);
                inputTextField.setText("");
            }
        });

        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TreeSet<String> treeList = new TreeSet(list);
                for (String item : treeList) {
                    System.out.println(item);
                }
            }
        });
    }

    public static void main(String[] args) {
        InputData inputData = new InputData();
        inputData.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        inputData.setLocation(600, 600);
        inputData.setSize((new Dimension(width, height)));
        inputData.setVisible(true);
    }
}
