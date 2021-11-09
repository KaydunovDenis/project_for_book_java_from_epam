package g9.example_2;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadDemo {
    public static void main(String[] args) {
        File f = new File("file.txt");//должен существовать!

        int b, count = 0;
        try {
            FileReader is = new FileReader(f);
            /* FileInputStream is = new FileInputStream(f);*/  //альтернатива
            while ((b = is.read()) != -1) {/*чтение*/
                System.out.print((char)b);
                count++;
            }
            is.close(); // закрытие потока ввода
        } catch (IOException e) {
            System.err.println("ошибка файла: " + e);
        }
        System.out.print("\n число байт = " + count);
    }
}
