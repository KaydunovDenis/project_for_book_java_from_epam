package g9.example_1;
import java.io.*;
import java.util.*;

public class FileTest {
    public static void main(String[] args) {
        //c объектом типа File ассоциируется файл на диске FileTest2.java
        File fp = new File("src\\g9\\example_1\\FileTest2.java");
        if(fp.exists()) {
            System.out.println(fp.getName() + " существует");

            if(fp.isFile()) {//если объект – дисковый файл
                System.out.println("Путь к файлу:\t"
                        + fp.getPath());
                System.out.println("Абсолютный путь:\t"
                        + fp.getAbsolutePath());
                System.out.println("Размер файла:\t"
                        + fp.length() + " bytes");
                System.out.println("Последняя модификация :\t"
                        + new Date(fp.lastModified()));
                System.out.println("Файл доступен для чтения:\t"
                        + fp.canRead());
                System.out.println("Файл доступен для записи:\t"
                        + fp.canWrite());
                System.out.println("Файл не удален:\t"
                        /*+ fp.delete()*/);
            }
        } else
            System.out.println("файл " + fp.getName()
                    + " не существует");
        try{
            if(fp.createNewFile())
                System.out.println("Файл " + fp.getName()
                        + " создан");
        } catch(IOException e) {
            System.err.println(e);
        }
        //в объект типа File помещается каталог\директория
        // в корне проекта должен быть создан каталог com.learn с несколькими файлами
        File dir = new File("src\\com");
        if (dir.exists() && dir.isDirectory())/*если объект является  каталогом и если этот каталог существует */
            System.out.println("каталог "
                    + dir.getName() + " существует");
        File[] files = dir.listFiles();
        for(int i = 0; i < files.length; i++){
            Date date = new Date(files[i].lastModified());
            System.out.print("\n" + files[i].getPath()
                    + " \t| " + files[i].length() + "\t| "
                    + date.toString());
            //использовать toLocaleString() или toGMTString()
        }
        // метод listRoots() возвращает доступные корневые каталоги
        for (File file  : File.listRoots() ) {
            File root = file;
            System.out.printf("\n%s %,d Гб из %,d ГБ свободно.",
                    root.getPath(), root.getUsableSpace() / 1024 / 1024 / 1024, root.getTotalSpace() / 1024 / 1024 / 1024);
            // 1024/1024/1024 необходимо для перевода байт в гигобайты
        }

        for (File file  : dir.listFiles() ) {
            File root = file;
            System.out.printf("\n%s", root);
            // 1024/1024/1024 необходимо для перевода байт в гигобайты
        }
    }
}
