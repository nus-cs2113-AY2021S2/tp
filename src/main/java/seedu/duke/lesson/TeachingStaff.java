package seedu.duke.lesson;

import static seedu.duke.common.Constants.FORMAT_EMAIL;

public class TeachingStaff {

    private String name;
    private String email;

    public TeachingStaff(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    //@@author ivanchongzhien
    /**
     * Check if given string is a valid email.
     *
     * @param email string to be checked
     * @return true if string follows the format of a valid email
     */
    public static boolean isValidEmail(String email) {
        return email.trim().matches(FORMAT_EMAIL);
    }
}
