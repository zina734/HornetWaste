package gmManager;

public class gmManager {

    public ActionHandler handler;        // actionhandler
    public wastePanel waste;
    public UI ui;
    public SceneChanger sceneSwap;


    public gmManager() {


        waste = new wastePanel(this);
        ui = new UI(this);
        handler = new ActionHandler(this);
        sceneSwap = new SceneChanger(this);

    }

    // instantiate the UI
    public static void main(String[] args) {
        System.out.println("Hello, World! itz zina");       // super duper dumdum comment
        new gmManager();                                     // start the game

    }

}