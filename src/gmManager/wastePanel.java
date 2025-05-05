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

    ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("images/waste/waste1.png")); // Load image from file
    public JLabel waste;
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

        waste.setBounds(810, 175, imgW, imgH);
        waste.setIcon(icon);
        gm.ui.bgPanel[lvlScreen].add(waste);
        gm.resizer.registerOriginalBounds(waste);

        JLabel compost = gm.drop.compost(lvlScreen);
        JLabel recycle = gm.drop.recycle(lvlScreen);
        JLabel landfill = gm.drop.landfill(lvlScreen);
        JLabel drop1 = gm.drop.drop1(lvlScreen);
        JLabel drop2 = gm.drop.drop2(lvlScreen);
        JLabel drop3 = gm.drop.drop3(lvlScreen);

        waste.revalidate();
        waste.repaint();

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
                gm.drop.createZone(drop1, 3);
                gm.drop.createZone(drop2, 4);
                gm.drop.createZone(drop3, 5);
            }

        });
    }

}
