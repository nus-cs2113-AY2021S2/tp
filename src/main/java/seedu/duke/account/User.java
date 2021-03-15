package seedu.duke.account;

public class User {
    private String name;
    private Gender gender;
    private int age;
    private double bodyWeight;

    private FitCenter fitCenter = new FitCenter();

    public User(String name, Gender gender, int age, double bodyWeight) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.bodyWeight = bodyWeight;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public double getBodyWeight() {
        return bodyWeight;
    }

    @Override
    public String toString() {
        return "User Name: " + name + "\nGender: " + gender + "\nAge: " + age + "\nBody Weight: " + bodyWeight;
    }
}
