package LessonJava180;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        URLConnection connection = new URL("http://www.google.com/").openConnection();
        Scanner scanner = new Scanner(connection.getInputStream());
        scanner.useDelimiter("\\Z");
        //while (scanner.hasNextLine()) {
            System.out.println(scanner.next());
        //}
    }
}
