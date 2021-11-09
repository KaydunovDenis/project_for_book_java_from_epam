package g13.g13_9;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


/**
 * В апплете изобразить прямоугольник (окружность, эллипс, линию).
 * Направление движения объекта по экрану изменяется на противопо-
 * ложное щелчком по клавише мыши. При этом каждый второй щелчок
 * меняет цвет фона.
 *
 * APGREID
 * #1 Добавить кнопку для добавления новых шаров+
 * #2 Добавить кнопку на уменьшение шаров
 * #3 Добавить лопание шаров+
 * #4 Добавить звук лопания шаров
 * #5 добавить направлеие по щелку мыши
 * #6 добавить окно подсчета+
 *
 *
 */
public class MoveComponent extends JFrame {
    public int width = 500;
    public int height = 500;
    public int count = 0;
    public int deadCount = 0;
    public JPanel panel = new JPanel();
    JLabel countLabel;
    JLabel deadLabel;
    public ArrayList<MovingComponentThread> listComponent = new ArrayList<>();

    public MoveComponent() throws HeadlessException {
        //Cтанндартные установки окна
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle(this.getClass().getSimpleName());
        setBounds(300, 300, width, height);
        setMinimumSize(new Dimension(width, height));
        setBackground(Color.GRAY);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        setVisible(true);

        String textAddButton = "Добавить компонент";
        JButton addButton = new JButton(textAddButton);
        addButton.setBounds(10,10,200, 30);
        c.add(addButton, BorderLayout.NORTH);


        panel.setBounds(50, 50, width -100, height -100);
        panel.setBackground(Color.lightGray);
        //panel.setBorder(BorderFactory.createLineBorder(Color.RED));
        c.add(panel, BorderLayout.CENTER);

        //leftPanel
        JButton westButton = new JButton("Добавить веселья!");
        c.add(westButton, BorderLayout.WEST);

        //rightPanel
        JPanel eastPanel = new JPanel();
        eastPanel.setLayout(new FlowLayout());
        c.add(eastPanel, BorderLayout.EAST);

        JSlider slider = new JSlider(JSlider.VERTICAL, 0, 100, 30);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.setMinorTickSpacing(5);
        slider.setMajorTickSpacing(10);
        eastPanel.add(slider);

        JLabel eastLabel = new JLabel("Size: " + slider.getValue());
        eastPanel.add(eastLabel);



        JPanel panelBottom = new JPanel();
        panelBottom.setLayout(new GridLayout(1, 2));
        countLabel = new JLabel(count + "",SwingConstants.CENTER);
        countLabel.setFont(new Font(Font.SERIF, Font.ITALIC, 22));
        panelBottom.add(countLabel);

        deadLabel = new JLabel(deadCount + "",SwingConstants.CENTER);
        deadLabel.setFont(new Font(Font.SERIF, Font.ITALIC, 22));
        panelBottom.add(deadLabel);

        c.add(panelBottom, BorderLayout.SOUTH);

        //TEST
        //MovingComponentThread testComponent = new MovingComponentThread(panel,0);
        //listComponent.add(testComponent);
        //testComponent.start();

        //addListener
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MovingComponentThread threadComponent = new MovingComponentThread(panel);
                listComponent.add(threadComponent);
                System.out.println(listComponent.size());
                countLabel.setText(listComponent.size() + "");
                threadComponent.start();
                //c.repaint();
                //threadComponent.removeComponent();

            }
        });

        westButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeColorAllComponent(0);
            }
        });

        panel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                int deadNumber = -1;
                for (int i = 0; i < listComponent.size(); i++) {
                    if (x > listComponent.get(i).getPosX() &&
                        x < (listComponent.get(i).getPosX() + listComponent.get(i).getBallSize()) &&
                        y> listComponent.get(i).getPosY() &&
                        y < (listComponent.get(i).getPosY() + listComponent.get(i).getBallSize())) {
                        System.out.println("BUMS!");
                        listComponent.get(i).setAlive(false);
                        deadNumber = i;
                        deadCount++;
                        deadLabel.setText(deadCount + "");
                        countLabel.setText(listComponent.size() + "");
                    }
                }
                if (deadNumber >= 0) {
                    listComponent.remove(deadNumber);
                }


               /* count++;
                System.out.println(count);
                if (e.getButton() == 1) {
                    for (MovingComponentThread threadComponent : listComponent){
                        if (count % 2 == 0) {
                            threadComponent.randomChangeColor();
                        }
                        threadComponent.changeDirrect();
                    }
                }*/
            }
        });

        slider.addChangeListener(new SliderListener(eastLabel, listComponent));


    }

    public void changeColorAllComponent(int delay){
        for (MovingComponentThread threadComponent : listComponent){
            threadComponent.randomChangeColor();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        new MoveComponent();
    }
}
