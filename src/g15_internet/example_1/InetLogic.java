package g15_internet.example_1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetLogic {
    public static void main(String[] args) {
        InetAddress myIP = null;
        InetAddress bsuIP = null;
        try {
            myIP = InetAddress.getLocalHost();
            System.out.println("myIP = " + myIP.getHostAddress() + " " + myIP.getCanonicalHostName() +
            " " + myIP.getHostName() + " " + myIP.getAddress().toString());
            bsuIP = InetAddress.getByName("www.bsu.by");
            System.out.println("bsyIP = " + bsuIP.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
