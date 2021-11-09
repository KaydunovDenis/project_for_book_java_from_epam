package LessonJava178;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

class ThreadServer implements Runnable {
    Socket socket;

    public ThreadServer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (InputStream inputStream = socket.getInputStream();
             Scanner scanner = new Scanner(inputStream);
             OutputStream outputStream = socket.getOutputStream();
             PrintWriter writer = new PrintWriter(outputStream, true);
        ) {
            while (scanner.hasNextLine()) {
                String text = scanner.nextLine();

                if (text.equals("exit")) {
                    System.out.println("Server is closing");
                    writer.println("Disconnect ");
                    break;
                } else {
                    writer.println("You've write: " + text);
                    System.out.println(text);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
