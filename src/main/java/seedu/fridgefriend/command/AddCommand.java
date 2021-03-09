package seedu.fridgefriend.command;

import java.util.List;

/**
 * Add a food to the FoodList
 */
public class AddCommand extends Command {

    private String category;
    private String foodName;

    //Add Category of food and food name.
    public AddCommand(String[] foodDescription) {
        this.category = foodDescription[0].trim();
        this.foodName = foodDescription[1].trim();
    }

    @Override
    public void execute (List<String> foods) {
        foods.add(foodName);
        showResults();
    }

    private void showResults() {
        System.out.println("Great! I have added " + category + "[" + foodName + "] into your fridge.\n");
    }

}
