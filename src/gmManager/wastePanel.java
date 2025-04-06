package gmManager;


import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class wastePanel extends JPanel {

    ImageIcon waste = new ImageIcon("images/waste1.png"); // Load image from file

    final int IMG_WIDTH = waste.getIconWidth();  // Get image width (not used here but available)
    final int IMG_Height = waste.getIconHeight(); // Get image height

    Point image_corner;     // Stores current top-left position of the image
    Point previousPoint;    // Stores previous mouse position during drag

    wastePanel() {
        image_corner = new Point(0, 0); // Start image at (0, 0)

        // Listen for initial mouse press (stores starting point for drag)
        this.addMouseListener(new ClickListener());

        // Listen for dragging movement (updates image position)
        this.addMouseMotionListener(new DragListener());
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g); // Clear and prep panel for painting
        // Draw the image at its current position
        waste.paintIcon(this, g, (int) image_corner.getX(), (int) image_corner.getY());
    }

    private class ClickListener extends MouseAdapter {
        public void mousePressed(MouseEvent evt) {
            previousPoint = evt.getPoint(); // Save where the mouse was clicked
        }
    }

    private class DragListener extends MouseMotionAdapter {
        public void mouseDragged(MouseEvent evt) {
            Point currentPoint = evt.getPoint(); // Get mouse's new position

            // Move image by difference between current and previous positions
            image_corner.translate(
                    (int)(currentPoint.getX() - previousPoint.getX()),
                    (int)(currentPoint.getY() - previousPoint.getY())
            );

            previousPoint = currentPoint; // Update for next drag
            repaint(); // Redraw panel with image in new position
        }
    }


}
