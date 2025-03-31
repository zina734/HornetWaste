package gmManager;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.net.URL;
import javax.swing.JButton;

public class UI {
    gmManager game;                 // Make a gmManager object to be able to access fields in Actionhandler and Scenechanger
    JFrame window;                  // title bar, close/minimize/maximize buttons, and borders

    public JPanel bgPanel[] = new JPanel[10];  // Background Jpanel is a container that can hold buttons
    public JLabel bgLabel[] = new JLabel[10];  // Background Jlabel only displays individual text or images

    public UI(gmManager game) {                // UI constructor
        this.game = game;                      // define game

        createMainField();                     // Sets basic window functions
        startScreen();                         // Outputs completed screens

        window.setVisible(true);               // Set window to be true when UI object is made (in gmManager)
    }

    public void createMainField() { //
        window = new JFrame();                                  // defining window
        window.setSize(1112, 624);                 // set size of window
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close operation makes the exit button end the program
        window.getContentPane().setBackground(Color.white);    // sets background to white
        window.setLayout(null);                                // Layout is set to null, may change later to gridbaglayout for resizing
    }
    public void startScreen() {              // outputs the start screen
        // Screen 1
        createBackground(1, "images/background.png");                                            // set background image
        createStartscreen(1, 440, 140, 250, 100, "start.png");       // set start button
        bgPanel[1].add(bgLabel[1]);

        // Screen 2
        createBackground(2, "images/Levelscreen.png");
        createLevelSelect(2, 650, 300, 250, 100, "images/start.png", "levelScreen");
        bgPanel[2].add(bgLabel[2]);

    }

    public void createBackground(int num, String name) {
        bgPanel[num] = new JPanel();                                       // create new JPanel in panel
        bgPanel[num].setBounds(0, 0, 1920, 1080);       // set bounds for this image
        bgPanel[num].setLayout(null);                                     //
        window.add(bgPanel[num]);                                         // adds panel to UI

        bgLabel[num] = new JLabel();        // create new JLabel in label
        bgLabel[num].setBounds(0, 0, 1112, 624);               // sets bounds for this image

        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource(name));      // choose image
        bgLabel[num].setIcon(icon);
        bgPanel[num].add(bgLabel[num]);

    }

    public void createStartscreen(int num, int objx, int objy, int objWidth, int objHeight, String objFile) {
        JLabel button = new JLabel();
        button.setBounds(objx, objy, objWidth, objHeight);

        ImageIcon objIcon = new ImageIcon(getClass().getClassLoader().getResource("images/" + objFile));
        button.setIcon(objIcon);

        button.addMouseListener(new MouseListener() {
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    // Hide the old panel
                    bgPanel[num].setVisible(false);

                    // Define the new screen number
                    int newScreenNum = num + 1;

                    // Ensure the Levelscreen panel is initialized
                    if (bgPanel[newScreenNum] == null) {
                        createBackground(newScreenNum, "images/Levelscreen.png");
                        bgPanel[newScreenNum].setLayout(null);
                    }

                    // Clear the panel before adding new components
                    bgPanel[newScreenNum].removeAll();

                    // Add five buttons for levels
                    for (int i = 0; i < 5; i++) {
                        final int level = i + 1; // Assign each button a level number
                        JLabel levelButton = new JLabel();

                        if (i % 2 == 0) {
                            levelButton.setBounds(200 + (i * 150), 60, 200, 75); // Adjust positioning
                        } else {
                            levelButton.setBounds(150 + (i * 150), 170, 200, 75); // Adjust positioning
                        }

                        URL objURL = getClass().getClassLoader().getResource("images/start.png");
                        if (objURL != null) {
                            levelButton.setIcon(new ImageIcon(objURL));
                        } else {
                            System.out.println("Image not found: start.png");
                        }

                        // Make each level button go to the firstlevelscreen
                        levelButton.addMouseListener(new MouseListener() {
                            public void mousePressed(MouseEvent e) {
                                if (SwingUtilities.isLeftMouseButton(e)) {

                                    createLevelButton("images/firstlevelscreen.png", newScreenNum);        // create level button functionalities

                                    // wastePanel
                                }
                            }

                            public void mouseClicked(MouseEvent e) {}
                            public void mouseReleased(MouseEvent e) {}
                            public void mouseEntered(MouseEvent e) {}
                            public void mouseExited(MouseEvent e) {}
                        });

                        bgPanel[newScreenNum].add(levelButton);
                    }

                    // Add the background image LAST so buttons are on top
                    bgLabel[newScreenNum] = new JLabel();
                    bgLabel[newScreenNum].setBounds(0, 0, 1112, 624);
                    ImageIcon newBgIcon = new ImageIcon(getClass().getClassLoader().getResource("images/Levelscreen.png"));
                    bgLabel[newScreenNum].setIcon(newBgIcon);
                    bgPanel[newScreenNum].add(bgLabel[newScreenNum]);

                    // Show the level selection screen
                    bgPanel[newScreenNum].setVisible(true);
                    window.add(bgPanel[newScreenNum]);

                    // Refresh UI
                    bgPanel[newScreenNum].revalidate();
                    bgPanel[newScreenNum].repaint();
                }
            }

            public void mouseClicked(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
        });

        bgPanel[num].add(button);
        bgPanel[num].add(bgLabel[num]);
    }

    public void createLevelButton(String name, int newScreenNum) {              // level button selector
        int levelScreenNum = newScreenNum + 1; // Define the new screen number

        bgPanel[newScreenNum].setVisible(false); // Hide level selection screen

        if (bgPanel[levelScreenNum] == null) {
            createBackground(levelScreenNum, name);
            bgPanel[levelScreenNum].setLayout(null);
        }

        bgPanel[levelScreenNum].removeAll();

        bgLabel[levelScreenNum] = new JLabel();
        bgLabel[levelScreenNum].setBounds(0, 0, 1112, 624);
        ImageIcon levelBgIcon = new ImageIcon(getClass().getClassLoader().getResource(name));
        bgLabel[levelScreenNum].setIcon(levelBgIcon);
        bgPanel[levelScreenNum].add(bgLabel[levelScreenNum]);

        bgPanel[levelScreenNum].setVisible(true);
        window.add(bgPanel[levelScreenNum]);
    }


    public void createLevelSelect(int bgNum, int x, int y, int width, int height, String name, String cmd) {
        ImageIcon Level[] = new ImageIcon[10];
        JButton levelButton[] = new JButton[10];

        for (int i = 3; i < 8; ++i) {
            Level[i] = new ImageIcon(getClass().getClassLoader().getResource(name));
            levelButton[i] = new JButton();
            levelButton[i].setIcon(Level[i]);
            levelButton[i].revalidate();

            bgLabel[bgNum].setIcon(Level[i]);

            bgPanel[bgNum].add(levelButton[i]);         // add levelButton[]
            bgPanel[bgNum].add(bgLabel[bgNum]);         // add buttons to level select bgLabel

        }

    }

}