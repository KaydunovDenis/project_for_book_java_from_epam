package g15_internet.g15_1;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Клиентская часть приложения.
 Сервер запущен и находится в блокирующем ожидании server.accept(); обращения к нему с запросом на подключение.
 Теперь можно подключаться клиенту.
 Клиент работает когда пользователь вводит что-либо в его консоли
 (внимание! в данном случае сервер и клиент запускаются на одном компьютере с локальным адресом — localhost,
 поэтому при вводе строк, которые должен отправлять клиент не забудьте убедиться,
 что вы переключились в рабочую консоль клиента!).
 После ввода строки в консоль клиента и нажатия enter строка проверяется не ввёл ли клиент кодовое слово
 для окончания общения дальше отправляется серверу, где он читает её и то же проверяет на наличие кодового слова выхода.
 Оба и клиент и сервер получив кодовое слово закрывают ресурсы после предварительных приготовлений и завершают свою работу.
 */
public class Client extends JFrame {
    private int width = 500;
    private int height = 400;

    public Client() {
        super("FileTest");
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.createGUI();
        runClient();
    }

    private void createGUI() {
        MyGraphics.setPosition(this);
        MyGraphics.setBasicSetting(this);
        this.setTitle("MyMessenger");
        Container c = getContentPane();
        //c.setLayout(new BorderLayout());
        Border border = BorderFactory.createLineBorder(Color.GRAY);
        Dimension dimension = new Dimension(150, 50);

/*
        //Label Chat
        JLabel labelChat = new JLabel("Чат");
        JTextArea textChat = new JTextArea();
        labelChat.setBorder(border);
        labelChat.add(textChat);
        c.add(labelChat);
*/


        //LabelMesage
        JLabel labelMessage = new JLabel();
        labelMessage.setLayout(new FlowLayout());
        JTextArea textMsg = new JTextArea(3, 30);
        textMsg.setFont(new Font("Dialog", Font.ITALIC, 14));
        textMsg.setLineWrap(true);//осущ. перенос слова на новую строку
        textMsg.setWrapStyleWord(true);//осущ. переслова целиком
        textMsg.setText("Введите сообщение:");
        textMsg.setBorder(border);

        JButton buttonSentMsg = new JButton("Отправить");
        buttonSentMsg.setMinimumSize(dimension);
        labelMessage.add(new JScrollPane(textMsg));
        labelMessage.add(buttonSentMsg);

        c.add(labelMessage);


        JLabel labelList = new JLabel("Users");
        JCheckBox checkBox = new JCheckBox();

        setVisible(true);

        //Listeners
        buttonSentMsg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String msg = textMsg.getText();

                System.out.println("The message was sent.\nMessage: " + msg);

            }
        });
    }

    public static void runClient() {
        // запускаем подключение сокета по известным координатам и нициализируем приём сообщений с консоли клиента
        try (Socket socket = new Socket("localhost", 8080);
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             DataOutputStream oos = new DataOutputStream(socket.getOutputStream());
             DataInputStream ois = new DataInputStream(socket.getInputStream()))
        {
            System.out.println("Client connected to socket.");
            // проверяем живой ли канал и работаем если живой
            while(!socket.isOutputShutdown()){
                // ждём консоли клиента на предмет появления в ней данных
                if(br.ready()){
                    // данные появились - работаем
                    System.out.println("Client start writing in channel...");
                    Thread.sleep(1000);
                    String clientMessage = br.readLine();
                    // пишем данные с консоли в канал сокета для сервера
                    oos.writeUTF(clientMessage);
                    oos.flush();
                    System.out.println("Clien sent message " + clientMessage + " to server.");
                    Thread.sleep(1000);
                    // ждём чтобы сервер успел прочесть сообщение из сокета и ответить
                    // проверяем условие выхода из соединения
                    if (isQuit(ois, clientMessage)) break;
                    // если условие разъединения не достигнуто продолжаем работу
                    System.out.println("Client sent message & start waiting for data from server...");
                    Thread.sleep(2000);
                    // проверяем, что нам ответит сервер на сообщение(за предоставленное
                    // ему время в паузе он должен был успеть ответить)
                    // если успел забираем ответ из канала сервера в сокете и сохраняем её в ois переменную,
                    // печатаем на свою клиентскую консоль
                    readDataServer(ois);
                }
            }
        } catch (UnknownHostException e) {
            System.out.println("Error: Server not found! --> " + e);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error O/I");
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static boolean isQuit(DataInputStream ois, String clientMessage) throws InterruptedException, IOException {
        if(clientMessage.equalsIgnoreCase("quit")){
            // если условие выхода достигнуто разъединяемся
            System.out.println("Client completed connection.");
            Thread.sleep(2000);
            // смотрим что нам ответил сервер на последок перед закрытием ресурсов
            readDataServer(ois);
            // после предварительных приготовлений выходим из цикла записи чтения
            return true;
        }
        return false;
    }

    public static void readDataServer(DataInputStream ois) throws IOException {
        if(ois.read() > -1)     {
            System.out.println("reading...");
            String in = ois.readUTF();
            System.out.println(" Server: " + in);
        }
    }


    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}


