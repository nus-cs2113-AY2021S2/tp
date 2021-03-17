package seedu.duke.account;

/**
 * Represents a user of this app.
 */
public class User {
    private String name;
    private Gender gender;
    private int age;
    private double bodyWeight;

    private FitCenter fitCenter = new FitCenter();

    /**
     * Initializes a default user object with default attributes.
     */
    public User() {
        int DEFAULT_AGE = 20;
        double DEFAULT_WEIGHT = 50;
        this.name = "Default User";
        this.gender = Gender.UNKNOWN;
        this.age = DEFAULT_AGE;
        this.bodyWeight = DEFAULT_WEIGHT;
    }

    /**
     * Initializes a user object. Assumes that all params are not null.
     *
     * @param name       the name of the user.
     * @param gender     the gender of the user.
     * @param age        the age of the user.
     * @param bodyWeight the body weight of the user.
     */
    public User(String name, Gender gender, int age, double bodyWeight) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.bodyWeight = bodyWeight;
    }

    /**
     * Gets the name of the user.
     *
     * @return the name of the user.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the gender of the user.
     *
     * @return the gender of the user in Gender.
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Gets the age of the user.
     *
     * @return the age of the user.
     */
    public int getAge() {
        return age;
    }

    /**
     * Gets the body weight of the user.
     *
     * @return the body weight of the user in KG.
     */
    public double getBodyWeight() {
        return bodyWeight;
    }

    /**
     * Sets the body weight of the user.
     *
     * @param bodyWeight the new body weight in KG.
     */
    public void setBodyWeight(double bodyWeight) {
        this.bodyWeight = bodyWeight;
    }

    /**
     * Gets the fit center of the user.
     *
     * @return the fit center of the user.
     */
    public FitCenter getFitCenter() {
        return fitCenter;
    }

    @Override
    public String toString() {
        return "User Name: " + name + "\nGender: " + gender + "\nAge: " + age + "\nBody Weight: " + bodyWeight;
    }
}
