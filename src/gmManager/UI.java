package gmManager;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.*;

public class UI {
    gmManager game;                 // Make a gmManager object to be able to access fields in Actionhandler and Scenechanger
    public JFrame window;                  // title bar, close/minimize/maximize buttons, and borders

    public JPanel bgPanel[] = new JPanel[10];  // Background Jpanel is a container that can hold buttons
    public JLabel bgLabel[] = new JLabel[10];  // Background Jlabel only displays individual text or images

    public int level = 0;

    public UI(gmManager game) {                // UI constructor
        this.game = game;                      // define game

        createMainField();                     // Sets basic window functions
        startScreen();                         // Outputs completed screens
        // Resize the background panel dynamically

        window.setVisible(true);               // Set window to be true when UI object is made (in gmManager)
    }

    public void createMainField() {
        window = new JFrame();
        window.setSize(1920, 1080);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null); // We'll add a JLayeredPane here
        final Timer[] resizeTimer = {new Timer()};
        window.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                game.resizer.setFastResizeMode(true); // fast/low-quality resize

                resizeTimer[0].cancel();  // Cancel any pending task
                resizeTimer[0] = new Timer();
                resizeTimer[0].schedule(new TimerTask() {
                    @Override
                    public void run() {
                        SwingUtilities.invokeLater(() -> {
                            Dimension newSize = window.getSize();
                            game.resizer.setFastResizeMode(false); // smooth/high-quality resize
                            game.resizer.resizeAll(newSize.width, newSize.height);
                        });
                    }
                }, 100); // Wait 300ms after resizing stops
            }
        });

       /* window.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Dimension newSize = window.getSize();
                game.resizer.resizeAll(newSize.width, newSize.height);
            }
        }); */

    }

    public void startScreen() {                                                                             // Creates background and button for start screen
        createBackground(0, "images/background.png");                                            // set background image stores it into index 0 of the Jpanel array
        createStartButton(0, 800, 405, 250, 100, "start.png");       // set start button, sends in index,location, size, and tag of button
        bgPanel[0].add(bgLabel[0]);                                                                         // Initialized a null label into the background panel array

    }

    // This method creates a background panel with an image, stores it in arrays, and adds it to the main window at the given index.
    public void createBackground(int num, String name) {
        bgPanel[num] = new JPanel();                                               // creates a new Jpanel object in background panel array for the index that has been passed in.
        bgPanel[num].setBounds(0, 0, 1920, 1080);               // set default bounds for this image
        bgPanel[num].setLayout(null);                                             // layout of the Jpanel may change to gridbaglayout for resizing
        window.add(bgPanel[num]);                                                 // Adds the finished panel to the main JFrame window

        bgLabel[num] = new JLabel();                                              // create new JLabel(Image) type add it to array that holds all images
        bgLabel[num].setBounds(0, 0, 1920, 1080);                // sets bounds for this image

        //getClass tells us the class that we are currently in, classLoader knows where all your files and resources are, getResource finds the specific file you are looking for
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource(name));      // uses parameter to load image into a icon variable
        bgLabel[num].setIcon(icon);                                                         // Add the image to the passed in index label (image array)
        bgPanel[num].add(bgLabel[num]);         // Add the label to the passed index panel (Collection of labels)
        game.resizer.registerOriginalBounds(bgLabel[num]);
        bgPanel[num].setComponentZOrder(bgLabel[num], bgPanel[num].getComponentCount() - 1);

    }

    public void createStartButton(int num, int objx, int objy, int objWidth, int objHeight, String objFile) {
        JLabel button = new JLabel();                                   // make new label called button for start button
        button.setBounds(objx, objy, objWidth, objHeight);              // sets bounds and size of the label called button

        ImageIcon objIcon = new ImageIcon(getClass().getClassLoader().getResource("images/" + objFile));   // sends in image saves to objIcon
        button.setIcon(objIcon);                                                                                 // sets the label to image in objIcon

        button.addMouseListener(new MouseListener() {                  // Attach a mouse listener to the button

            public void mousePressed(MouseEvent e) {                   // This method is called when the mouse button is pressed down
                if (SwingUtilities.isLeftMouseButton(e)) {             // Check if the LEFT mouse button was used for this press
                    bgPanel[num].setVisible(false);                    // Turns off the start screen (Hides old panel)
                    level = num + 1;                        // New index for a new panel (level screen)

                    if (bgPanel[level] == null) {               // Make sure the panel is empty
                        createBackground(level, "images/Levelscreen.png"); // Uses function to load the level screen into new index of background panels
                        bgPanel[level].setLayout(null);         // Set layout to null may turn it to gridbaglayout for resizing
                    }

                    bgPanel[level].removeAll();                 // Clear the panel before adding new components
                    createLevelSelect();                   // Create level select screen
                    // createLevelSelect(level);                   // Create level select screen

                    // Refresh UI
                    bgPanel[level].revalidate();                // Ensures the layout is recalculated using the correct panel using the specified index
                    bgPanel[level].repaint();                   // Redraws the panel to display updates using the correct panel specified bt the index
                }
            }

            public void mouseClicked(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
        });

        bgPanel[num].add(button);                                      // After adding the mouse listener, add the button to the original panel
        game.resizer.registerOriginalBounds(button);
        bgPanel[num].add(bgLabel[num]);                                //
    }

    public void createLevelSelect() {
        bgLabel[level] = new JLabel(); // Create background label
        bgLabel[level].setBounds(0, 0, 1920, 1080); // Set background size and position
        ImageIcon newBgIcon = new ImageIcon(getClass().getClassLoader().getResource("images/Levelscreen.png")); // Load background image
        bgLabel[level].setIcon(newBgIcon); // Set background image
        bgPanel[level].add(bgLabel[level]); // Add background to the panel
        game.resizer.registerOriginalBounds(bgLabel[level]);
        window.add(bgPanel[level]);


        // Add five buttons for levels
        for (int i = 0; i < 5; i++) {
            JLabel levelButton = new JLabel(); // Create a new label to act as a level button (5 times bc its in the if statement)

            // Set the position of each button; first display top row of buttons, then display bottom row
            if (i < 3) {
                levelButton.setBounds(600 + (i * 300), 110, 200, 75); // Top row positioning
            } else {
                levelButton.setBounds(450 + ((i - 2) * 300), 260,200, 75); // Bottom row positioning
            }

            // Load the button image icon (5 times bc its in the if statement)
            URL objURL = getClass().getClassLoader().getResource("levels/lvl" + (i + 1) + ".png");
            if (objURL != null) {
                levelButton.setIcon(new ImageIcon(objURL)); // Set icon if image is found
            } else {
                System.out.println("Image not found: lvl" + (i + 1) + ".png");
            }

            // Make each level button go to the firstlevelscreen
            // int finalLevelScreen = level;
            int finalI = i + 1;
            levelButton.addMouseListener(new MouseListener() {
                public void mousePressed(MouseEvent e) {
                    if (SwingUtilities.isLeftMouseButton(e)) {
                        bgPanel[level].setVisible(false); // Hide the current screen (level selection screen)
                        createLevelButton("levelscreen/levelscreen" + finalI + ".png");        // create level button functionalities
                    }
                }

                public void mouseClicked(MouseEvent e) {}
                public void mouseReleased(MouseEvent e) {}
                public void mouseEntered(MouseEvent e) {}
                public void mouseExited(MouseEvent e) {}
            });

            bgPanel[level].add(levelButton);
            game.resizer.registerOriginalBounds(levelButton);
            bgPanel[level].setComponentZOrder(levelButton, 0);


        }


    }


    public void createLevelButton(String name) {
        level = level + 1;

        if (bgPanel[level] == null) {
            bgPanel[level] = new JPanel(null);
            bgPanel[level].setBounds(0, 0, 1920, 1080);
            window.add(bgPanel[level]);
        }

        bgPanel[level].removeAll();

        // Add draggable object FIRST
        game.waste.imgLaunch(level); // waste added here

        // THEN add background LAST
        bgLabel[level] = new JLabel();
        bgLabel[level].setBounds(0, 0, 1920, 1080);
        ImageIcon levelBgIcon = new ImageIcon(getClass().getClassLoader().getResource(name));
        bgLabel[level].setIcon(levelBgIcon);
        bgPanel[level].add(bgLabel[level]);
        game.resizer.registerOriginalBounds(bgLabel[level]);

        // Move background to the back, draggable object to front

        bgPanel[level].setVisible(true);
    }
}