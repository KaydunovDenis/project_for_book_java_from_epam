package g12.g12_5;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class FileChooserAdapter {
    private JButton btnSaveFile   = null;
    private  JButton  btnOpenDir    = null;
    //private  JButton  btnFileFilter = null;

    private  JFileChooser fileChooser = null;
    private JFrame frame;

    private final String[][] FILTERS = {{"docx", "Файлы Word (*.docx)"},
            {"pdf" , "Adobe Reader(*.pdf)"}};

    public FileChooserAdapter(JFrame frame) {
        setRussianLanguageForUIManager();
        frame.setTitle("FileChooserAdapter");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Кнопка создания диалогового окна для выбора директории
        btnOpenDir = new JButton("Открыть директорию");
        // Кнопка создания диалогового окна для сохранения файла
        btnSaveFile = new JButton("Сохранить файл");
        // Кнопка создания диалогового окна для сохранения файла
        //btnFileFilter = new JButton("Фильтрация файлов");

        // Создание экземпляра JFileChooser
        fileChooser = new JFileChooser();


        // Подключение слушателей к кнопкам
        btnOpenDir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fileChooser.setDialogTitle("Выбор директории");
                // Определение режима - только каталог
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int result = fileChooser.showOpenDialog(frame);
                // Если директория выбрана, покажем ее в сообщении
                if (result == JFileChooser.APPROVE_OPTION )
                    JOptionPane.showMessageDialog(frame,
                            fileChooser.getSelectedFile());
            }
        });

        btnSaveFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fileChooser.setDialogTitle("Сохранение файла");
                // Определение режима - только файл
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int result = fileChooser.showSaveDialog(frame);
                // Если файл выбран, то представим его в сообщении
                if (result == JFileChooser.APPROVE_OPTION )
                    JOptionPane.showMessageDialog(frame,
                            "Файл '" + fileChooser.getSelectedFile() +
                                    " ) сохранен");
            }
        });

        // Размещение кнопок в интерфейсе
        JPanel contents = new JPanel();
        contents.add(btnOpenDir   );
        contents.add(btnSaveFile  );
        //contents.add(btnFileFilter);
        frame.add(contents);
    }

    private void setSaveFile() {

    }

    private void setRussianLanguageForUIManager(){
        // Локализация компонентов окна FileChooserAdapter на русский язык
        UIManager.put("FileChooserAdapter.saveButtonText", "Сохранить");
        UIManager.put(
                "FileChooserAdapter.cancelButtonText", "Отмена");
        UIManager.put(
                "FileChooserAdapter.fileNameLabelText", "Наименование файла");
        UIManager.put(
                "FileChooserAdapter.filesOfTypeLabelText", "Типы файлов");
        UIManager.put(
                "FileChooserAdapter.lookInLabelText", "Директория");
        UIManager.put(
                "FileChooserAdapter.saveInLabelText", "Сохранить в директории");
        UIManager.put(
                "FileChooserAdapter.folderNameLabelText", "Путь директории");
    }
}
