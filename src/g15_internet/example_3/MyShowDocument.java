package g15_internet.example_3;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class MyShowDocument extends JFrame {
    String text = "Страница загрузки";

    public MyShowDocument() throws HeadlessException {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Браузер");
        // Определяем разрешение экрана монитора
        Dimension size = Toolkit.getDefaultToolkit ().getScreenSize ();
        // Задаем размер
        setSize (size);
        setVisible(true);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        JLabel textField = new JLabel();
        c.add(textField, BorderLayout.NORTH);
        JEditorPane editorPane = new JEditorPane();
        c.add(editorPane, BorderLayout.CENTER);
        for (int timer = 0;timer < 30; timer++) {
            textField.setText(text);
            text += ".";
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            editorPane.setPage(new URL(getMyURL()));
        } catch (MalformedURLException e) {
            System.out.println("Некорректно задан протокол, доменное имя или путь к файлу ");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getMyURL() {
        return "file:///D:/Google/Project/HTML%205/htmlAcademy/portfolio%20site%20IT/index.html";
    }

    public static void main(String[] args) { new MyShowDocument();
    }
}
