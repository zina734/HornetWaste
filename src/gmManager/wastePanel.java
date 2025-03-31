package gmManager;


import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class wastePanel extends JPanel {

    ImageIcon waste = new ImageIcon("images/waste1.png");

    final int IMG_WIDTH = waste.getIconWidth();
    final int IMG_Height = waste.getIconHeight();

    Point image_corner;
    Point previousPoint;

    wastePanel(){
        image_corner = new Point(0,0);

        ClickListener clicklistener = new ClickListener();
        this.addMouseListener(clicklistener);

        DragListener dragListener = new DragListener();
        this.addMouseMotionListener(dragListener);

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        waste.paintIcon(this, g, (int)image_corner.getX(), (int)image_corner.getY());
    }

    private class ClickListener extends MouseAdapter{

        public void mousePressed(MouseEvent evt){
            previousPoint = evt.getPoint();
        }
    }

    private class DragListener extends MouseMotionAdapter{

        public void mouseDragged(MouseEvent evt){

            Point currentPoint = evt.getPoint();  //update the current point of waste

            image_corner.translate((int)(currentPoint.getX() - previousPoint.getX()), //changes the position of the waste when its dragged
                    (int)(currentPoint.getY() - previousPoint.getY()));

            previousPoint = currentPoint;
            repaint();
        }
    }


}
