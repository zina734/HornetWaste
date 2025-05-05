package gmManager;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.Point;
import java.awt.Color;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;

import java.util.HashMap;

public class dropZone extends JPanel {


    public final String[] approvedItems[] = {
            {"images/waste/waste1.png"},
            {"images/waste/waste2.png"},
            {"images/waste/waste3.png"},
            {"images/waste/waste4.png"},
            {"images/waste/waste5.png"},
            {"images/waste/waste6.png"}
    };

    /* public final String[] landfillItems[] = {
            {"images/waste/waste1.png"},
            {"images/waste/waste2.png"},
            {"images/waste/waste3.png"},
            {"images/waste/waste4.png"},
            {"images/waste/waste5.png"},
            {"images/waste/waste6.png"}
    }; */

    gmManager gm;

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

    public void zoneBounds(int wasteX, int wasteY, int binX, int binY, int binW, int binH, HashMap<String, String> items) {
        Random random = new Random();
        int nextItem = random.nextInt(6);


        if (wasteX + 50 > binX && wasteX < binX + binW && wasteY + 50 > binY && wasteY < binY + binH) {
            String filePath = gm.waste.icon.toString();
            String fileName = filePath.substring(filePath.lastIndexOf('/') + 1);
            System.out.println(fileName + "\n" + items.keySet().toString());

            boolean approved = items.keySet().toString().contains(fileName);

            if (approved) {
                gm.waste.waste.setVisible(false);
                JOptionPane.showMessageDialog(null, "Good job monkey u did it");
                // load another item here

                gm.waste.icon = new ImageIcon(getClass().getClassLoader().getResource("images/waste/waste" + (nextItem + 1) + ".png"));
                gm.waste.waste.setIcon(gm.waste.icon);
                gm.waste.waste.setLocation(810, 175);
                gm.waste.waste.setVisible(true);

            } else {
                gm.waste.waste.setLocation(810, 175);
                JOptionPane.showMessageDialog(null, "try again bozo");
            }
        }

    }
}
