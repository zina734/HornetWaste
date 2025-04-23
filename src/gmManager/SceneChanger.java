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
    }

    public void levelOne() {
        game.ui.bgPanel[2].setVisible(false);       // turn off start screen
        game.ui.bgPanel[3].setVisible(true);        // turn on level one screen
    }
}
