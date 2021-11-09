package g13.example_13;

import javax.swing.*;

public class DemoInputWithOptions {
    public static void main(String[] args) {
        Object[] possibleValues =
                { "легкий", "средний", "трудный" };
        Object selectedValue =
                JOptionPane.showInputDialog(
                        null,
                        "Выберите уровень",
                        "Input",
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        possibleValues,
                        null);
// possibleValues[1] - элемент для фокуса
// второй null – иконка по умолчанию
        if (selectedValue != null)
            System.out.println("You input : "
                    + selectedValue);
    }
}


