package g12.g12_1;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


public class Paint extends JFrame {
    private static final Font font = new Font("Verdana", Font.PLAIN, 18);
    private int widthLine = 1;
    private Color color = Color.BLACK;
    Color[] colors = {Color.WHITE, Color.BLACK, Color.RED, Color.GREEN, Color.BLUE};
    //Нужен для того чтобы нажималась только одна кнопка быстрого выбора цвета.
    private ButtonGroup btnGroupColor = new ButtonGroup();
    private int prevX, prevY;
    private java.util.List<Line> listLines;

    //Panels
    private JMenuBar menuBar = new JMenuBar();
    private JPanel functionPanel = new JPanel();
    private JPanel graficPanel = new JPanel();
    //private JScrollPane scrollGraficPane = new JScrollPane(graficPanel);

    //buttons
    private FileChooserAdapter fileChooser;
    private JButton buttonColorChooser = new JButton("ColorChooser");
    private String[] massiveWidth =
            {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "15", "20", "25", "50", "100"};
    private JComboBox buttonWidthChooser = new JComboBox(massiveWidth);

    //Listeners
    private ButtonActionListener buttonActionListener;

    public Paint() {
        //Базовые установки
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 400, 500, 400);
        setLayout(new BorderLayout());
        setTitle("MicroPaint");
        setLocationRelativeTo(null);
        setVisible(true);

        setListLines(new ArrayList<>());
        //Окно состоит из меню, функциональной панели и рафической панели
        setPanelMenu();
        setFunctionalPanel();
        setGrGraficPanel();

        //установка слушателей
        buttonActionListener = new ButtonActionListener(this);
        buttonColorChooser.addActionListener(buttonActionListener);
        buttonWidthChooser.addActionListener(buttonActionListener);
        buttonWidthChooser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        graficPanel.addMouseListener(new PaintMouseAdapter(this));
        graficPanel.addMouseMotionListener(new PaintMouseMotionAdapter(this));

        repaint();
    }

    private void setGrGraficPanel() {
        graficPanel.setBorder(new TitledBorder(new EtchedBorder(), "Графическая панель"));
        this.getContentPane().add(graficPanel, BorderLayout.CENTER);
    }

    private void setFunctionalPanel() {
        functionPanel.setBorder(new TitledBorder(new EtchedBorder(), "Функциональная панель"));
        functionPanel.add(buttonColorChooser);
        functionPanel.add(buttonWidthChooser);
        //setPanelFastColor(functionPanel);
        this.getContentPane().add(functionPanel, BorderLayout.NORTH);
    }

    @Override
    public void paint(Graphics g) {
        menuBar.repaint();
        functionPanel.repaint();
        graficPanel.repaint();
        drawLines();
        System.out.println("repaint");
    }

    public void drawLines() {
        for (Iterator i = listLines.iterator(); i.hasNext(); ) {
            ((Line)i.next()).draw(graficPanel.getGraphics());
        }
    }

    private void setPanelMenu() {
        //1
        JMenu fileMenu = new JMenu("File");
        JMenu newMenu = new JMenu("New");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        //прикрелпение FileChooser
        fileChooser = new FileChooserAdapter(this, openItem, saveItem);


        JMenuItem txtFileItem = new JMenuItem("Text file");
        JMenuItem imgFileItem = new JMenuItem("Image file");
        JMenuItem folderItem = new JMenuItem("Folder");
        newMenu.add(txtFileItem);
        newMenu.add(imgFileItem);
        newMenu.add(folderItem);

        fileMenu.add(newMenu);
        fileMenu.addSeparator();
        fileMenu.add(openItem);
        fileMenu.addSeparator();
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        //2
        JMenuItem clearMenu = new JMenuItem("Clear");
        clearMenu.addActionListener(new ButtonActionListener(this));

        //3
        JMenuItem infoMenu = new JMenuItem("Info");
        infoMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog((Component) e.getSource(), "Разработано компанией Warden");
            }
        });

        //Интеграция
        menuBar.add(fileMenu, BorderLayout.NORTH);
        menuBar.add(clearMenu, BorderLayout.NORTH);
        menuBar.add(infoMenu, BorderLayout.NORTH);
        this.setJMenuBar(menuBar);
    }

    //Установка быстрого выбора цвета
    private void setPanelFasdColor(JComponent component) {
        ItemListener itemListener = new RadioItemListener(this);
        for (Color color: colors) {
            JRadioButton button = new JRadioButton();
            button.setBackground(color);
            button.setBorderPainted(true);
            button.addItemListener(itemListener);
            component.add(button);
            btnGroupColor.add(button);
        }
    }

    //Этот метод устанавливает начальные координаты при рисовании зажатой кнопкой мыши
    public void setPreviousCoordinates(int aPrevX, int aPrevY) {
        prevX = aPrevX;
        prevY = aPrevY;
    }

    /**
     * Метод проверяет принадлежит ли цвет выбранный в ColorChoser
     * @param color
     * @return
     */
    public boolean isColors(Color color) {
        for (Color item : colors) {
            if (item.equals(color))return true;
        }
        return false;
    }

    //Getters and Setters
    public JPanel getGraficPanel() {
        return graficPanel;
    }

    public List<Line> getListLines() {
        return listLines;
    }

    public void setListLines(ArrayList<Line> listLines) {
        this.listLines = Collections.synchronizedList(listLines);
    }

    public int getPrevX() {
        return prevX;
    }


    public int getPrevY() {
        return prevY;
    }



    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getWidthLine() {
        return widthLine;
    }

    public void setWidthLine(int widthLine) {
        this.widthLine = widthLine;
    }

    public ButtonGroup getBtnGroupColor() {
        return btnGroupColor;
    }

    public static void main(String[] args) {
        Paint paint = new Paint();
    }
}
