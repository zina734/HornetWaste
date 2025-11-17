package gmManager;

import java.util.HashMap;

public class wasteItems {

    // Track which levels have been completed
    HashMap<Integer, Boolean> levelCompleted = new HashMap<>();
    
    // Maps for all waste items by level (filepath -> display name)
    HashMap<String, String> level1Items = new HashMap<>();
    HashMap<String, String> level2Items = new HashMap<>();
    HashMap<String, String> level3Items = new HashMap<>();
    HashMap<String, String> level4Items = new HashMap<>();
    HashMap<String, String> level5Items = new HashMap<>();
    
    // Maps for correct answers by bin type
    HashMap<String, String> cmp = new HashMap<>();
    HashMap<String, String> rcy = new HashMap<>();
    HashMap<String, String> lnd = new HashMap<>();
    HashMap<String, String> ews = new HashMap<>();

    gmManager gm;

    public wasteItems(gmManager gm) {
        this.gm = gm;
        initializeLevelItems();
        initializeLevelCompletion();
    }

    // Initialize level completion tracking
    private void initializeLevelCompletion() {
        for (int i = 1; i <= 5; i++) {
            levelCompleted.put(i, false);
        }
    }

    // Initialize all waste items for each level with their display names
    private void initializeLevelItems() {
        // Level 1
        level1Items.put("lvl1/comp1.png", "Apple Core");
        level1Items.put("lvl1/comp2.png", "Banana Peel");
        level1Items.put("lvl1/comp3.png", "Coffee Grounds");
        level1Items.put("lvl1/comp4.png", "Egg Shells");
        level1Items.put("lvl1/comp5.png", "Food Scraps");
        level1Items.put("lvl1/comp6.png", "Tea Bag");
        level1Items.put("lvl1/EW1.png", "Old Phone");
        level1Items.put("lvl1/EW2.png", "Broken Headphones");
        level1Items.put("lvl1/EW3.png", "Battery");
        level1Items.put("lvl1/LF1.png", "Plastic Bag");
        level1Items.put("lvl1/LF2.png", "Styrofoam");
        level1Items.put("lvl1/LF3.png", "Chip Wrapper");
        level1Items.put("lvl1/LF4.png", "Straw");
        level1Items.put("lvl1/LF5.png", "Candy Wrapper");
        level1Items.put("lvl1/LF6.png", "Disposable Cup");
        level1Items.put("lvl1/RC1.png", "Aluminum Can");
        level1Items.put("lvl1/RC2.png", "Glass Bottle");
        level1Items.put("lvl1/RC3.png", "Cardboard Box");

        // Level 2
        level2Items.put("lvl2/Comp1.png", "Vegetable Peels");
        level2Items.put("lvl2/Comp2.png", "Orange Peel");
        level2Items.put("lvl2/Comp3.png", "Bread Crust");
        level2Items.put("lvl2/Comp4.png", "Wilted Lettuce");
        level2Items.put("lvl2/Comp5.png", "Grass Clippings");
        level2Items.put("lvl2/Comp6.png", "Leaves");
        level2Items.put("lvl2/Comp7.png", "Flower Stems");
        level2Items.put("lvl2/EW1.png", "Computer Mouse");
        level2Items.put("lvl2/LF1.png", "Plastic Wrap");
        level2Items.put("lvl2/LF2.png", "Tape");
        level2Items.put("lvl2/LF3.png", "Sticker");
        level2Items.put("lvl2/RC1.png", "Water Bottle");
        level2Items.put("lvl2/RC2.png", "Newspaper");
        level2Items.put("lvl2/RC3.png", "Magazine");
        level2Items.put("lvl2/RC4.png", "Soda Can");
        level2Items.put("lvl2/RC5.png", "Tin Can");
        level2Items.put("lvl2/RC6.png", "Paper Bag");
        level2Items.put("lvl2/RC7.png", "Cereal Box");

        // Level 3
        level3Items.put("lvl3/comp1.png", "Nut Shells");
        level3Items.put("lvl3/comp2.png", "Corn Cob");
        level3Items.put("lvl3/comp3.png", "Melon Rind");
        level3Items.put("lvl3/comp4.png", "Pizza Crust");
        level3Items.put("lvl3/comp5.png", "Napkin");
        level3Items.put("lvl3/comp6.png", "Paper Towel");
        level3Items.put("lvl3/comp7.png", "Sawdust");
        level3Items.put("lvl3/comp8.png", "Wood Chips");
        level3Items.put("lvl3/EW1.png", "Old Keyboard");
        level3Items.put("lvl3/EW2.png", "USB Cable");
        level3Items.put("lvl3/LF1.png", "Plastic Utensils");
        level3Items.put("lvl3/LF2.png", "Broken Toy");
        level3Items.put("lvl3/RC1.png", "Milk Jug");
        level3Items.put("lvl3/RC2.png", "Juice Box");
        level3Items.put("lvl3/RC3.png", "Shampoo Bottle");
        level3Items.put("lvl3/RC4.png", "Office Paper");

        // Level 4
        level4Items.put("lvl4/Comp1.png", "Cucumber Peels");
        level4Items.put("lvl4/Comp2.png", "Potato Peels");
        level4Items.put("lvl4/Comp3.png", "Carrot Peels");
        level4Items.put("lvl4/Comp4.png", "Tomato");
        level4Items.put("lvl4/Comp5.png", "Onion Skin");
        level4Items.put("lvl4/Comp6.png", "Garlic Peel");
        level4Items.put("lvl4/Comp7.png", "Herbs");
        level4Items.put("lvl4/EW1.png", "Tablet");
        level4Items.put("lvl4/LF1.png", "Plastic Lid");
        level4Items.put("lvl4/LF2.png", "Food Container");
        level4Items.put("lvl4/LF3.png", "Plastic Spoon");
        level4Items.put("lvl4/LF4.png", "Rubber Band");
        level4Items.put("lvl4/LF5.png", "Glove");
        level4Items.put("lvl4/LF6.png", "Balloon");
        level4Items.put("lvl4/LF7.png", "Bubble Wrap");
        level4Items.put("lvl4/LF8.png", "Packing Peanuts");
        level4Items.put("lvl4/RC1.png", "Glass Jar");
        level4Items.put("lvl4/RC2.png", "Metal Hanger");
        level4Items.put("lvl4/RC3.png", "Paint Can");

        // Level 5
        level5Items.put("lvl5/Comp1.png", "Pumpkin Seeds");
        level5Items.put("lvl5/Comp2.png", "Berry Stems");
        level5Items.put("lvl5/Comp3.png", "Kiwi Skin");
        level5Items.put("lvl5/Comp4.png", "Mango Pit");
        level5Items.put("lvl5/Comp5.png", "Avocado Pit");
        level5Items.put("lvl5/Comp6.png", "Cherry Pits");
        level5Items.put("lvl5/LF1.png", "Cigarette Butt");
        level5Items.put("lvl5/LF2.png", "Dental Floss");
        level5Items.put("lvl5/LF3.png", "Cotton Swab");
        level5Items.put("lvl5/LF4.png", "Band Aid");
        level5Items.put("lvl5/LF5.png", "Diaper");
        level5Items.put("lvl5/LF6.png", "Hair");
        level5Items.put("lvl5/LF7.png", "Tissue");
        level5Items.put("lvl5/LF8.png", "Wax Paper");
        level5Items.put("lvl5/RC1.png", "Yogurt Container");
        level5Items.put("lvl5/RC2.png", "Aluminum Foil");
        level5Items.put("lvl5/RC3.png", "Detergent Bottle");
        level5Items.put("lvl5/RC4.png", "Envelope");
        level5Items.put("lvl5/RC5.png", "Wrapping Paper");
        level5Items.put("lvl5/RC6.png", "Notebook");
    }

    // Get all items for a specific level
    public HashMap<String, String> getLevelItems(int level) {
        switch (level) {
            case 1: return level1Items;
            case 2: return level2Items;
            case 3: return level3Items;
            case 4: return level4Items;
            case 5: return level5Items;
            default: return new HashMap<>();
        }
    }

    // Mark a level as completed
    public void completeLevel(int level) {
        if (level >= 1 && level <= 5) {
            levelCompleted.put(level, true);
        }
    }

    // Check if all levels are completed
    public boolean allLevelsCompleted() {
        for (int i = 1; i <= 5; i++) {
            if (!levelCompleted.get(i)) {
                return false;
            }
        }
        return true;
    }

    // Compost items
    public void loadCMP() {
        cmp.clear();
        cmp.put("lvl1/comp1.png", "Apple Core");
        cmp.put("lvl1/comp2.png", "Banana Peel");
        cmp.put("lvl1/comp3.png", "Coffee Grounds");
        cmp.put("lvl1/comp4.png", "Egg Shells");
        cmp.put("lvl1/comp5.png", "Food Scraps");
        cmp.put("lvl1/comp6.png", "Tea Bag");
        cmp.put("lvl2/Comp1.png", "Vegetable Peels");
        cmp.put("lvl2/Comp2.png", "Orange Peel");
        cmp.put("lvl2/Comp3.png", "Bread Crust");
        cmp.put("lvl2/Comp4.png", "Wilted Lettuce");
        cmp.put("lvl2/Comp5.png", "Grass Clippings");
        cmp.put("lvl2/Comp6.png", "Leaves");
        cmp.put("lvl2/Comp7.png", "Flower Stems");
        cmp.put("lvl3/comp1.png", "Nut Shells");
        cmp.put("lvl3/comp2.png", "Corn Cob");
        cmp.put("lvl3/comp3.png", "Melon Rind");
        cmp.put("lvl3/comp4.png", "Pizza Crust");
        cmp.put("lvl3/comp5.png", "Napkin");
        cmp.put("lvl3/comp6.png", "Paper Towel");
        cmp.put("lvl3/comp7.png", "Sawdust");
        cmp.put("lvl3/comp8.png", "Wood Chips");
        cmp.put("lvl4/Comp1.png", "Cucumber Peels");
        cmp.put("lvl4/Comp2.png", "Potato Peels");
        cmp.put("lvl4/Comp3.png", "Carrot Peels");
        cmp.put("lvl4/Comp4.png", "Tomato");
        cmp.put("lvl4/Comp5.png", "Onion Skin");
        cmp.put("lvl4/Comp6.png", "Garlic Peel");
        cmp.put("lvl4/Comp7.png", "Herbs");
        cmp.put("lvl5/Comp1.png", "Pumpkin Seeds");
        cmp.put("lvl5/Comp2.png", "Berry Stems");
        cmp.put("lvl5/Comp3.png", "Kiwi Skin");
        cmp.put("lvl5/Comp4.png", "Mango Pit");
        cmp.put("lvl5/Comp5.png", "Avocado Pit");
        cmp.put("lvl5/Comp6.png", "Cherry Pits");
    }

    // Recycle items
    public void loadRCY() {
        rcy.clear();
        rcy.put("lvl1/RC1.png", "Aluminum Can");
        rcy.put("lvl1/RC2.png", "Glass Bottle");
        rcy.put("lvl1/RC3.png", "Cardboard Box");
        rcy.put("lvl2/RC1.png", "Water Bottle");
        rcy.put("lvl2/RC2.png", "Newspaper");
        rcy.put("lvl2/RC3.png", "Magazine");
        rcy.put("lvl2/RC4.png", "Soda Can");
        rcy.put("lvl2/RC5.png", "Tin Can");
        rcy.put("lvl2/RC6.png", "Paper Bag");
        rcy.put("lvl2/RC7.png", "Cereal Box");
        rcy.put("lvl3/RC1.png", "Milk Jug");
        rcy.put("lvl3/RC2.png", "Juice Box");
        rcy.put("lvl3/RC3.png", "Shampoo Bottle");
        rcy.put("lvl3/RC4.png", "Office Paper");
        rcy.put("lvl4/RC1.png", "Glass Jar");
        rcy.put("lvl4/RC2.png", "Metal Hanger");
        rcy.put("lvl4/RC3.png", "Paint Can");
        rcy.put("lvl5/RC1.png", "Yogurt Container");
        rcy.put("lvl5/RC2.png", "Aluminum Foil");
        rcy.put("lvl5/RC3.png", "Detergent Bottle");
        rcy.put("lvl5/RC4.png", "Envelope");
        rcy.put("lvl5/RC5.png", "Wrapping Paper");
        rcy.put("lvl5/RC6.png", "Notebook");
    }

    // Landfill items
    public void loadLND() {
        lnd.clear();
        lnd.put("lvl1/LF1.png", "Plastic Bag");
        lnd.put("lvl1/LF2.png", "Styrofoam");
        lnd.put("lvl1/LF3.png", "Chip Wrapper");
        lnd.put("lvl1/LF4.png", "Straw");
        lnd.put("lvl1/LF5.png", "Candy Wrapper");
        lnd.put("lvl1/LF6.png", "Disposable Cup");
        lnd.put("lvl2/LF1.png", "Plastic Wrap");
        lnd.put("lvl2/LF2.png", "Tape");
        lnd.put("lvl2/LF3.png", "Sticker");
        lnd.put("lvl3/LF1.png", "Plastic Utensils");
        lnd.put("lvl3/LF2.png", "Broken Toy");
        lnd.put("lvl4/LF1.png", "Plastic Lid");
        lnd.put("lvl4/LF2.png", "Food Container");
        lnd.put("lvl4/LF3.png", "Plastic Spoon");
        lnd.put("lvl4/LF4.png", "Rubber Band");
        lnd.put("lvl4/LF5.png", "Glove");
        lnd.put("lvl4/LF6.png", "Balloon");
        lnd.put("lvl4/LF7.png", "Bubble Wrap");
        lnd.put("lvl4/LF8.png", "Packing Peanuts");
        lnd.put("lvl5/LF1.png", "Cigarette Butt");
        lnd.put("lvl5/LF2.png", "Dental Floss");
        lnd.put("lvl5/LF3.png", "Cotton Swab");
        lnd.put("lvl5/LF4.png", "Band Aid");
        lnd.put("lvl5/LF5.png", "Diaper");
        lnd.put("lvl5/LF6.png", "Hair");
        lnd.put("lvl5/LF7.png", "Tissue");
        lnd.put("lvl5/LF8.png", "Wax Paper");
    }

    // E-waste items
    public void loadEWS() {
        ews.clear();
        ews.put("lvl1/EW1.png", "Old Phone");
        ews.put("lvl1/EW2.png", "Broken Headphones");
        ews.put("lvl1/EW3.png", "Battery");
        ews.put("lvl2/EW1.png", "Computer Mouse");
        ews.put("lvl3/EW1.png", "Old Keyboard");
        ews.put("lvl3/EW2.png", "USB Cable");
        ews.put("lvl4/EW1.png", "Tablet");
    }
}
