package gmManager;

public class gmManager {

    public dropZone drop;
    public wastePanel waste;
    public UI ui;
    public wasteItems items;
    public fader fade;

    public gmManager() {

        items = new wasteItems(this);
        waste = new wastePanel(this);
        drop = new dropZone(this);
        ui = new UI(this);
        fade = new fader("meow");

    }

    // instantiate the UI
    public static void main(String[] args) {
        System.out.println("Hello, World! itz zina");       // super duper dumdum comment
        new gmManager();                                     // start the game

    }

}