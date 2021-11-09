package g15_internet.example_5;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServerSocket {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            //Create and  Server socket
            ServerSocket serverSocket = new ServerSocket(8030);
            socket = serverSocket.accept();//Wait connection
            PrintStream printStream = new PrintStream(socket.getOutputStream());
            printStream.println("Hello User!");
            printStream.flush();
            printStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.toString());
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
