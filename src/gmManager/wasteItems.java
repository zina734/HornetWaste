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
        level1Items.put("lvl1/comp1.png", "Flowers");
        level1Items.put("lvl1/comp2.png", "Apple Core");
        level1Items.put("lvl1/comp3.png", "Banana Peel");
        level1Items.put("lvl1/comp4.png", "Tea Bag");
        level1Items.put("lvl1/comp5.png", "Leaves");
        level1Items.put("lvl1/comp6.png", "Bundle of Sticks");
        level1Items.put("lvl1/EW1.png", "Broken Electronics");
        level1Items.put("lvl1/EW2.png", "Wires");
        level1Items.put("lvl1/EW3.png", "Light Bulb");
        level1Items.put("lvl1/LF1.png", "Plastic Bag");
        level1Items.put("lvl1/LF2.png", "Drink");
        level1Items.put("lvl1/LF3.png", "Toothpaste");
        level1Items.put("lvl1/LF4.png", "Latex Gloves");
        level1Items.put("lvl1/LF5.png", "Mask");
        level1Items.put("lvl1/LF6.png", "Broken Cup");
        level1Items.put("lvl1/RC1.png", "Fabric Softener Bottle");
        level1Items.put("lvl1/RC2.png", "News Paper");
        level1Items.put("lvl1/RC3.png", "Milk Carton");

        // Level 2
        level2Items.put("lvl2/Comp1.png", "Egg Shell");
        level2Items.put("lvl2/Comp2.png", "Pizza Slice");
        level2Items.put("lvl2/Comp3.png", "Chicken Bone");
        level2Items.put("lvl2/Comp4.png", "Coffee Grounds");
        level2Items.put("lvl2/Comp5.png", "Cardboard Container");
        level2Items.put("lvl2/Comp6.png", "Wooden Utensils");
        level2Items.put("lvl2/Comp7.png", "Meat");
        level2Items.put("lvl2/EW1.png", "Batteries");
        level2Items.put("lvl2/LF1.png", "Plastic Straw");
        level2Items.put("lvl2/LF2.png", "Candy Wrapper");
        level2Items.put("lvl2/LF3.png", "Ceramic Bowl");
        level2Items.put("lvl2/RC1.png", "Water Bottle");
        level2Items.put("lvl2/RC2.png", "Soda Can");
        level2Items.put("lvl2/RC3.png", "Tomato Can");
        level2Items.put("lvl2/RC4.png", "Food Can");
        level2Items.put("lvl2/RC5.png", "Soda Cans");
        level2Items.put("lvl2/RC6.png", "Sardine Can");
        level2Items.put("lvl2/RC7.png", "Cardboard Box");

        // Level 3
        level3Items.put("lvl3/comp1.png", "Paper + Envelope");
        level3Items.put("lvl3/comp2.png", "Fries");
        level3Items.put("lvl3/comp3.png", "Popcorn");
        level3Items.put("lvl3/comp4.png", "Moldy Cheese");
        level3Items.put("lvl3/comp5.png", "Cardboard Drink Carrier");
        level3Items.put("lvl3/comp6.png", "Cardboard Box and Bag");
        level3Items.put("lvl3/comp7.png", "Cardboard Take-out Box");
        level3Items.put("lvl3/comp8.png", "Toothpicks");
        level3Items.put("lvl3/EW1.png", "Batteries");
        level3Items.put("lvl3/EW2.png", "Game Controller");
        level3Items.put("lvl3/LF1.png", "Glass Jars/Bottles");
        level3Items.put("lvl3/LF2.png", "Chip Bag");
        level3Items.put("lvl3/RC1.png", "Water Bottle");
        level3Items.put("lvl3/RC2.png", "Book");
        level3Items.put("lvl3/RC3.png", "Paper Bag");
        level3Items.put("lvl3/RC4.png", "Napkin");

        // Level 4
        level4Items.put("lvl4/Comp1.png", "Old Notebook");
        level4Items.put("lvl4/Comp2.png", "Fish Bone");
        level4Items.put("lvl4/Comp3.png", "Paper Bag");
        level4Items.put("lvl4/Comp4.png", "Coffee Filters");
        level4Items.put("lvl4/Comp5.png", "Pizza Slice");
        level4Items.put("lvl4/Comp6.png", "Shreded Paper");
        level4Items.put("lvl4/Comp7.png", "Pizza Box");
        level4Items.put("lvl4/EW1.png", "DVD");
        level4Items.put("lvl4/LF1.png", "Plastic Straw");
        level4Items.put("lvl4/LF2.png", "Plastic Bag");
        level4Items.put("lvl4/LF3.png", "Juice Box");
        level4Items.put("lvl4/LF4.png", "Candy Wrapper");
        level4Items.put("lvl4/LF5.png", "Plastic Utensils");
        level4Items.put("lvl4/LF6.png", "Milk");
        level4Items.put("lvl4/LF7.png", "Styrofoam Cup");
        level4Items.put("lvl4/LF8.png", "Styrofoam Egg Carton");
        level4Items.put("lvl4/RC1.png", "Blue Solo Cup");
        level4Items.put("lvl4/RC2.png", "Plastic Container");
        level4Items.put("lvl4/RC3.png", "Aluminium Food Tray");

        // Level 5
        level5Items.put("lvl5/Comp1.png", "Paper Towel");
        level5Items.put("lvl5/Comp2.png", "Tissue");
        level5Items.put("lvl5/Comp3.png", "Cardboard Tray");
        level5Items.put("lvl5/Comp4.png", "Cardboard Container");
        level5Items.put("lvl5/Comp5.png", "Travel Magazine");
        level5Items.put("lvl5/Comp6.png", "Old Exams");
        level5Items.put("lvl5/LF1.png", "Plastic Container (RSC that goes in landfill)");
        level5Items.put("lvl5/LF2.png", "Styrofoam Carton");
        level5Items.put("lvl5/LF3.png", "Snack Bag");
        level5Items.put("lvl5/LF4.png", "Bubble Wrap");
        level5Items.put("lvl5/LF5.png", "Plastic Container (RSC that goes in landfill)");
        level5Items.put("lvl5/LF6.png", "Plastic Cup (RSC that goes in landfill) ");
        level5Items.put("lvl5/LF7.png", "Plastic Utensils (RSC that goes in landfill) ");
        level5Items.put("lvl5/LF8.png", "Plastic Cup (RSC that goes in landfill)");
        level5Items.put("lvl5/RC1.png", "Plastic Milk Carton (RSC that goes in recycle)");
        level5Items.put("lvl5/RC2.png", "Plastic Wrap");
        level5Items.put("lvl5/RC3.png", "Cardboard Box");
        level5Items.put("lvl5/RC4.png", "Plastic Container (RSC that goes in recycle)");
        level5Items.put("lvl5/RC5.png", "Aluminum Foil");
        level5Items.put("lvl5/RC6.png", "Platic Coffee Lid(RSC that goes in recycle)");
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

        cmp.put("lvl1/comp1.png", "Flowers");
        cmp.put("lvl1/comp2.png", "Apple Core");
        cmp.put("lvl1/comp3.png", "Banana Peel");
        cmp.put("lvl1/comp4.png", "Tea Bag");
        cmp.put("lvl1/comp5.png", "Leaves");
        cmp.put("lvl1/comp6.png", "Bundle of Sticks");
        cmp.put("lvl2/Comp1.png", "Egg Shell");
        cmp.put("lvl2/Comp2.png", "Pizza Slice"); 
        cmp.put("lvl2/Comp3.png", "Chicken Bone");
        cmp.put("lvl2/Comp4.png", "Coffee Grounds");
        cmp.put("lvl2/Comp5.png", "Cardboard Container");
        cmp.put("lvl2/Comp6.png", "Wooden Utensils");
        cmp.put("lvl2/Comp7.png", "Meat");
        cmp.put("lvl3/comp1.png", "Paper + Envelope");
        cmp.put("lvl3/comp2.png", "Fries");
        cmp.put("lvl3/comp3.png", "Popcorn");
        cmp.put("lvl3/comp4.png", "Moldy Cheese");
        cmp.put("lvl3/comp5.png", "Cardboard Drink Carrier");
        cmp.put("lvl3/comp6.png", "Cardboard Box and Bag");
        cmp.put("lvl3/comp7.png", "Cardboard Take-out Box");
        cmp.put("lvl3/comp8.png", "Toothpicks");
        cmp.put("lvl4/Comp1.png", "Old Notebook");
        cmp.put("lvl4/Comp2.png", "Fish Bone");
        cmp.put("lvl4/Comp3.png", "Paper Bag");
        cmp.put("lvl4/Comp4.png", "Coffee Filters");
        cmp.put("lvl4/Comp5.png", "Pizza Slice");
        cmp.put("lvl4/Comp6.png", "Shreded Paper");
        cmp.put("lvl4/Comp7.png", "Pizza Box");
        cmp.put("lvl5/Comp1.png", "Paper Towel");
        cmp.put("lvl5/Comp2.png", "Tissue");
        cmp.put("lvl5/Comp3.png", "Cardboard Tray");
        cmp.put("lvl5/Comp4.png", "Cardboard Container");
        cmp.put("lvl5/Comp5.png", "Travel Magazine");
        cmp.put("lvl5/Comp6.png", "Old Exams");
    }

    // Recycle Items
    public void loadRCY() {
        rcy.clear();

        rcy.put("lvl1/RC1.png", "Fabric Softener Bottle");
        rcy.put("lvl1/RC2.png", "News Paper");
        rcy.put("lvl1/RC3.png", "Milk Carton");
        rcy.put("lvl2/RC1.png", "Water Bottle");
        rcy.put("lvl2/RC2.png", "Soda Can");
        rcy.put("lvl2/RC3.png", "Tomato Can");
        rcy.put("lvl2/RC4.png", "Food Can");
        rcy.put("lvl2/RC5.png", "Soda Cans");
        rcy.put("lvl2/RC6.png", "Sardine Can");
        rcy.put("lvl2/RC7.png", "Cardboard Box");
        rcy.put("lvl3/RC1.png", "Water Bottle");
        rcy.put("lvl3/RC2.png", "Book");
        rcy.put("lvl3/RC3.png", "Paper Bag");
        rcy.put("lvl3/RC4.png", "Napkin");
        rcy.put("lvl4/RC1.png", "Blue Solo Cup");
        rcy.put("lvl4/RC2.png", "Plastic Container");
        rcy.put("lvl4/RC3.png", "Aluminium Food Tray");
        rcy.put("lvl5/RC1.png", "Plastic Milk Carton (RSC that goes in recycle)");
        rcy.put("lvl5/RC2.png", "Plastic Wrap");
        rcy.put("lvl5/RC3.png", "Cardboard Box");
        rcy.put("lvl5/RC4.png", "Plastic Container (RSC that goes in recycle)");
        rcy.put("lvl5/RC5.png", "Aluminum Foil");
        rcy.put("lvl5/RC6.png", "Platic Coffee Lid(RSC that goes in recycle)");
    }


    // Landfill items
    public void loadLND() {
        lnd.clear();
        lnd.put("lvl1/LF1.png", "Plastic Bag");
        lnd.put("lvl1/LF2.png", "Drink");
        lnd.put("lvl1/LF3.png", "Toothpaste");
        lnd.put("lvl1/LF4.png", "Latex Gloves");
        lnd.put("lvl1/LF5.png", "Mask");
        lnd.put("lvl1/LF6.png", "Broken Cup");
        lnd.put("lvl2/LF1.png", "Plastic Straw");
        lnd.put("lvl2/LF2.png", "Candy Wrapper");
        lnd.put("lvl2/LF3.png", "Ceramic Bowl");
        lnd.put("lvl3/LF1.png", "Glass Jars/Bottles");
        lnd.put("lvl3/LF2.png", "Chip Bag");
        lnd.put("lvl4/LF1.png", "Plastic Straw");
        lnd.put("lvl4/LF2.png", "Plastic Bag");
        lnd.put("lvl4/LF3.png", "Juice Box");
        lnd.put("lvl4/LF4.png", "Candy Wrapper");
        lnd.put("lvl4/LF5.png", "Plastic Utensils");
        lnd.put("lvl4/LF6.png", "Milk");
        lnd.put("lvl4/LF7.png", "Styrofoam Cup");
        lnd.put("lvl4/LF8.png", "Styrofoam Egg Carton");
        lnd.put("lvl5/LF1.png", "Plastic Container (RSC that goes in landfill)");
        lnd.put("lvl5/LF2.png", "Styrofoam Carton");
        lnd.put("lvl5/LF3.png", "Snack Bag");
        lnd.put("lvl5/LF4.png", "Bubble Wrap");
        lnd.put("lvl5/LF5.png", "Plastic Container (RSC that goes in landfill)");
        lnd.put("lvl5/LF6.png", "Plastic Cup (RSC that goes in landfill)");
        lnd.put("lvl5/LF7.png", "Plastic Utensils (RSC that goes in landfill)");
        lnd.put("lvl5/LF8.png", "Plastic Cup (RSC that goes in landfill)");
    }


    // E-waste items
    public void loadEWS() {
        ews.clear();

        ews.put("lvl1/EW1.png", "Broken Electronics");
        ews.put("lvl1/EW2.png", "Wires");
        ews.put("lvl1/EW3.png", "Light Bulb");
        ews.put("lvl2/EW1.png", "Batteries");
        ews.put("lvl3/EW1.png", "Batteries");
        ews.put("lvl3/EW2.png", "Game Controller");
        ews.put("lvl4/EW1.png", "DVD");
    }

}
