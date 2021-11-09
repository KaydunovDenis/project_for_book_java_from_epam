package g15_internet.example_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;

public class ServerThread extends Thread{
    private PrintStream os;//out
    private BufferedReader is;//reader
    private InetAddress address;

    public ServerThread(Socket socket) throws IOException {
        os = new PrintStream(socket.getOutputStream());
        is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        address = socket.getInetAddress();
    }

    public void run() {
        int i = 0;
        String str;
        try {
            while ((str = is.readLine()) != null) {
                if ("PING".equals(str)) {
                    os.println("PONG " + ++i + " with " + address.getHostName());
                }
                System.out.println(address.getHostName() + " write mesage: " + str);
            }
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Disconnect");
        } finally {
            //disconnect();
        }

    }

    private void disconnect() {
        try {
            System.out.println(address.getHostName() + " disconnected");
            os.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            this.interrupt();
        }
    }
}
