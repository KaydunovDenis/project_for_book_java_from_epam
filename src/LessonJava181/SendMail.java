/*
package LessonJava181;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SendMail {
    public static void main(String[] args) throws IOException, MessagingException {
        final Properties properties = new Properties();
        //properties.load(SendMail.class.getClassLoader().getResourceAsStream("mail.properties"));
        properties.load(new FileInputStream("D:\\Google\\Project\\Java\\book2.2\\src\\LessonJava181\\mail.properties"));


        //System.out.println(properties.toString());
        Session mailSession = Session.getDefaultInstance(properties);
        MimeMessage message = new MimeMessage(mailSession);
        message.setFrom("deniskaydunov@gmail.com");
        message.addRecipient(Message.RecipientType.TO, new InternetAddress("zlin68110@yandex.by"));
        message.setSubject("hello Denis!");
        message.setText("This  is my testing message from  the java application. Alenka Hello! Good night!");

        Transport tr = mailSession.getTransport();
        tr.connect(null, "Warden2021!");
        tr.sendMessage(message, message.getAllRecipients());
        tr.close();
    }
}
*/
