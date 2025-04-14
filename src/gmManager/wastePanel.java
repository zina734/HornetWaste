package gmManager;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;

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
        waste.setBounds(0, 0, 1112, 624);
        waste.setIcon(icon);
        gm.ui.bgPanel[lvlScreen].add(waste);
        waste.revalidate();
        waste.repaint();
         /* gm.ui.bgLabel[lvlScreen] = new JLabel();
        gm.ui.bgLabel[lvlScreen].setBounds(0, 0, 1112, 624);
        gm.ui.bgLabel[lvlScreen].setIcon(icon);
        gm.ui.bgPanel[lvlScreen].add(gm.ui.bgLabel[lvlScreen]);
        gm.ui.bgPanel[lvlScreen].revalidate();
        gm.ui.bgPanel[lvlScreen].repaint(); */

        waste.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                initialClick = e.getPoint();
            }
        });

        waste.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                int posX = waste.getLocation().x;
                int posY = waste.getLocation().y;
                int moveX = e.getX() - initialClick.x;
                int moveY = e.getY() - initialClick.y;
                waste.setLocation(posX + moveX, posY + moveY);
            }
        });
    }

}
