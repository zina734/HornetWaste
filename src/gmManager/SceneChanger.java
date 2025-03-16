package gmManager;

public class SceneChanger {
    gmManager game;

    public SceneChanger(gmManager gm) {
        this.game = game;
    }

    public void startScreen() {
        game.ui.bgPanel[1].setVisible(true);        // turn on start screen
        game.ui.bgPanel[2].setVisible(false);       // turn off level screen
    }

    public void levelScreen() {
        game.ui.bgPanel[1].setVisible(false);       // turn off start screen
        game.ui.bgPanel[2].setVisible(true);        // turn on level screen
        /*game.ui.bgPanel[3].setVisible(true);
        game.ui.bgPanel[4].setVisible(true);
        game.ui.bgPanel[5].setVisible(true);
        game.ui.bgPanel[6].setVisible(true);
        game.ui.bgPanel[7].setVisible(true);*/
    }
}
