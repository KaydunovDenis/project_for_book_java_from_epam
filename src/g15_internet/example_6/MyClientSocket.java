package g15_internet.example_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class MyClientSocket {
    public static void main(String[] args) {
        Socket socket = null;

        try {
            socket = new Socket("RMO-LP-1", 8072);
            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader br = new BufferedReader(isr);
            PrintStream printStream = new PrintStream(socket.getOutputStream());
            printStream.println("Hello Server");
            printStream.println("PING");
            Thread.sleep(5000);
            printStream.println("PING");
            Thread.sleep(5000);
            printStream.println("PING");
            printStream.flush();
            String msg = br.readLine();
            System.out.println(msg);
            socket.close();
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Error: Server not found! --> " + e);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
