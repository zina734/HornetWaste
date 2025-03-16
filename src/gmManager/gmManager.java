package gmManager;

public class gmManager {

    ActionHandler handler = new ActionHandler(this);
    UI ui = new UI(this);
    // instantiate the UI
    public static void main(String[] args) {
        System.out.println("Hello, World! itz zina");       // super duper dumdum comment
        new gmManager();                                     // start the game
    }

}