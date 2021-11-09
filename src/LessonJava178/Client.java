package LessonJava178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket()) {
            //SocketAddress address = new InetSocketAddress("india.colorado.edu", 13);
            SocketAddress address = new InetSocketAddress(InetAddress.getLocalHost(), 8189);

            socket.connect(address, 5000);
            Scanner scanner = new Scanner(socket.getInputStream());

            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println("Hello server!");
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                System.out.println(data);
                if (data.contains("closing")) {
                    System.out.println("Client program is closing.");
                    break;
                }
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String temp = reader.readLine();
                printWriter.println(temp);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Сервер не отвечает...");
        }
    }
}


