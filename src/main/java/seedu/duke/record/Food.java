package seedu.duke.record;

import java.util.HashMap;

public class Food {
    private static HashMap<String, Integer> foodCalPer;

    private String name;
    private double weight;
    private double calorie;
    private FoodCategory category;

    public Food(String name, double weight, double calorie, FoodCategory category){
        this.name = name;
        this. weight = weight;
        this.calorie = calorie;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getCal() {
        return calorie;
    }

    public void setCal(double calorie) {
        this.calorie = calorie;
    }

    public FoodCategory getCategory() {
        return category;
    }

    public void setCategory(FoodCategory category) {
        this.category = category;
    }
}
