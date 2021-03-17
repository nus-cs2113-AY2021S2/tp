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
     * Get the food name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the food name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the weight data.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Set the weight data.
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Get the calories data.
     */
    public double getCal() {
        return calorie;
    }

    /**
     * Set the calories data.
     */
    public void setCal(double calorie) {
        this.calorie = calorie;
    }

    /**
     * Get the category.
     */
    public FoodCategory getCategory() {
        return category;
    }

    /**
     * Get the category.
     */
    public void setCategory(String food) {
        this.category = category;
    }
}
