package seedu.duke.lesson;

public class TeachingStaff {

    private final String name;
    private final String email;

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
}
