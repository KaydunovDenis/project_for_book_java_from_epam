package LessonJava178;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(new ThreadServer(socket)).start();
            }
        } catch (IOException e) {
            System.out.println("Error of creaating the server:");
            e.printStackTrace();
        }
    }
}

