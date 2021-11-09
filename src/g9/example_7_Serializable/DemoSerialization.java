package g9.example_7_Serializable;

import java.io.*;

public class DemoSerialization {
    public static void main(String[] args) {
        // создание и запись объекта
        Student goncharenko =
                new Student("MMF", "Goncharenko", 1, "G017s9");
        System.out.println(goncharenko);
        File fw = new File("demo.dat");
        try {
            ObjectOutputStream ostream = new ObjectOutputStream(new FileOutputStream(fw));
            ostream.writeObject(goncharenko);
            ostream.close();
        } catch (IOException e) {
            System.err.println(e);
        }
        Student.faculty = "GEO";//изменение значения static-поля

        // чтение и вывод объекта
        File fr = new File("demo.dat");
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(fr));
            Student unknown = (Student)is.readObject();
            is.close();
            System.out.println(unknown);
        } catch (ClassNotFoundException ce) {
            System.err.println(ce);
            System.err.println("Класс не существует");
        } catch (FileNotFoundException fe) {
            System.err.println(fe);
            System.err.println("Файл не найден");
        } catch (IOException ioe) {
            System.err.println(ioe);
            System.err.println("Ошибка доступа");
        }
    }
}
