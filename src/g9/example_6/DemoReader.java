package g9.example_6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DemoReader {
    public static void main(String[] args) {
        try {
            BufferedReader br =
                    new BufferedReader(new FileReader("res.txt"));
            String tmp = "";
            while ((tmp = br.readLine()) != null) {
                //пробел использовать как разделитель
                String[] s = tmp.split("\\s");
                //вывод полученных строк
                for (String res : s)
                    System.out.println(res);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
