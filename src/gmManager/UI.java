package gmManager;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import javax.swing.*;

public class UI {
    gmManager game;
    public JFrame window;
    public JPanel bgPanel[] = new JPanel[10];
    public JLabel bgLabel[] = new JLabel[10];
    public int level = 0;

    public UI(gmManager game) {
        this.game = game;
        createMainField();   // set up main window
        startScreen();       // show initial start screen
        window.setVisible(true);
    }

    public void createMainField() {
        window = new JFrame();
        window.setSize(1920, 1080);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null); // manual layout positioning
    }

    public void startScreen() {
        createBackground(0, "images/background.png");
        createStartButton(0, 800, 405, 250, 100, "PlayNow.png");
        bgPanel[0].add(bgLabel[0]);
    }

    // creates a background panel with an image and attaches it to the frame
    public void createBackground(int num, String name) {
        bgPanel[num] = new JPanel();
        bgPanel[num].setBounds(0, 0, 1920, 1080);
        bgPanel[num].setLayout(null);
        window.add(bgPanel[num]);

        bgLabel[num] = new JLabel();
        bgLabel[num].setBounds(0, 0, 1920, 1080);

        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource(name));
        bgLabel[num].setIcon(icon);
        bgPanel[num].add(bgLabel[num]);
        bgPanel[num].setComponentZOrder(bgLabel[num], bgPanel[num].getComponentCount() - 1);
    }

    // adds an image-based button that switches to the next screen when clicked
    public void createStartButton(int num, int objx, int objy, int objWidth, int objHeight, String objFile) {
        JLabel button = new JLabel();
        button.setBounds(objx, objy, objWidth, objHeight);

        ImageIcon objIcon = new ImageIcon(getClass().getClassLoader().getResource("images/" + objFile));
        button.setIcon(objIcon);

        button.addMouseListener(new MouseListener() {
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    bgPanel[num].setVisible(false);
                    level = num + 1;

                    // create the level screen if it doesn’t exist yet
                    if (bgPanel[level] == null) {
                        createBackground(level, "images/Levelscreen.png");
                        bgPanel[level].setLayout(null);
                    }

                    // show level select screen
                    window.setComponentZOrder(bgPanel[level], 0);
                    bgPanel[level].setVisible(true);
                    createLevelSelect();

                    bgPanel[level].revalidate();
                    bgPanel[level].repaint();
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

    // builds the level selection screen and its buttons
    public void createLevelSelect() {
        bgLabel[level] = new JLabel();
        bgLabel[level].setBounds(0, 0, 1920, 1080);
        ImageIcon newBgIcon = new ImageIcon(getClass().getClassLoader().getResource("images/Levelscreen.png"));
        bgLabel[level].setIcon(newBgIcon);
        bgPanel[level].add(bgLabel[level]);
        window.add(bgPanel[level]);

        // exit button to return to start screen
        JLabel exitButton = new JLabel();
        exitButton.setBounds(800, 600, 250, 100);
        ImageIcon exitIcon = new ImageIcon(getClass().getClassLoader().getResource("images/exit.png"));
        exitButton.setIcon(exitIcon);

        exitButton.addMouseListener(new MouseListener() {
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    int newLevel = level - 1;
                    bgPanel[1].setVisible(false);
                    level = newLevel;
                    window.setComponentZOrder(bgPanel[newLevel], 0);
                    bgPanel[0].setVisible(true);
                    window.revalidate();
                    window.repaint();
                }
            }

            public void mouseClicked(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
        });

        bgPanel[level].add(exitButton);
        bgPanel[level].setComponentZOrder(exitButton, 0);

        // create five selectable level buttons
        for (int i = 0; i < 5; i++) {
            JLabel levelButton = new JLabel();

            // set button position (top or bottom row)
            if (i < 3) {
                levelButton.setBounds(600 + (i * 300), 110, 200, 75);
            } else {
                levelButton.setBounds(450 + ((i - 2) * 300), 260, 200, 75);
            }

            // load button image
            URL objURL = getClass().getClassLoader().getResource("levels/lvl" + (i + 1) + ".png");
            if (objURL != null) {
                levelButton.setIcon(new ImageIcon(objURL));
            } else {
                System.out.println("Image not found: lvl" + (i + 1) + ".png");
            }

            int finalI = i + 1;
            levelButton.addMouseListener(new MouseListener() {
                public void mousePressed(MouseEvent e) {
                    if (SwingUtilities.isLeftMouseButton(e)) {
                        bgPanel[level].setVisible(false);
                        System.out.println(level);
                        createLevelButton("levelscreen/levelscreen" + finalI + ".png");
                    }
                }

                public void mouseClicked(MouseEvent e) {}
                public void mouseReleased(MouseEvent e) {}
                public void mouseEntered(MouseEvent e) {}
                public void mouseExited(MouseEvent e) {}
            });

            bgPanel[level].add(levelButton);
            bgPanel[level].setComponentZOrder(levelButton, 0);
        }
    }

    // loads an individual level screen with its background and draggable objects
    public void createLevelButton(String name) {
        if (level <= 5)
            level = level + 1;

        // if this panel doesn’t exist yet, make it
        if (bgPanel[level] == null) {
            bgPanel[level] = new JPanel(null);
            bgPanel[level].setBounds(0, 0, 1920, 1080);
            window.add(bgPanel[level]);
        }

        // spawn draggable items for that level
        game.waste.imgLaunch(level);

        // set level background image
        bgLabel[level] = new JLabel();
        bgLabel[level].setBounds(0, 0, 1920, 1080);
        ImageIcon levelBgIcon = new ImageIcon(getClass().getClassLoader().getResource(name));
        bgLabel[level].setIcon(levelBgIcon);
        bgPanel[level].add(bgLabel[level]);

        // hide old level and show new one
        bgPanel[1].setVisible(false);
        bgPanel[level].setVisible(true);
    }

    // Show victory screen when all levels are completed
    public void showVictoryScreen() {
        int victoryPanelIndex = 7;
        
        if (bgPanel[victoryPanelIndex] == null) {
            bgPanel[victoryPanelIndex] = new JPanel(null);
            bgPanel[victoryPanelIndex].setBounds(0, 0, 1920, 1080);
            bgPanel[victoryPanelIndex].setBackground(new Color(50, 200, 100));
            window.add(bgPanel[victoryPanelIndex]);

            // Victory message
            JLabel victoryLabel = new JLabel("Congratulations on winning!");
            victoryLabel.setBounds(600, 400, 800, 100);
            victoryLabel.setFont(new Font("Arial", Font.BOLD, 48));
            victoryLabel.setForeground(Color.WHITE);
            victoryLabel.setHorizontalAlignment(SwingConstants.CENTER);
            bgPanel[victoryPanelIndex].add(victoryLabel);

            // Secondary message
            JLabel subLabel = new JLabel("You've completed all 5 levels!");
            subLabel.setBounds(600, 500, 800, 50);
            subLabel.setFont(new Font("Arial", Font.PLAIN, 32));
            subLabel.setForeground(Color.WHITE);
            subLabel.setHorizontalAlignment(SwingConstants.CENTER);
            bgPanel[victoryPanelIndex].add(subLabel);

            // Return to start button
            JButton returnButton = new JButton("Return to Start");
            returnButton.setBounds(810, 600, 300, 60);
            returnButton.setFont(new Font("Arial", Font.BOLD, 20));
            returnButton.setFocusPainted(false);
            returnButton.addActionListener(e -> {
                bgPanel[victoryPanelIndex].setVisible(false);
                level = 0;
                window.setComponentZOrder(bgPanel[0], 0);
                bgPanel[0].setVisible(true);
                
                // Reset all level completions
                for (int i = 1; i <= 5; i++) {
                    game.items.levelCompleted.put(i, false);
                }
            });
            bgPanel[victoryPanelIndex].add(returnButton);
        }

        // Hide current panel and show victory screen
        bgPanel[1].setVisible(false);
        window.setComponentZOrder(bgPanel[victoryPanelIndex], 0);
        bgPanel[victoryPanelIndex].setVisible(true);
    }
}
