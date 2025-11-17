package gmManager;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import javax.swing.*;

public class wastePanel extends JPanel {

    public ImageIcon icon;
    public JLabel waste;
    public JLabel wasteTitle;
    public Point initialClick;
    gmManager gm;
    int currentLevelNumber;

    public wastePanel(gmManager gm) {
        this.gm = gm;
    }

    public void imgLaunch(int lvlScreen) {
        // Calculate level number from screen index (screens 2-6 are levels 1-5)
        currentLevelNumber = lvlScreen - 1;
        
        // Reset the dropZone for this level
        gm.drop.resetLevel(currentLevelNumber);
        
        // Get the items for this level
        HashMap<String, String> levelItems = gm.items.getLevelItems(currentLevelNumber);
        
        if (levelItems.isEmpty()) {
            System.out.println("No items found for level " + currentLevelNumber);
            return;
        }
        
        // Select a random item from this level
        ArrayList<String> itemPaths = new ArrayList<>(levelItems.keySet());
        Random random = new Random();
        String selectedItemPath = itemPaths.get(random.nextInt(itemPaths.size()));
        String itemName = levelItems.get(selectedItemPath);
        
        // Store the selected item in dropZone
        gm.drop.currentItemPath = selectedItemPath;
        gm.drop.usedItems.add(selectedItemPath);
        
        // Load the image
        icon = new ImageIcon(getClass().getClassLoader().getResource("images/waste/" + selectedItemPath));

        // Clean up old waste label if it exists
        if (waste != null && waste.getParent() != null) {
            waste.getParent().remove(waste);
        }
        
        waste = new JLabel();
        int imgW = icon.getIconWidth();
        int imgH = icon.getIconHeight();

        // Create and position the title
        gm.drop.createTitle(itemName, gm.ui.level);
        wasteTitle.setBounds(810, 100, 300, 30);
        gm.ui.bgPanel[lvlScreen].add(wasteTitle);
        gm.ui.bgPanel[gm.ui.level].setComponentZOrder(wasteTitle, 0);

        // Position and add the waste item image
        waste.setBounds(810, 175, imgW, imgH);
        gm.ui.bgPanel[lvlScreen].add(waste);
        waste.setIcon(icon);
        gm.ui.bgPanel[gm.ui.level].setComponentZOrder(waste, 0);

        // Create drop zones
        JLabel compost = gm.drop.compost(lvlScreen);
        JLabel recycle = gm.drop.recycle(lvlScreen);
        JLabel landfill = gm.drop.landfill(lvlScreen);
        JLabel eWaste = gm.drop.eWaste(lvlScreen);

        waste.revalidate();
        waste.repaint();
        wasteTitle.revalidate();
        wasteTitle.repaint();

        // Mouse listener for clicking on the waste item
        waste.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                initialClick = e.getPoint();
            }

            public void mouseReleased(MouseEvent e) {
                initialClick = null;
                
                // Check each drop zone when mouse is released
                gm.drop.createZone(compost, 0);
                gm.drop.createZone(recycle, 1);
                gm.drop.createZone(landfill, 2);
                gm.drop.createZone(eWaste, 3);
            }
        });

        // Mouse motion listener for dragging
        waste.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                JComponent parent = (JComponent) waste.getParent();

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
    }
}

