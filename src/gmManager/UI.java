package gmManager;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;

public class UI {
    gmManager game;             // game executor
    JFrame window;                  // createMainField() UI window

    public JPanel panel[] = new JPanel[10];
    public JLabel label[] = new JLabel[10];

    public UI(gmManager game) {         // modify displayed UI
        this.game = game;

        createMainField();
        createBackground();

        window.setVisible(true);
    }

    public void createMainField() {
        window = new JFrame();
        window.setSize(2560, 1440);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.white);
        window.setLayout(null);
    }

    public void createBackground() {
        panel[1] = new JPanel();                // create new JPanel in panel
        panel[1].setBounds(50, 50, 700, 350);       // set bounds for this panel
        panel[1].setLayout(null);
        window.add(panel[1]);


        label[1] = new JLabel();        // create new JLabel in label
        label[1].setBounds(0, 0, 700, 350);

        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("images/honeybarrel.jpg"));
        label[1].setIcon(icon);

        panel[1].add(label[1]);
    }
}
