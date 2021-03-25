package seedu.exceptions;

public class EmptyListException extends Exception {
    public String getMessage() {
        return "OOPS!!! The list is empty!";
    }
}
