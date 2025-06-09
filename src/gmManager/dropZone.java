package gmManager;

import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;

import java.util.HashMap;

public class dropZone extends JPanel {

    gmManager gm;
    int count;

    public dropZone(gmManager gm) {
        this.gm = gm;

    }

    public JLabel compost(int panel) {
        JLabel dropZone1 = new JLabel();
        dropZone1.setBounds(150, 650, 150, 275);         // location for area object should be dropped to
        dropZone1.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        gm.ui.bgPanel[panel].add(dropZone1);
        gm.resizer.registerOriginalBounds(dropZone1);                  // <--- Add this line
        return dropZone1;

    }

    public JLabel recycle(int panel) {
        JLabel dropZone1 = new JLabel();
        dropZone1.setBounds(500, 650, 150, 275);         // location for area object should be dropped to
        dropZone1.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        gm.ui.bgPanel[panel].add(dropZone1);
        gm.resizer.registerOriginalBounds(dropZone1);                  // <--- Add this line
        return dropZone1;

    }

    public JLabel landfill(int panel) {
        JLabel dropZone1 = new JLabel();
        dropZone1.setBounds(750, 650, 150, 275);         // location for area object should be dropped to
        dropZone1.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        gm.ui.bgPanel[panel].add(dropZone1);
        gm.resizer.registerOriginalBounds(dropZone1);                  // <--- Add this line
        return dropZone1;

    }

    public JLabel drop1(int panel) {                // ppm surplus
        JLabel dropZone1 = new JLabel();
        dropZone1.setBounds(1000, 650, 150, 275);         // location for area object should be dropped to
        dropZone1.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        gm.ui.bgPanel[panel].add(dropZone1);
        gm.resizer.registerOriginalBounds(dropZone1);                  // <--- Add this line
        return dropZone1;

    }

    public JLabel drop2(int panel) {                // the 5th one
        JLabel dropZone1 = new JLabel();
        dropZone1.setBounds(1250, 650, 150, 275);         // location for area object should be dropped to
        dropZone1.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        gm.ui.bgPanel[panel].add(dropZone1);
        gm.resizer.registerOriginalBounds(dropZone1);                  // <--- Add this line
        return dropZone1;
    }

    public JLabel drop3(int panel) {                // the 5th one
        JLabel dropZone1 = new JLabel();
        dropZone1.setBounds(1450, 650, 150, 275);         // location for area object should be dropped to
        dropZone1.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        gm.ui.bgPanel[panel].add(dropZone1);
        gm.resizer.registerOriginalBounds(dropZone1);                  // <--- Add this line
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



        if (wasteX + 50 > binX && wasteX < binX + binW && wasteY + 50 > binY && wasteY < binY + binH) {

            String filePath = gm.waste.icon.toString();
            String fileName = filePath.substring(filePath.lastIndexOf('/') + 1);
            System.out.println(fileName + "\n" + items.keySet().toString());

            boolean approved = items.keySet().toString().contains(fileName);
            boolean fastResize = true;


            if (approved) {
                gm.waste.wasteTitle.setVisible(false);
                gm.waste.waste.setVisible(false);

                count += 1;     // keeps track of correct answers

                if(count > 2) {  // if you get the desired amount of questions right
                    JOptionPane.showMessageDialog(null, "yay u won buddy yippie");

                    int oldLevel = gm.ui.level;         // level screen
                    int newLevel = gm.ui.level - 1;     // level select screen

                    gm.ui.bgPanel[oldLevel].setVisible(false);      // hide current screen
                    gm.ui.level = newLevel;                         // update level tracker
                    gm.ui.window.setComponentZOrder(gm.ui.bgPanel[newLevel], 0);            // re-order components so proper panel is on top
                    gm.ui.bgPanel[newLevel].setVisible(true);               // display level select screen

                    gm.ui.bgPanel[oldLevel].add(gm.waste.wasteTitle);               // add the title to the current screen still
                    gm.resizer.registerOriginalBounds(gm.waste.wasteTitle);             // register the bounds (for resizing purposes)
                    gm.ui.bgPanel[oldLevel].setComponentZOrder(gm.waste.wasteTitle, 0);         // reorder components so title is on top
                    gm.waste.wasteTitle.setVisible(true);               // display title

                    gm.ui.window.revalidate();
                    gm.ui.window.repaint();

                    count = 0;
                } else {

                    JOptionPane.showMessageDialog(null, "Good job monkey u did it");

                    gm.waste.icon = new ImageIcon(getClass().getClassLoader().getResource("images/waste/waste" + (nextItem + 1) + ".png"));
                    gm.waste.waste.setIcon(gm.waste.icon);
                    //gm.waste.waste.setBounds(810, 175, gm.waste.icon.getIconWidth(), gm.waste.icon.getIconHeight());

                    int origWindowW = gm.resizer.origSizeWidth;
                    int origWindowH = gm.resizer.origSizeHeight;
                    int curW = gm.ui.window.getWidth();
                    int curH = gm.ui.window.getHeight();
                    float scaleX = (float) curW / origWindowW;
                    float scaleY = (float) curH / origWindowH;

                    int scaledX = Math.round(810 * scaleX);
                    int scaledY = Math.round(175 * scaleY);

                    gm.waste.waste.setLocation(scaledX, scaledY);

                    gm.waste.waste.setVisible(true);

                    createTitle(gm.items.icons.get("waste" + (nextItem + 1) + ".png"), gm.ui.level);
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
                JOptionPane.showMessageDialog(null, "try again bozo");
            }
        }

    }
}
