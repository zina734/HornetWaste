package gmManager;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.Point;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;

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

        waste.setBounds(450, 175, imgW, imgH);
        waste.setIcon(icon);
        gm.ui.bgPanel[lvlScreen].add(waste);

        JLabel compost = gm.drop.compost(lvlScreen);
        JLabel recycle = gm.drop.recycle(lvlScreen);
        JLabel landfill = gm.drop.landfill(lvlScreen);
        JLabel drop1 = gm.drop.drop1(lvlScreen);
        JLabel drop2 = gm.drop.drop2(lvlScreen);

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
                int posX = waste.getLocation().x;
                int posY = waste.getLocation().y;
                int moveX = e.getX() - initialClick.x;
                int moveY = e.getY() - initialClick.y;
                waste.setLocation(posX + moveX, posY + moveY);
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
            }

        });
    }

}
