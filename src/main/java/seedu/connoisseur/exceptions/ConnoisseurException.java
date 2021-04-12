package seedu.connoisseur.exceptions;

public class ConnoisseurException extends Exception {

    private static final String WARNING_DIVIDER = "\txxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n";
    
    /**
     * Creates DukeExceptions for methods to throw.
     * @param errorMessage Error message.
     */
    public ConnoisseurException(String errorMessage) {
        System.out.print(WARNING_DIVIDER + "\tERROR: " + errorMessage + WARNING_DIVIDER);
    }
}
