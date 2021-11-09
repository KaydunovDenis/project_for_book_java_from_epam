package g12.g12_1;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 * @author DenisKaydunov
 */
public class FileChooserAdapter {
    private JButton btnSaveFile   = null;
    private  JButton  btnOpenDir    = null;
    //private  JButton  btnFileFilter = null;

    private  JFileChooser fileChooser = null;

  /*  private final String[][] FILTERS = {{"docx", "Файлы Word (*.docx)"},
            {"pdf" , "Adobe Reader(*.pdf)"}};*/

    /**
     * Method create FileChooser my develop. Прикрепляет к кнопкам
     * AbstractButton buttonOpen, AbstractButton buttonSave
     * слушателей и обрабатывает действия с FileChooser.
     * @param frame в котором нахотятся объекты на которые необходимо пркрепить
     *              слушатели отвечающие за работу FileChooser
     * @param buttonOpen AbstractButton
     * @param buttonSave AbstractButton
     */
    public FileChooserAdapter(JFrame frame, AbstractButton buttonOpen, AbstractButton buttonSave) {
        setRussianLanguageForUIManager();

        // Создание экземпляра JFileChooser
        fileChooser = new JFileChooser();

        // Подключение слушателей к кнопкам
        buttonOpen.addActionListener(new ActionListener() {
            @Override
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

        buttonSave.addActionListener(new ActionListener() {
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
    }

    public FileChooserAdapter(JFrame frame) {
        setRussianLanguageForUIManager();
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
