package g15_internet.example_7;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class NetServerThread {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8072);
            System.out.println("Server initialized.");
            while (true) {
                Socket socket = server.accept();
                System.out.println(socket.getInetAddress().getHostName() + " conected");
                //create stream for exchange data
                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println(e);
        }
    }
}

