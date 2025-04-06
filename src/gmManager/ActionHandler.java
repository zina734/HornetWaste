package gmManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener {

    gmManager gm;

    public ActionHandler(gmManager gm) {
        this.gm = gm;
    }

   // @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand(); // Get the action command (button name or identifier)

        switch(action) {
            case "startScreen":
                gm.sceneSwap.startScreen(); // Switch to the start screen
                break;

            case "levelScreen":
                gm.sceneSwap.levelScreen(); // Switch to the level selection screen
                break;
        }
        }
    }
