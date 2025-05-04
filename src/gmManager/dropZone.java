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

public class dropZone extends JPanel {
    public final String[] approvedItems[] = {
            {"images/waste/waste1.png"},
            {"images/waste/waste2.png"},
            {"images/waste/waste3.png"},
            {"images/waste/waste4.png"},
            {"images/waste/waste5.png"}
    };

    gmManager gm;

    public dropZone(gmManager gm) {
        this.gm = gm;

    }

    public JLabel compost(int panel) {
        JLabel dropZone1 = new JLabel();
        dropZone1.setBounds(150, 350, 100, 200);         // location for area object should be dropped to
        dropZone1.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        gm.ui.bgPanel[panel].add(dropZone1);
        gm.resizer.registerOriginalBounds(dropZone1);                  // <--- Add this line
        return dropZone1;

    }

    public JLabel recycle(int panel) {
        JLabel dropZone1 = new JLabel();
        dropZone1.setBounds(300, 350, 100, 200);         // location for area object should be dropped to
        dropZone1.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        gm.ui.bgPanel[panel].add(dropZone1);
        gm.resizer.registerOriginalBounds(dropZone1);                  // <--- Add this line
        return dropZone1;

    }

    public JLabel landfill(int panel) {
        JLabel dropZone1 = new JLabel();
        dropZone1.setBounds(450, 350, 100, 200);         // location for area object should be dropped to
        dropZone1.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        gm.ui.bgPanel[panel].add(dropZone1);
        gm.resizer.registerOriginalBounds(dropZone1);                  // <--- Add this line
        return dropZone1;

    }

    public JLabel drop1(int panel) {                // ppm surplus
        JLabel dropZone1 = new JLabel();
        dropZone1.setBounds(600, 350, 100, 200);         // location for area object should be dropped to
        dropZone1.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        gm.ui.bgPanel[panel].add(dropZone1);
        gm.resizer.registerOriginalBounds(dropZone1);                  // <--- Add this line
        return dropZone1;

    }

    public JLabel drop2(int panel) {                // the 5th one
        JLabel dropZone1 = new JLabel();
        dropZone1.setBounds(750, 350, 100, 200);         // location for area object should be dropped to
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

        Random random = new Random();
        int nextItem = random.nextInt(5);

        if (wasteX + 50 > zoneX && wasteX < zoneX + zoneW && wasteY + 50 > zoneY && wasteY < zoneY + zoneH) {
            String filename = gm.waste.icon.toString();
            boolean approved = false;

            for (String item : approvedItems[list]) {
                if (filename.contains(item)) {
                    approved = true;
                    break;
                }
            }

            if (approved) {
                gm.waste.waste.setVisible(false);
                JOptionPane.showMessageDialog(null, "Good job monkey u did it");
                // load another item here

                gm.waste.icon = new ImageIcon(getClass().getClassLoader().getResource("images/waste/waste" + (nextItem + 1) + ".png"));
                gm.waste.waste.setIcon(gm.waste.icon);
                gm.waste.waste.setLocation(450, 175);
                gm.waste.waste.setVisible(true);

            } else {
                gm.waste.waste.setLocation(450, 175);
                JOptionPane.showMessageDialog(null, "try again bozo");
            }
        }

    }
}
