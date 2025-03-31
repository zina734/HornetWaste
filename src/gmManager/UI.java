package gmManager;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.DefaultButtonModel;
import javax.swing.*;
import java.net.URL;

public class UI {
    gmManager game;             // game executor
    JFrame window;                  // createMainField() UI window

    public JPanel bgPanel[] = new JPanel[10];
    public JLabel bgLabel[] = new JLabel[10];

    public UI(gmManager game) {         // modify displayed UI
        this.game = game;

        createMainField();
        startScreen();

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
        bgPanel[num] = new JPanel();                // create new JPanel in panel
        bgPanel[num].setBounds(0, 0, 1920, 1080);       // set bounds for this image
        bgPanel[num].setLayout(null);
        window.add(bgPanel[num]);                               // adds panel to UI


        bgLabel[num] = new JLabel();        // create new JLabel in label
        bgLabel[num].setBounds(0, 0, 1112, 624);               // sets bounds for this image

        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource(name));      // choose image
        bgLabel[num].setIcon(icon);
        bgPanel[num].add(bgLabel[num]);


    }

    /* public void createButton(int num, int objx, int objy, int objWidth, int objHeight, String objFile) {
        JLabel button = new JLabel();                   // object label
        button.setBounds(objx, objy, objWidth, objHeight);  // object icon

        ImageIcon objIcon = new ImageIcon(getClass().getClassLoader().getResource("images/" + objFile));         // set start button label to "obj"
        button.setIcon(objIcon);                                                                                      // set start button to the JLabel "button"

        button.addMouseListener(new MouseListener() {

            public void mouseClicked(MouseEvent e) {

            }

            public void mousePressed(MouseEvent e) {
                if(SwingUtilities.isLeftMouseButton(e)) {

                    //createLevelButton(2, 500, 500, 250, 100, "images/start.png", "levelScreen");
                    ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("images/Levelscreen.png"));      // choose image
                    button.setIcon(null);
                    button.revalidate();
                    bgLabel[2].setIcon(icon);

                    /*ImageIcon Level[] = new ImageIcon[10];
                    JButton levelButton[] = new JButton[10];

                    for (int i = 3; i < 8; ++i) {
                        Level[i] = new ImageIcon(getClass().getClassLoader().getResource("images/start.png"));
                        levelButton[i] = new JButton();
                        levelButton[i].setIcon(Level[i]);
                        levelButton[i].revalidate();

                        levelButton[i].setBounds(500 + 100 * i, 500 + 100 * i, 250, 100);
                        levelButton[i].setBackground(null);
                        levelButton[i].setContentAreaFilled(false);
                        levelButton[i].setFocusPainted(false);
                        levelButton[i].setIcon(Level[i]);
                        levelButton[i].addActionListener(game.handler);
                        levelButton[i].setActionCommand("levelScreen");
                        levelButton[i].setBorderPainted(false);

                        bgLabel[2].setIcon(Level[i]);

                        bgPanel[2].add(levelButton[i]);
                        bgPanel[2].add(bgLabel[2]);

                    } */

                   /* // level 1
                    JLabel button1 = new JLabel();                   // object label
                    button1.setBounds(objx + 100, objy + 100, objWidth, objHeight);  // object icon

                    ImageIcon objIcon1 = new ImageIcon(getClass().getClassLoader().getResource("images/" + objFile));         // set start button label to "obj"
                    button1.setIcon(objIcon1);
                    // level 2
                    JLabel button2 = new JLabel();                   // object label
                    button2.setBounds(objx + 200, objy + 100, objWidth, objHeight);  // object icon

                    ImageIcon objIcon2 = new ImageIcon(getClass().getClassLoader().getResource("images/" + objFile));         // set start button label to "obj"
                    button2.setIcon(objIcon2);

                    // level 3
                    JLabel button3 = new JLabel();                   // object label
                    button3.setBounds(objx + 300, objy + 100, objWidth, objHeight);  // object icon

                    ImageIcon objIcon3 = new ImageIcon(getClass().getClassLoader().getResource("images/" + objFile));         // set start button label to "obj"
                    button3.setIcon(objIcon3);

                    // level 4
                    JLabel button4 = new JLabel();                   // object label
                    button4.setBounds(objx + 400, objy + 100, objWidth, objHeight);  // object icon

                    ImageIcon objIcon4 = new ImageIcon(getClass().getClassLoader().getResource("images/" + objFile));         // set start button label to "obj"
                    button4.setIcon(objIcon4);

                    // level 5
                    JLabel button5 = new JLabel();                   // object label
                    button5.setBounds(objx + 500, objy + 100, objWidth, objHeight);  // object icon

                    ImageIcon objIcon5 = new ImageIcon(getClass().getClassLoader().getResource("images/" + objFile));         // set start button label to "obj"
                    button5.setIcon(objIcon5);

                    bgPanel[2].add(button1);
                    bgPanel[2].add(button2);
                    bgPanel[2].add(button3);
                    bgPanel[2].add(button4);
                    bgPanel[2].add(button5);
                    bgPanel[2].revalidate();
                    bgPanel[2].repaint(); */

                   /* bgPanel[2].setLayout(null);

                    for (int i = 1; i <= 5; i++) {
                        JLabel button = new JLabel();
                        button.setBounds(objx + 100 * i, objy + 100, objWidth, objHeight);

                        URL objURL = getClass().getClassLoader().getResource("images/" + objFile);
                        if (objURL != null) {
                            button.setIcon(new ImageIcon(objURL));
                        } else {
                            System.out.println("Image not found: " + objFile);
                        }

                        bgPanel[2].add(button);
                    }

// Refresh panel
                    bgPanel[2].revalidate();
                    bgPanel[2].repaint();

                }
            }

            public void mouseReleased(MouseEvent e) {

            }

            public void mouseEntered(MouseEvent e) {

            }

            public void mouseExited(MouseEvent e) {


            };
        });
        bgPanel[num].add(button);
        bgPanel[num].add(bgLabel[num]);
    } */

    public void createButton(int num, int objx, int objy, int objWidth, int objHeight, String objFile) {
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
                                    int levelScreenNum = newScreenNum + 1; // Define the new screen number

                                    bgPanel[newScreenNum].setVisible(false); // Hide level selection screen

                                    if (bgPanel[levelScreenNum] == null) {
                                        createBackground(levelScreenNum, "images/firstlevelscreen.png");
                                        bgPanel[levelScreenNum].setLayout(null);
                                    }

                                    bgPanel[levelScreenNum].removeAll();

                                    bgLabel[levelScreenNum] = new JLabel();
                                    bgLabel[levelScreenNum].setBounds(0, 0, 1112, 624);
                                    ImageIcon levelBgIcon = new ImageIcon(getClass().getClassLoader().getResource("images/firstlevelscreen.png"));
                                    bgLabel[levelScreenNum].setIcon(levelBgIcon);
                                    bgPanel[levelScreenNum].add(bgLabel[levelScreenNum]);

                                    bgPanel[levelScreenNum].setVisible(true);
                                    window.add(bgPanel[levelScreenNum]);

                                    //wastePanel
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



    public void createLevelButton(int bgNum, int x, int y, int width, int height, String name, String cmd) {
        ImageIcon Level[] = new ImageIcon[10];
        JButton levelButton[] = new JButton[10];

        for (int i = 3; i < 8; ++i) {
            Level[i] = new ImageIcon(getClass().getClassLoader().getResource(name));
            levelButton[i] = new JButton();
            levelButton[i].setIcon(Level[i]);
            levelButton[i].revalidate();

           /* levelButton[i].setBounds(x + 100 * i, y + 100 * i, width, height);        // don't remember what this does so not including it
            levelButton[i].setBackground(null);
            levelButton[i].setContentAreaFilled(false);
            levelButton[i].setFocusPainted(false);
            levelButton[i].setIcon(Level[i]);
            levelButton[i].addActionListener(game.handler);
            levelButton[i].setActionCommand(cmd);
            levelButton[i].setBorderPainted(false);   */

            bgLabel[bgNum].setIcon(Level[i]);

            bgPanel[bgNum].add(levelButton[i]);
            bgPanel[bgNum].add(bgLabel[bgNum]);

        }

    }

    public void startScreen() {              // outputs the start screen
        // Screen 1
        createBackground(1, "images/background.png");          // set background image
        createButton(1, 440, 140, 250, 100, "start.png");       // set start button
        bgPanel[1].add(bgLabel[1]);

        // Screen 2
        createBackground(2, "images/Levelscreen.png");
        createLevelButton(2, 650, 300, 250, 100, "images/start.png", "levelScreen");
        bgPanel[2].add(bgLabel[2]);

        //createBackground(3, "images/firstlevelscreen.png");
        //createLevelButton(2, 650, 300, 250, 100, "images/start.png", "levelOne");
    }

}
