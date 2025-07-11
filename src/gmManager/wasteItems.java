package gmManager;

import java.util.HashMap;

public class wasteItems {

    // to check if every level is complete use this logic::
    // option 1: have a different list of available items for each level
    // use a hashmap with 5 values that will update the value from 0 to 1 if its complete and the key can be the name of the arraylist full of items for each respective level
    // option 2: use a different unique identifier for each level and update that shii
    // you can just have a hashmap with 5 values and assign an arbitrary variable name to each level that you can use to compare with the "completed levels" hashmap
    // final step:
    // to check if each level has been complete you can iterate through the hashmap values and see if anything is still set to 0, if theyre all not 0 then you can assume the levels have been finished and display the certificate

    HashMap<String, String> icons = new HashMap<>() {{
        put("waste1.png", "bananer");
        put("waste2.png", "monther drink");
        put("waste3.png", "sus paper");
        put("waste4.png", "red solo cup");
        put("waste5.png", "touch grass");
        put("waste6.png", "cardboard bawx");
    }};

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
        ews.put("waste4.png", "red solo cup");

    }

    public void loadHRS() {
        hrs.put("waste5.png", "touch grass");

    }

    public void loadHRR() {
        hrr.put("waste6.png", "cardboard bawx");
    }
}
