package seedu.exceptions;

public class NoInputException extends Exception {
    public String getMessage() {
        return "There is an empty field in the input! All fields must be filled!";
    }
}
