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
        fade = new fader("Game starting...");
    }

    // Main entry point for the game
    public static void main(String[] args) {
        System.out.println("Starting Hornet Waste Sorting Game...");
        new gmManager();
    } 
}