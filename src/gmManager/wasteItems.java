package gmManager;

import java.util.HashMap;

public class wasteItems {
    HashMap<String, String> cmp = new HashMap<>();
    HashMap<String, String> rcy = new HashMap<>();
    HashMap<String, String> lnd = new HashMap<>();
    HashMap<String, String> ews = new HashMap<>();
    HashMap<String, String> hrr = new HashMap<>();
    HashMap<String, String> hrs = new HashMap<>();

    gmManager gm;

    public wasteItems(gmManager gm) {
        this.gm = gm;
    }

    public void loadCMP() {
        cmp.put("waste1.png", "bananer");

    }

    public void loadRCY() {
        rcy.put("waste2.png", "monther drink");

    }

    public void loadLND() {
        lnd.put("waste3.png", "sus paper");

    }

    public void loadEWS() {
        ews.put("waste4.png", "red solo cup");;

    }

    public void loadHRS() {
        hrs.put("waste5.png", "touch grass");

    }

    public void loadHRR() {
        hrr.put("waste6.png", "cardboard bawx");
    }
}
