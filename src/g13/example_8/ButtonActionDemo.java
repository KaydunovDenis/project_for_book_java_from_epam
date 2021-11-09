package g13.example_8;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JComboBox;






import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ButtonActionDemo extends JFrame {
    private static final String EN_LANGUAGE = "English";
    private static final String RU_LANGUAGE = "Русский";
    private JPanel jContentPane = null;
    private JComboBox languageChooser = null;
    private JButton yesBtn = null;
    private JButton noBtn = null;
    private JLabel jLabel = null;

    public ButtonActionDemo() {
        initialize();
    }
    // ActionListener для кнопки 'Yes'
    private class YesButtonListener
            implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            jLabel.setText(getString("BUTTON_YES_MESSAGE"));
        }
    }
    // ActionListener для кнопки 'No'
    private class NoButtonListener
            implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            jLabel.setText(getString("BUTTON_NO_MESSAGE"));
        }
    }
    // ItemListener для combobox
    private class LanguageChooserItemListener
            implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            if (((String) e.getItem()).equals(EN_LANGUAGE)) {
                Locale.setDefault(Locale.ENGLISH);
            } else {
                Locale.setDefault(new Locale("RU"));
            }
            yesBtn.setText(getString("BUTTON_YES"));
            noBtn.setText(getString("BUTTON_NO"));
        }
    }
    private void initialize() {
        setSize(230, 200);
        setContentPane(getJContentPane());
        setTitle("JFrame");
        setVisible(true);
    }






    private JPanel getJContentPane() {
        if (jContentPane == null) {
            jLabel = new JLabel();
            jLabel.setText("JLabel");
            jContentPane = new JPanel();
            jContentPane.setLayout(new FlowLayout());
        }
        languageChooser = new JComboBox();
        languageChooser.addItem(EN_LANGUAGE);
        languageChooser.addItem(RU_LANGUAGE);
        languageChooser.addItemListener(
                new LanguageChooserItemListener());

        yesBtn = new JButton(getString("BUTTON_YES"));
        yesBtn.addActionListener(
                new YesButtonListener());

        noBtn = new JButton(getString("BUTTON_NO"));
        noBtn.addActionListener(
                new NoButtonListener());

        jContentPane.add(languageChooser);
        jContentPane.add(yesBtn);
        jContentPane.add(noBtn);
        jContentPane.add(jLabel);

        return jContentPane;
    }
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        ButtonActionDemo ob = new ButtonActionDemo();
        ob.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    private String getString(String property) {
        String text = "";
        try {
            text = new String(
                    Messages.getString(property).getBytes(
                            "ISO-8859-1"), "CP1251");
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }
        return text;
    }
}

