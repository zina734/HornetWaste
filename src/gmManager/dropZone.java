package gmManager;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class dropZone extends JPanel {

    gmManager gm;
    int correctCount;
    ArrayList<String> usedItems = new ArrayList<>();
    int currentLevelNumber;
    String currentItemPath;

    public dropZone(gmManager gm) {
        this.gm = gm;
        correctCount = 0;
    }

    public void resetLevel(int levelNum) {
        correctCount = 0;
        usedItems.clear();
        currentLevelNumber = levelNum;
    }

    public JLabel compost(int panel) {
        JLabel dropZone1 = new JLabel();
        dropZone1.setBounds(150, 650, 150, 275);
        dropZone1.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        
        JLabel compostLabel = new JLabel("COMPOST");
        compostLabel.setBounds(175, 925, 100, 30);
        compostLabel.setFont(new Font("Arial", Font.BOLD, 14));
        compostLabel.setForeground(new Color(34, 139, 34));
        gm.ui.bgPanel[panel].add(compostLabel);
        
        gm.ui.bgPanel[panel].add(dropZone1);
        return dropZone1;
    }

    public JLabel recycle(int panel) {
        JLabel dropZone1 = new JLabel();
        dropZone1.setBounds(500, 650, 150, 275);
        dropZone1.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
        
        JLabel recycleLabel = new JLabel("RECYCLE");
        recycleLabel.setBounds(525, 925, 100, 30);
        recycleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        recycleLabel.setForeground(new Color(0, 120, 215));
        gm.ui.bgPanel[panel].add(recycleLabel);
        
        gm.ui.bgPanel[panel].add(dropZone1);
        return dropZone1;
    }

    public JLabel landfill(int panel) {
        JLabel dropZone1 = new JLabel();
        dropZone1.setBounds(750, 650, 150, 275);
        dropZone1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        
        JLabel landfillLabel = new JLabel("LANDFILL");
        landfillLabel.setBounds(775, 925, 100, 30);
        landfillLabel.setFont(new Font("Arial", Font.BOLD, 14));
        landfillLabel.setForeground(Color.DARK_GRAY);
        gm.ui.bgPanel[panel].add(landfillLabel);
        
        gm.ui.bgPanel[panel].add(dropZone1);
        return dropZone1;
    }

    public JLabel eWaste(int panel) {
        JLabel dropZone1 = new JLabel();
        dropZone1.setBounds(1000, 650, 150, 275);
        dropZone1.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 2));
        
        JLabel eWasteLabel = new JLabel("E-WASTE");
        eWasteLabel.setBounds(1025, 925, 100, 30);
        eWasteLabel.setFont(new Font("Arial", Font.BOLD, 14));
        eWasteLabel.setForeground(new Color(255, 140, 0));
        gm.ui.bgPanel[panel].add(eWasteLabel);
        
        gm.ui.bgPanel[panel].add(dropZone1);
        return dropZone1;
    }

    public void createZone(JLabel bin, int binType) {
        int wasteX = gm.waste.waste.getX();
        int wasteY = gm.waste.waste.getY();
        int zoneX = bin.getX();
        int zoneY = bin.getY();
        int zoneW = bin.getWidth();
        int zoneH = bin.getHeight();

        HashMap<String, String> correctItems = null;
        
        switch (binType) {
            case 0:
                gm.items.loadCMP();
                correctItems = gm.items.cmp;
                break;
            case 1:
                gm.items.loadRCY();
                correctItems = gm.items.rcy;
                break;
            case 2:
                gm.items.loadLND();
                correctItems = gm.items.lnd;
                break;
            case 3:
                gm.items.loadEWS();
                correctItems = gm.items.ews;
                break;
        }
        
        if (correctItems != null) {
            zoneBounds(wasteX, wasteY, zoneX, zoneY, zoneW, zoneH, correctItems);
        }
    }

    public void createTitle(String name, int lvl) {
        if (gm.waste.wasteTitle == null) {
            gm.waste.wasteTitle = new JLabel(name);
            gm.waste.wasteTitle.setForeground(Color.BLACK);
            gm.waste.wasteTitle.setFont(new Font("Arial", Font.BOLD, 18));
            gm.waste.wasteTitle.setBounds(810, 100, 300, 30);
            gm.ui.bgPanel[lvl].add(gm.waste.wasteTitle);
        } else {
            gm.waste.wasteTitle.setText(name);
        }
    }

    public void zoneBounds(int wasteX, int wasteY, int binX, int binY, int binW, int binH, HashMap<String, String> correctItems) {
        
        // UI Elements - create once and reuse
        JButton exitButton = new JButton("Back to Level Select");
        exitButton.setBounds(810, 225, 210, 40);
        exitButton.setFocusPainted(false);
        exitButton.setBorderPainted(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setBackground(new Color(50, 150, 255));
        exitButton.setForeground(Color.WHITE);
        exitButton.setOpaque(true);

        JLabel levelCompleteLabel = new JLabel("Level Complete!");
        levelCompleteLabel.setBounds(850, 175, 300, 30);
        levelCompleteLabel.setFont(new Font("Cambria", Font.BOLD, 16));
        levelCompleteLabel.setForeground(Color.WHITE);

        fader successMessage = new fader("Good job!");
        successMessage.setBounds(810, 150, 200, 20);
        successMessage.fadeOut();

        fader incorrectMessage = new fader("Try again!");
        incorrectMessage.setBounds(810, 275, 200, 20);
        incorrectMessage.fadeOut();

        gm.ui.bgPanel[gm.ui.level].add(levelCompleteLabel);
        gm.ui.bgPanel[gm.ui.level].add(exitButton);
        gm.ui.bgPanel[gm.ui.level].add(successMessage);
        gm.ui.bgPanel[gm.ui.level].add(incorrectMessage);

        gm.ui.bgPanel[gm.ui.level].setComponentZOrder(levelCompleteLabel, 0);
        gm.ui.bgPanel[gm.ui.level].setComponentZOrder(exitButton, 0);
        gm.ui.bgPanel[gm.ui.level].setComponentZOrder(successMessage, 0);
        gm.ui.bgPanel[gm.ui.level].setComponentZOrder(incorrectMessage, 0);

        levelCompleteLabel.setVisible(false);
        exitButton.setVisible(false);
        successMessage.setVisible(false);
        incorrectMessage.setVisible(false);

        // Check if waste item is within drop zone bounds
        if (wasteX + 50 > binX && wasteX < binX + binW && wasteY + 50 > binY && wasteY < binY + binH) {

            String filePath = gm.waste.icon.toString();
            String fileName = filePath.substring(filePath.lastIndexOf('/') + 1);

            boolean isCorrect = correctItems.keySet().toString().contains(fileName);

            if (isCorrect) {
                // Correct answer
                usedItems.add(currentItemPath);
                gm.waste.wasteTitle.setVisible(false);
                gm.waste.waste.setVisible(false);

                correctCount++;

                if (correctCount >= 6) {
                    // Level complete!
                    int completedLevel = gm.ui.level;
                    int levelSelectScreen = 1;

                    exitButton.setVisible(true);
                    levelCompleteLabel.setVisible(true);

                    // Mark this level as completed
                    int levelNumber = completedLevel - 1;
                    gm.items.completeLevel(levelNumber);

                    exitButton.addActionListener(e -> {
                        gm.ui.bgPanel[completedLevel].setVisible(false);
                        gm.ui.level = levelSelectScreen;
                        gm.ui.window.setComponentZOrder(gm.ui.bgPanel[levelSelectScreen], 0);
                        gm.ui.bgPanel[levelSelectScreen].setVisible(true);

                        exitButton.setVisible(false);
                        levelCompleteLabel.setVisible(false);

                        // Check if all levels are completed
                        if (gm.items.allLevelsCompleted()) {
                            gm.ui.showVictoryScreen();
                        }

                        // Reset level state
                        usedItems.clear();
                        correctCount = 0;
                    });

                } else {
                    // Show success message and load next item
                    successMessage.setVisible(true);
                    
                    loadNextWasteItem();
                }
            } else {
                // Incorrect answer - reset position
                gm.waste.waste.setLocation(810, 175);
                incorrectMessage.setVisible(true);
            }
        }
    }

    private void loadNextWasteItem() {
        HashMap<String, String> levelItems = gm.items.getLevelItems(currentLevelNumber);
        ArrayList<String> availableItems = new ArrayList<>();

        for (String itemPath : levelItems.keySet()) {
            if (!usedItems.contains(itemPath)) {
                availableItems.add(itemPath);
            }
        }

        if (!availableItems.isEmpty()) {
            Random random = new Random();
            currentItemPath = availableItems.get(random.nextInt(availableItems.size()));
            
            gm.waste.icon = new ImageIcon(getClass().getClassLoader().getResource("images/waste/" + currentItemPath));
            gm.waste.waste.setIcon(gm.waste.icon);
            gm.waste.waste.setBounds(810, 175, gm.waste.icon.getIconWidth(), gm.waste.icon.getIconHeight());

            String itemName = levelItems.get(currentItemPath);
            createTitle(itemName, gm.ui.level);
            
            gm.waste.wasteTitle.setVisible(true);
            gm.waste.waste.setVisible(true);

            gm.ui.bgPanel[gm.ui.level].setComponentZOrder(gm.waste.waste, 0);
            gm.ui.bgPanel[gm.ui.level].setComponentZOrder(gm.waste.wasteTitle, 0);

            gm.waste.waste.revalidate();
            gm.waste.waste.repaint();
            gm.waste.wasteTitle.revalidate();
            gm.waste.wasteTitle.repaint();
        }
    }
}
