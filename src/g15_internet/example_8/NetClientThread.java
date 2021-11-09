package g15_internet.example_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class NetClientThread {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), 8072);
            PrintStream printStream = new PrintStream(socket.getOutputStream());
            InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            for (int i = 1; i <= 10; i++) {
                printStream.println("PING");
                printStream.println("PING " + i);
                System.out.println(bufferedReader.readLine());
                //Thread.sleep(1000);
            }
            socket.close();
            System.out.println(socket.toString() + " closed");
    /*    } catch (InterruptedException e) {
            System.out.println("Error: stream interrupted");
            e.printStackTrace();*/
        } catch (UnknownHostException e) {
            System.out.println("Server not found.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error I/O");
            e.printStackTrace();
        }
    }
}
