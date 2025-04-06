package gmManager;

public class gmManager {

    ActionHandler handler = new ActionHandler(this);        // actionhandler
    public UI ui = new UI(this);
    public SceneChanger sceneSwap = new SceneChanger(this);


    // instantiate the UI
    public static void main(String[] args) {
        System.out.println("Hello, World! itz zina");       // super duper dumdum comment
        new gmManager();                                     // start the game
    }

}