package seedu.fridgefriend.food;

import java.util.ArrayList;

public class Fridge {
    private static ArrayList<Food> fridge = new ArrayList<>();

    public static void add(Food food) {
        fridge.add(food);
    }

    public static int getSize() {
        return fridge.size();
    }

    public static Food getFood(int i) {
        return fridge.get(i);
    }

    public static void removeByIndex(int index) {
        fridge.remove(index);
    }
}
