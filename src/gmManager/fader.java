package gmManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A JLabel that displays text with a fade-out animation effect.
 */
public class fader extends JLabel {
    private float alpha = 0.75f;

    public fader(String text) {
        super(text);
        setForeground(new Color(255, 255, 255, 255));
        setFont(new Font("Arial", Font.BOLD, 16));
    }

    /**
     * Starts the fade-out animation for this label.
     */
    public void fadeOut() {
        Timer timer = new Timer(50, null);
        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alpha -= 0.05f;
                if (alpha <= 0) {
                    alpha = 0;
                    timer.stop();
                    setVisible(false);
                }
                repaint();
            }
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        g2.setColor(getForeground());
        g2.setFont(getFont());
        g2.drawString(getText(), 0, getHeight() - 10);
        g2.dispose();
    }
}

