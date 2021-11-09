package mp3;import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MP3 extends JFrame implements ActionListener{
    private ClassLoader ldr = this.getClass().getClassLoader();
    private JLayeredPane layerPane;
    //img
    private java.net.URL iconURL = ldr.getResource("resources/bg.jpg");
    private ImageIcon icon = new ImageIcon("resources/bg.jpg");

    //audio
    java.applet.AudioClip audio = JApplet.newAudioClip( ldr.getResource("sound.wav"));
    //button
    private JButton playBtn = new JButton("PLAY");
    private JButton stopBtn = new JButton("STOP");
    //label
    private JLabel labelBg;

    public MP3(){
        JPanel panel = new JPanel();
        //layerPane = new JLayeredPane();
        //labelBg = new JLabel(icon);
        panel.add(labelBg);

        /*labelBg.setVerticalAlignment(JLabel.TOP);
        labelBg.setHorizontalAlignment(JLabel.CENTER);
        labelBg.setOpaque(true);
        labelBg.setBackground(Color.BLACK);
        labelBg.setBorder(BorderFactory.createLineBorder(Color.black));
        layerPane.add(labelBg,1);*/

        /*labelButton = new JLabel("Button");
        labelButton.setVerticalAlignment(JLabel.TOP);
        labelButton.setHorizontalAlignment(JLabel.CENTER);
        labelButton.setOpaque(true);
        labelButton.setBackground(Color.BLACK);
        //labelButton.setForeground(Color.black);
        labelButton.setBorder(BorderFactory.createLineBorder(Color.black));
        //labelButton.setBounds(origin.x, origin.y, 140, 140);*/

        //Добавление элементов
        panel.add(playBtn,1);
        //labelButton.add(stopBtn,0);
        playBtn.addActionListener(this);
        stopBtn.addActionListener(this);

        //layerPane.add(labelButton);


        //add(layerPane);
    }

    public void actionPerformed(ActionEvent event){
        if(event.getSource() == playBtn) audio.play();
        if(event.getSource() == stopBtn) audio.stop();
    }

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("MP3");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,500);
        //Create and set up the content pane.


        //frame.pack(); //set size this window according sizes components
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}

