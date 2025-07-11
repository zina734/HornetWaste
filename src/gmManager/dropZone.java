package gmManager;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BorderFactory;

import java.util.HashMap;

public class dropZone extends JPanel {

    int certCheck = 0;
    gmManager gm;
    int count;
    ArrayList<String> cor = new ArrayList<>();
    String newItem;

    public dropZone(gmManager gm) {
        this.gm = gm;

    }

    public JLabel compost(int panel) {
        JLabel dropZone1 = new JLabel();
        dropZone1.setBounds(150, 650, 150, 275);         // location for area object should be dropped to
        dropZone1.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        gm.ui.bgPanel[panel].add(dropZone1);
        return dropZone1;

    }

    public JLabel recycle(int panel) {
        JLabel dropZone1 = new JLabel();
        dropZone1.setBounds(500, 650, 150, 275);         // location for area object should be dropped to
        dropZone1.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        gm.ui.bgPanel[panel].add(dropZone1);
        return dropZone1;

    }

    public JLabel landfill(int panel) {
        JLabel dropZone1 = new JLabel();
        dropZone1.setBounds(750, 650, 150, 275);         // location for area object should be dropped to
        dropZone1.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        gm.ui.bgPanel[panel].add(dropZone1);
        return dropZone1;

    }

    public JLabel drop1(int panel) {                // ppm surplus
        JLabel dropZone1 = new JLabel();
        dropZone1.setBounds(1000, 650, 150, 275);         // location for area object should be dropped to
        dropZone1.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        gm.ui.bgPanel[panel].add(dropZone1);
        return dropZone1;

    }

    public JLabel drop2(int panel) {                // the 5th one
        JLabel dropZone1 = new JLabel();
        dropZone1.setBounds(1250, 650, 150, 275);         // location for area object should be dropped to
        dropZone1.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        gm.ui.bgPanel[panel].add(dropZone1);
        return dropZone1;
    }

    public JLabel drop3(int panel) {                // the 5th one
        JLabel dropZone1 = new JLabel();
        dropZone1.setBounds(1450, 650, 150, 275);         // location for area object should be dropped to
        dropZone1.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        gm.ui.bgPanel[panel].add(dropZone1);
        return dropZone1;
    }

    public void createZone(JLabel bin, int list) {
        int wasteX = gm.waste.waste.getX();
        int wasteY = gm.waste.waste.getY();
        int zoneX = bin.getX();
        int zoneY = bin.getY();
        int zoneW = bin.getWidth();
        int zoneH = bin.getHeight();

        switch (list) {
            case 0:
                gm.items.loadCMP();            // each load item method will load every correct answer for that bin into the hashmap
                zoneBounds(wasteX, wasteY, zoneX, zoneY, zoneW, zoneH, gm.items.cmp);
                break;
            case 1:
                gm.items.loadRCY();
                zoneBounds(wasteX, wasteY, zoneX, zoneY, zoneW, zoneH, gm.items.rcy);
                break;
            case 2:
                gm.items.loadLND();
                zoneBounds(wasteX, wasteY, zoneX, zoneY, zoneW, zoneH, gm.items.lnd);
                break;
            case 3:
                gm.items.loadEWS();
                zoneBounds(wasteX, wasteY, zoneX, zoneY, zoneW, zoneH, gm.items.ews);
                break;
            case 4:
                gm.items.loadHRR();
                zoneBounds(wasteX, wasteY, zoneX, zoneY, zoneW, zoneH, gm.items.hrr);
                break;
            case 5:
                gm.items.loadHRS();
                zoneBounds(wasteX, wasteY, zoneX, zoneY, zoneW, zoneH, gm.items.hrs);
                break;
        }

    }

    public void createTitle(String name, int lvl) {
            if (gm.waste.wasteTitle == null) {
                gm.waste.wasteTitle = new JLabel(name);
                gm.waste.wasteTitle.setForeground(Color.RED);
                gm.waste.wasteTitle.setBounds(810, 100, 200, 20);
                gm.ui.bgPanel[lvl].add(gm.waste.wasteTitle);
            } else {
                gm.waste.wasteTitle.setText(name);
            }
    }

    public void zoneBounds(int wasteX, int wasteY, int binX, int binY, int binW, int binH, HashMap<String, String> items) {
        Random random = new Random();
        int nextItem = random.nextInt(6);

        ArrayList<String> allItems = new ArrayList<>(gm.items.icons.keySet()); // assume keys are like "waste1.png", etc.
        ArrayList<String> availableItems = new ArrayList<>();

        // exit button customization
        JButton exit = new JButton("Back to level select");
        exit.setBounds(810, 225, 210, 40);
        exit.setFocusPainted(false);
        exit.setBorderPainted(false);
        exit.setContentAreaFilled(false);

        exit.setBackground(new Color(50, 150, 255));
        exit.setForeground(Color.WHITE);
        exit.setOpaque(true);

        // congrats button customization
        JLabel congrats = new JLabel("You did it!");                    // set text
        congrats.setBounds(850, 175, 300, 30);              // set location/text space
        congrats.setFont(new Font("Cambria", Font.BOLD, 16));           // set font and text size
        congrats.setForeground(Color.WHITE);                                // set font color

        // success msg customization
        fader flex = new fader("flex on em");               // set text
        flex.setBounds(810, 150, 200, 20);      // set location
        flex.fadeOut();                                         // enable fade

        // incorrect msg customization
        fader oops = new fader("thats a whoopsie");         // set text
        oops.setBounds(810, 275, 200, 20);      // set location
        oops.fadeOut();                                             // enable fade

        gm.ui.bgPanel[gm.ui.level].add(congrats);          // add congrats msg
        gm.ui.bgPanel[gm.ui.level].add(exit);              // add exit button
        gm.ui.bgPanel[gm.ui.level].add(flex);               // add flex msg
        gm.ui.bgPanel[gm.ui.level].add(oops);               // add oops msg

        gm.ui.bgPanel[gm.ui.level].setComponentZOrder(congrats, 0);        // set congrats msg to top
        gm.ui.bgPanel[gm.ui.level].setComponentZOrder(exit, 0);            // set exit button to top
        gm.ui.bgPanel[gm.ui.level].setComponentZOrder(flex, 0);             // set flex msg to top
        gm.ui.bgPanel[gm.ui.level].setComponentZOrder(oops, 0);


        congrats.setVisible(false);
        exit.setVisible(false);
        flex.setVisible(false);
        oops.setVisible(false);

        if (wasteX + 50 > binX && wasteX < binX + binW && wasteY + 50 > binY && wasteY < binY + binH) {

            String filePath = gm.waste.icon.toString();
            String fileName = filePath.substring(filePath.lastIndexOf('/') + 1);
            // System.out.println(fileName + "\n" + items.keySet().toString());

            boolean approved = items.keySet().toString().contains(fileName);

            if (approved) {
                cor.add(fileName);
                gm.waste.wasteTitle.setVisible(false);
                gm.waste.waste.setVisible(false);

                count += 1;     // keeps track of correct answers

                if(count > 2) {  // if you get the desired amount of questions right
                    // JOptionPane.showMessageDialog(null, "yay u won buddy yippie");

                    int oldLevel = gm.ui.level;         // level screen
                    int newLevel = 1;     // level select screen

                    exit.setVisible(true);          // display exit when they get 3 right
                    congrats.setVisible(true);      // display congrats when they get 3 right

                    exit.addActionListener(e -> {
                        gm.ui.bgPanel[oldLevel].setVisible(false);      // hide current screen
                        gm.ui.level = newLevel;                         // update level tracker
                        gm.ui.window.setComponentZOrder(gm.ui.bgPanel[newLevel], 0);            // re-order components so proper panel is on top
                        gm.ui.bgPanel[newLevel].setVisible(true);               // display level select screen

                        gm.ui.bgPanel[oldLevel].add(gm.waste.wasteTitle);               // add the title to the current screen still
                        gm.ui.bgPanel[oldLevel].setComponentZOrder(gm.waste.wasteTitle, 0);         // reorder components so title is on top
                        gm.waste.wasteTitle.setVisible(true);               // display title

                        exit.setVisible(false);          // remove congrats msg
                        congrats.setVisible(false);         // remove exit button

                        gm.ui.level = oldLevel;

                        //gm.ui.window.revalidate();
                        //gm.ui.window.repaint();

                        certCheck++;

                        if (certCheck == 5) {
                            // add functionality to display the certificate and all that if they reach 5 dubs

                        }

                        cor.clear();            // clear list of correctly sorted items
                        availableItems.clear(); // clear list of available items
                        count = 0;
                    });

                } else {

                    flex.setVisible(true);

                    gm.waste.icon = new ImageIcon(getClass().getClassLoader().getResource("images/waste/waste" + (nextItem + 1) + ".png"));

                    for (String item : allItems) {
                        if (!cor.contains(item)) {
                            availableItems.add(item);
                        }
                    }

                    if (!availableItems.isEmpty()) {
                        newItem = availableItems.get(new Random().nextInt(availableItems.size()));     // update item to one not used
                        gm.waste.icon = new ImageIcon(getClass().getClassLoader().getResource("images/waste/" + newItem));
                        gm.waste.waste.setIcon(gm.waste.icon);
                        gm.waste.waste.setBounds(810, 175, gm.waste.icon.getIconWidth(), gm.waste.icon.getIconHeight());

                        // Set title
                        createTitle(gm.items.icons.get(newItem), gm.ui.level);
                        gm.waste.wasteTitle.setVisible(true);
                    } else {
                        System.out.println("you shouldn't have gotten here");
                    }


                    gm.waste.waste.setIcon(gm.waste.icon);
                    gm.waste.waste.setBounds(810, 175, gm.waste.icon.getIconWidth(), gm.waste.icon.getIconHeight());

                    gm.waste.waste.setVisible(true);

                    createTitle(gm.items.icons.get(newItem), gm.ui.level);
                    gm.waste.wasteTitle.setVisible(true);

                    gm.ui.bgPanel[gm.ui.level].setComponentZOrder(gm.waste.waste, 0);
                    gm.ui.bgPanel[gm.ui.level].setComponentZOrder(gm.waste.wasteTitle, 0);

                    gm.waste.waste.revalidate();
                    gm.waste.waste.repaint();

                    gm.waste.wasteTitle.revalidate();
                    gm.waste.wasteTitle.repaint();
                }
            } else {
                gm.waste.waste.setLocation(810, 175);
                oops.setVisible(true);
            }
        }

    }
}
