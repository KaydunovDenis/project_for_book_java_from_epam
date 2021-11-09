package g13.g13_6;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Написать программу для построения таблицы значений функции
 * y = a * sqrt( x) * cos(a * x). Использовать метку JLabel, содержащую текст
 * “Функция: y a x *cos(ax) ”; панель, включающую три текстовых
 * поля JTextField, содержащих значения параметра, шага (например,
 * 0.1) и количества точек. Начальное значение x=0. С каждым текстовым
 * полем связана метка, содержащая его название. В приложении должно
 * находиться текстовое поле со скроллингом, содержащее полученную
 * таблицу.
 */
public class TableFunction extends JFrame {
    public static int width = 500;
    public static int height = 300;

    public static ArrayList<Object[]> list = new ArrayList<Object[]>();
    public static JTable table;
    public static DataModel model = new DataModel();
    double a=0;
    double y;
    double h;
    int N;

    public TableFunction() throws HeadlessException {
        //Cтанндартные установки окна
        this.setTitle("Рассчет значения функции");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocation(600, 600);
        this.setSize((new Dimension(width, height)));
        this.setMinimumSize(new Dimension(width, height-100));
        this.setVisible(true);


        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        //JLabel mainLabel = new JLabel("y = a * sqrt( x) * cos(a * x)");

        JPanel panel = new JPanel();
        JLabel label1 = new JLabel("Значение параметра");
        JLabel label2 = new JLabel("Шаг");
        JLabel label3 = new JLabel("Количество точек");
        JTextField textField1 = new JTextField("",5);
        JTextField textField2 = new JTextField("",5);
        JTextField textField3 = new JTextField("",5);
        panel.add(label1);
        panel.add(textField1);
        panel.add(label2);
        panel.add(textField2);
        panel.add(label3);
        panel.add(textField3);

        table = new JTable(model);

        c.add(panel, BorderLayout.NORTH);
        c.add(new JScrollPane(table), BorderLayout.CENTER);

        JButton insertBtn = new JButton("Обновить данные");
        insertBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                updateModel();
            }
        });
        getContentPane().add(insertBtn, BorderLayout.SOUTH);

        //Listeners
        CaretListener listener = new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                boolean isEception = false;
                String nameBox = e.getSource().toString();
                try {
                    if (nameBox.equals(textField1.toString())) {
                        a = Double.parseDouble(((JTextField) e.getSource()).getText());
                        System.out.println("a = " + a);
                    }
                    if (nameBox.equals(textField2.toString())) {
                        h = Double.parseDouble(((JTextField) e.getSource()).getText());
                        System.out.println("h = " + a);
                    }
                    if (nameBox.equals(textField3.toString())) {
                        N = Integer.parseInt(((JTextField) e.getSource()).getText());
                        System.out.println("a = " + N);
                    }
                } catch (NumberFormatException e1) {
                    isEception = true;
                    ((Component)e.getSource()).setBackground(Color.pink);
                    System.out.println("Неверный ввод параметров в " + nameBox);
                } finally {
                    if (!isEception) {
                        ((Component)e.getSource()).setBackground(new Color(144, 238, 144));
                    }
                }
            }
        };
        textField1.addCaretListener(listener);
        textField2.addCaretListener(listener);
        textField3.addCaretListener(listener);


    }

    private void updateModel() {
        double x = 0;
        list = new ArrayList<>();
        model.setRows(0);
        for (int count = 0; count < N; count++) {
            x = h * count;
            y = getY(x, a);
            model.addRow(count+1, x, y);
        }
    }

    public double getY(double x, double a) {
        return 3*x;//a * Math.sqrt(x) * Math.cos(a * x);
    }

    public static void main(String[] args) {
        TableFunction table = new TableFunction();

    }
}

