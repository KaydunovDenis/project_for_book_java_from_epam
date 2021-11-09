package g15_internet.g15_1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Основной и самый главный класс сервера.
 * Он управляет созданием всех соединений.
 */
public class MyServer {
    private ArrayList<Socket> list = new ArrayList();
    boolean isAlive = true;
    static ExecutorService executeIt = Executors.newFixedThreadPool(2);


    public ArrayList<Socket> getList() {
        return list;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public static void main(String[] args) {
        MyServer myServer = new MyServer();
        try {
            ServerSocket server = new ServerSocket(8080);
            System.out.println("SERVER IS INITIALIZED.");
            while (myServer.isAlive) {
                Socket clientSoket = server.accept();
                System.out.println(clientSoket.getInetAddress().getHostName() + " conected");
                //Добавляем сокет в список, чтобы позже можно было обращаться
                // к этим сокетам как к клиентам
                myServer.getList().add(clientSoket);
                //create stream for exchange data
                ServerThread serverThread = new ServerThread(myServer, clientSoket);
                serverThread.start();
                System.out.println(myServer.getList().get(0).getInetAddress());
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println(e);
        }
    }



}
