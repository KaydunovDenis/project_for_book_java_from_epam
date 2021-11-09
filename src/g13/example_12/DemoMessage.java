package g13.example_12;

import javax.swing.*;

public class DemoMessage {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(
                null,
                "Файл не найден.",
                "Ошибка!",
                JOptionPane.ERROR_MESSAGE);
        JOptionPane.showMessageDialog(
                null,
                "Файл  удален!",
                "Информация",
                JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(
                null,
                "Файл может быть удален!",
                "Внимание!",
                JOptionPane.WARNING_MESSAGE);
        JOptionPane.showMessageDialog(
                null,
                "Вы уверены что хотите удалить файл?!",
                "Подтверждение удаления!",
                JOptionPane.QUESTION_MESSAGE);
        JOptionPane.showMessageDialog(
                null,
                "Файл может быть удален!",
                "Отчет!",
                JOptionPane.PLAIN_MESSAGE);





// ERROR_MESSAGE – сообщение об ошибке
// INFORMATION_MESSAGE - информационное сообщение
// WARNING_MESSAGE  - уведомление
// QUESTION_MESSAGE - вопрос
// PLAIN_MESSAGE - без иконки
    }
}
