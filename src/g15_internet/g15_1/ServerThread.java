package g15_internet.g15_1;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class ServerThread extends Thread{
    private MyServer myServer;
    private Socket client;
    private InetAddress address;
    private DataInputStream in;
    private DataOutputStream out;

    public ServerThread(MyServer myServer, Socket socket) {
        this.myServer = myServer;
        this.client = socket;
        address = client.getInetAddress();
        this.setDaemon(true);
    }

    public void run() {
        String nameClient = address.getHostName();
        String str;
        boolean isFirstMsg = true;
        boolean isNameClient = true;
        try {
            // канал записи в сокет
            out = new DataOutputStream(client.getOutputStream());
            System.out.println("DataOutputStream  created");
            // канал чтения из сокета
            in = new DataInputStream(client.getInputStream());
            System.out.println("DataInputStream created");
            // начинаем диалог с подключенным клиентом в цикле, пока сокет не закрыт
            while (!client.isClosed()) {
                System.out.println("Server reading from channel");
                // сервер ждёт в канале чтения (inputstream) получения данных клиента
                String entry = in.readUTF();
                // после получения данных считывает их
                System.out.println("READ from client message - " + entry);
                // и выводит в консоль
                System.out.println("Server try writing to channel");

                // инициализация проверки условия продолжения работы с клиентом по этому сокету по кодовому слову
                // - quit
                if (entry.equalsIgnoreCase("quit")) {
                    System.out.println("Client initialize connections suicide ...");
                    out.writeUTF("Server reply - " + entry + " - OK");
                    out.flush();
                    Thread.sleep(3000);
                    break;// прерывает цикл while в котором работает сокет
                } else {
                    // если условие окончания работы не верно - продолжаем работу -
                    // отправляем эхо-ответ  обратно клиенту
                    out.writeUTF("Server reply - " + entry + " - OK");
                    System.out.println("Server Wrote message to client.");

                    // освобождаем буфер сетевых сообщений (по умолчанию сообщение не сразу отправляется в сеть,
                    // а сначала накапливается в специальном буфере сообщений, размер которого определяется конкретными
                    // настройками в системе, а метод  - flush() отправляет сообщение не дожидаясь наполнения буфера
                    // согласно настройкам системы
                    out.flush();
                }
            }

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Disconnect " + nameClient);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Error in thr thread. Tread was interrupt.");
        } finally {
            // если условие выхода - верно выключаем соединения
            disconnect();
        }

    }

    private void disconnect() {
        try {
            System.out.println("Client disconnected.\n Closing connections & channels.");
            // закрываем сначала каналы сокета in and out!
            in.close();
            out.close();
            // потом закрываем сам сокет общения на стороне сервера!
            client.close();
            System.out.println(address.getHostName() + " disconnected sucsess");
            // потом закрываем сокет сервера который создаёт сокеты общения
            // хотя при многопоточном применении его закрывать не нужно
            // для возможности поставить этот серверный сокет обратно в ожидание нового подключения
            System.out.println("Closing connections & channels - DONE.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            this.interrupt();
        }
    }


    private void sendMsg(Socket socket, String msg) throws IOException {
        String nameClient = "User";
        out.writeBytes(nameClient + " write: " + msg);
    }
}
