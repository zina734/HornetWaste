package gmManager;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.Point;
import java.util.HashMap;
import java.awt.Color;
import java.awt.Component;

import javax.swing.*;

public class wastePanel extends JPanel {

    ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("images/waste/lvl1/RC3.png")); // Load image from file
    public JLabel waste;
    public JLabel wasteTitle;
    public Point initialClick;

    gmManager gm;           // important

    public wastePanel(gmManager gm) {
        this.gm = gm;

    }

    public void imgLaunch(int lvlScreen) {
        if (waste != null && waste.getParent() != null) {
            waste.getParent().remove(waste);
         }
        waste = new JLabel();

        int imgW = icon.getIconWidth();
        int imgH = icon.getIconHeight();
        String wasteName = icon.toString();
        String name = wasteName.substring(wasteName.lastIndexOf('/') + 1);
        String key = gm.items.icons.get(name);


        gm.drop.createTitle(key, gm.ui.level);
        wasteTitle.setBounds(810, 100, imgW, imgH);
        gm.ui.bgPanel[lvlScreen].add(wasteTitle);
        gm.ui.bgPanel[gm.ui.level].setComponentZOrder(wasteTitle, 0);

        waste.setBounds(810, 175, imgW, imgH);
        gm.ui.bgPanel[lvlScreen].add(waste);
        waste.setIcon(icon);
        gm.ui.bgPanel[gm.ui.level].setComponentZOrder(waste, 0);

        JLabel compost = gm.drop.compost(lvlScreen);
        JLabel recycle = gm.drop.recycle(lvlScreen);
        JLabel landfill = gm.drop.landfill(lvlScreen);
        JLabel eWaste = gm.drop.drop1(lvlScreen);

        waste.revalidate();
        waste.repaint();

        wasteTitle.revalidate();;
        wasteTitle.repaint();

        waste.addMouseListener(new MouseAdapter() {         // enables you to click on the object
            public void mousePressed(MouseEvent e) {
                initialClick = e.getPoint();  // Always allow drag inside image bounds
            }

            public void mouseReleased(MouseEvent e) {
                initialClick = null;
            }
        });

        waste.addMouseMotionListener(new MouseMotionAdapter() {         // enables dragging and dropping functionality
            public void mouseDragged(MouseEvent e) {
                JComponent parent = (JComponent)waste.getParent();

                int posX = waste.getX();
                int posY = waste.getY();
                int moveX = e.getX() - initialClick.x;
                int moveY = e.getY() - initialClick.y;

                int newX = posX + moveX;
                int newY = posY + moveY;

                int pWidth = parent.getWidth();
                int pHeight = parent.getHeight();

                newX = Math.max(0, Math.min(newX, pWidth - waste.getWidth()));
                newY = Math.max(0, Math.min(newY, pHeight - waste.getHeight()));

                waste.setLocation(newX, newY);

            }
        });

        waste.addMouseListener(new MouseAdapter() {             // creates drop zones
            @Override

            // create class or method that has the logic of the mouseReleased() method
            // call that method 5 times to get 5 zones
            public void mouseReleased(MouseEvent e) {

                gm.drop.createZone(compost, 0);
                gm.drop.createZone(recycle, 1);
                gm.drop.createZone(landfill, 2);
                gm.drop.createZone(eWaste, 3);
            }

        });
    }

}
