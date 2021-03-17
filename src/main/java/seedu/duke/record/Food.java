package seedu.duke.record;

import java.util.HashMap;

public class Food {
    private static HashMap<String, Integer> foodCalPer;
    private FoodCategory category;

    private String name;
    private double weight;
    private double calorie;

    public Food(String name, double weight, double calorie, FoodCategory category) {
        this.name = name;
        this.weight = weight;
        this.calorie = calorie;
        this.category = category;
    }

    /**
     * Gets the name of food which user added.
     *
     * @return the name of the food.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets a name for a food user add.
     *
     * @param name to give the food a name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the food weight.
     *
     * @return the weight of food.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Sets weight for a kind of food.
     *
     * @param weight to measure the weight of food.
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Gets the calorie data.
     *
     * @return calorie the calorie data.
     */
    public double getCal() {
        return calorie;
    }

    /**
     * Sets a new calorie of food.
     *
     * @param calorie the calorie of food.
     */
    public void setCal(double calorie) {
        this.calorie = calorie;
    }

    /**
     * Gets the category of the food.
     *
     * @return category the food category.
     */
    public FoodCategory getCategory() {
        return category;
    }

    /**
     * Sets a new category of food.
     *
     * @param category set new category.
     */
    public void setCategory(String food) {
        this.category = category;
    }
}
