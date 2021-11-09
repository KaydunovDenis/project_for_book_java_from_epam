package g9.example_4;

import java.io.*;

public class RandomFiles {
    public static void main(String[] args) {
        double data[] = { 1, 10, 50, 200, 5000 };
        try {
            RandomAccessFile rf = new RandomAccessFile("temp.txt", "rw");
            for (double d : data)
                rf.writeDouble(d); // запись в файл
            // /* чтение в обратном порядке */
            for (int i = data.length - 1; i >= 0; i--) {
                rf.seek(i * 8);
                // длина каждой переменной типа double равна 8-и байтам
                System.out.println(rf.readDouble());
            }
            rf.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
