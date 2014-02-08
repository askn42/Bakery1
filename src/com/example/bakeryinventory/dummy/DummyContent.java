package com.example.bakeryinventory.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    static {
        // Add 5 sample items.
        addItem(new DummyItem("1", "Cream", "Carnation"));
        addItem(new DummyItem("2", "Milk", "Cowhead"));
        addItem(new DummyItem("3", "Sugar", "Local"));
        addItem(new DummyItem("4", "Butter", "Darigold"));
        addItem(new DummyItem("5", "Baking Powder", "Arm & Hammer"));
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public String id;
        public String name;
        public String brand;
/*        public int size;
        public String size_unit;
        public String last_check;
        public String amt;
        public String cost;*/

        public DummyItem(String id, String name, String brand/*, int size, String size_unit,
        String last_check, String amt, String cost*/) {
            this.id = id;
            this.name = name;
            this.brand = brand;
           /* this.size = size;
            this.size_unit = size_unit;
            this.last_check = last_check;
            this.amt = amt;
            this.cost = cost;*/
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
