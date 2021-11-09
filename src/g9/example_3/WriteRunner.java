package g9.example_3;

import java.io.*;

public class WriteRunner {
    public static void main(String[] args) {
        String pArray[] = { "2007 ", "Java SE 6", "Русский текст" };
        File fbyte = new File("src\\g9\\example_3\\byte.txt");
        File fsymb = new File("src\\g9\\example_3\\symbol.txt");
        try {
            FileOutputStream fos =
                    new FileOutputStream(fbyte);
            FileWriter fw = new FileWriter(fsymb);
            for (String a : pArray) {
                fos.write(a.getBytes());
                fw.write(a);
            }
            fos.close();
            fw.close();
        } catch (IOException e) {
            System.err.println("ошибка файла: " + e);
        }
    }
}
