package seedu.fridgefriend.food;

import java.util.ArrayList;

public class Fridge {
    private ArrayList<Food> fridge = new ArrayList<>();

    public void add(Food food) {
        fridge.add(food);
    }

    public int getSize() {
        return fridge.size();
    }

    public Food getFood(int i) {
        return fridge.get(i);
    }

    public void removeByIndex(int index) {
        fridge.remove(index);
    }


}
