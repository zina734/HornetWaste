package gmManager;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class resizer {
    gmManager gm;
    int origSizeWidth;
    int origSizeHeight;
    Map<JLabel, Rectangle> originalBounds = new HashMap<>();
    Map<JLabel, ImageIcon> originalIcons = new HashMap<>();


    private boolean fastResizeMode = true;

    public resizer(gmManager gm) {
        this.gm = gm;
    }

    // Call this whenever a component is first added
    public void registerOriginalBounds(JLabel label) {
        if (!originalBounds.containsKey(label)) {
            originalBounds.put(label, label.getBounds());
            if (label.getIcon() instanceof ImageIcon icon) {
                originalIcons.put(label, icon); // Store original icon for scaling
            }
        }
    }

    public void setFastResizeMode(boolean fast) {
        this.fastResizeMode = fast;
    }

    public void resizeAll(int newWindowWidth, int newWindowHeight) {
        float scaleX = newWindowWidth / 1920f;
        float scaleY = newWindowHeight / 1080f;

        for (int i = 0; i < gm.ui.bgPanel.length; i++) {
            JPanel panel = gm.ui.bgPanel[i];
            if (panel != null) {
                panel.setBounds(0, 0, newWindowWidth, newWindowHeight);
                for (Component comp : panel.getComponents()) {
                    if (comp instanceof JLabel label && originalBounds.containsKey(label)) {
                        Rectangle original = originalBounds.get(label);

                        int newX = Math.round(original.x * scaleX);
                        int newY = Math.round(original.y * scaleY);
                        int newW = Math.round(original.width * scaleX);
                        int newH = Math.round(original.height * scaleY);

                        label.setBounds(newX, newY, newW, newH);

                        if (originalIcons.containsKey(label)) {
                            Image originalImage = originalIcons.get(label).getImage();
                            int hint = fastResizeMode ? Image.SCALE_FAST : Image.SCALE_SMOOTH;
                            Image scaledImg = originalImage.getScaledInstance(newW, newH, hint);
                            label.setIcon(new ImageIcon(scaledImg));
                        }
                    }
                }
            }
        }
    }
}
