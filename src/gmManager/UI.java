package gmManager;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class UI {
    gmManager game;             // game executor
    JFrame window;                  // createMainField() UI window

    public JPanel panel[] = new JPanel[10];
    public JLabel label[] = new JLabel[10];

    public UI(gmManager game) {         // modify displayed UI
        this.game = game;

        createMainField();
        screen();

        window.setVisible(true);
    }

    public void createMainField() {
        window = new JFrame();
        window.setSize(1112, 624);             // set size of window
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.white);
        window.setLayout(null);
    }

    public void createBackground(int num, String name) {
        panel[num] = new JPanel();                // create new JPanel in panel
        panel[num].setBounds(0, 0, 1920, 1080);       // set bounds for this image
        panel[num].setLayout(null);
        window.add(panel[1]);                               // adds panel to UI


        label[num] = new JLabel();        // create new JLabel in label
        label[num].setBounds(0, 0, 1112, 624);               // sets bounds for this image

        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource(name));      // choose image
        label[num].setIcon(icon);


    }

    public void createButton(int num, int objx, int objy, int objWidth, int objHeight, String objFile) {
        JLabel button = new JLabel();                   // object label
        button.setBounds(objx, objy, objWidth, objHeight);  // object icon

        ImageIcon objIcon = new ImageIcon(getClass().getClassLoader().getResource("images/" + objFile));         // set start button label to "obj"
        button.setIcon(objIcon);                                                                                      // set start button to the JLabel "button"

        button.addMouseListener(new MouseListener() {

            public void mouseClicked(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {
                if(SwingUtilities.isLeftMouseButton(e)) {
                    ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("images/Levelscreen.png"));      // choose image
                    button.setIcon(null);
                    button.revalidate();
                    label[num].setIcon(icon);      // go to level screen
                }
            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {


            };
        });

        panel[num].add(button);
        panel[num].add(label[num]);
    }

    public void screen() {              // outputs the start screen
        // Screen 1
        createBackground(1, "images/background.png");          // set background image
        createButton(1, 440, 140, 200, 200, "start.png");       // set start button

    }
}
