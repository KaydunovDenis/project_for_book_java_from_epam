package g15_internet.example_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class ReadDocument {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://jobs.tut.by");
            InputStreamReader reader = new InputStreamReader(url.openStream());
            BufferedReader bufferedReader = new BufferedReader(reader);
            String data = "";
            while ((data = bufferedReader.readLine()) != null) {
                System.out.println(data);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
