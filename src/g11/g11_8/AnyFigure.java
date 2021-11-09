package g11.g11_8;

import javax.swing.*;
import java.awt.*;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 Задать движение по экрану строк (одна за другой) из массива строк.
 Направление движения по апплету и значение каждой строки выбира-
 ются случайным образом.
 */
public class AnyFigure extends JFrame {
    public static AnyFigure[] anyFigures;
    public static String msg;
    public static int width;
    public static int height;
    public static Point[] massivPoint;
    public static int countPoint;
    public static int sizePoint = 5;
    public static int diam = 100;//отступ
    public String text = "";
    public static int maxSquare = 0;
    public static String[] massivString;
    public static int offset = 0;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawString(msg, 100, 50);
        g.drawLine(0, 50 , width, 55);

        g.setColor(Color.BLUE);

        for (int i = 0; i < massivString.length; i++) {
            g.drawString(massivString[i], massivPoint[i].x + offset* massivPoint[i].dirrect, massivPoint[i].y);
        }

    }

    public void draw(Graphics g) {
    }

    public static int ask(String msg) {
        Scanner sc = new Scanner(System.in);
        System.out.print(msg);
        int n = sc.nextInt();
        return n;
    }

    public static void generatePoint(Point[] massivPoint, int countPoint) {
        for (int i = 0; i < countPoint; i++) {
            int x = (int) (Math.random() * (width - 2 * diam)) + diam;
            int y = (int)(Math.random()* (height - 2 * diam)) + diam;
            //massivPoint[i] = new Point(x, y, i + "");
        }
    }

    private static final SecureRandom rng = new SecureRandom(SecureRandom.getSeed(20));
//20 Bytes as a seed is rather arbitrary, it is the number used in the JavaDoc example

    //returns true for all chars in 0-9, a-z and A-Z
    boolean useThisCharacter(char c){
        //check for range to avoid using all unicode Letter (e.g. some chinese symbols)
        return c >= '0' && c <= 'z' && Character.isLetterOrDigit(c);
    }

    public String generateRandomString(long length){
        //Since there is no native CharStream, we use an IntStream instead
        //and convert it to a Stream<Character> using mapToObj.
        //We need to specify the boundaries for the int values to ensure they can safely be cast to char
        Stream<Character> randomCharStream = rng.ints(Character.MIN_CODE_POINT, Character.MAX_CODE_POINT).mapToObj(i -> (char)i).filter(this::test).limit(length);

        //now we can use this Stream to build a String utilizing the collect method.
        String randomString = randomCharStream.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
        return randomString;
    }

    public int generateRandomSignOffset() {
        int max = 1;
        int min = 0;
        int random_int = (int)(Math.random() * (max - min + 1) + min);
        return random_int == 0 ? 1 : -1;
    }


    public String givenUsingPlainJava__whenGeneratingRandomStringUnbounded__thenCorrect() {
        byte[]array = new byte[7];//length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));

        System.out.println(generatedString);
        return generatedString;
    }

    public static void main(String[] args) throws InterruptedException {
        msg = "Задание 7 к главе 11.";
        width = 500;
        height = 500;
        AnyFigure anyFigure = new AnyFigure();
        Thread thread = new Thread();


        int countString = 100;//ask("Input count triangles countTriangles = ");
        massivString = new String[countString];
        massivPoint = new Point[countString];
        generatePoint(massivPoint, countString);
        for (int i = 0; i < countString; i++) {
            massivString[i] = anyFigure.generateRandomString(20);
            //massivPoint[i].dirrect = anyFigure.generateRandomSignOffset();
        }



        anyFigure.setBackground(Color.GRAY);
        // устанавливается размер окна. Желательно!
        anyFigure.setSize(new Dimension(width, height));
        // заголовок
        anyFigure.setTitle(msg);
        anyFigure.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // установка видимости. Обязательно!
        anyFigure.setVisible(true);
        // перерисовка - вызов paint()

        for (int i = 0; i < 1000; i++) {
            anyFigure.repaint();
            offset++;
            Thread.sleep(50);
        }

    }

    /*private String generateRandomString() {
        int length = 16;
        Random r = new Random();
        String s = r.ints(48, 122)
                .filter(i -> (i < 57 || i > 65) && (i < 90 || i > 97))
                .mapToObj(i -> (char) i)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
        return s;
    }*/

    private boolean test(Character c) {
        return true;
    }
}
