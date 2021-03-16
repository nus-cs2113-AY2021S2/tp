package seedu.connoisseur.exceptions;

public class ConnoisseurException extends Exception{

    /**
     * Creates DukeExceptions for methods to throw.
     * @param errorMessage Error message.
     */

    public ConnoisseurException(String errorMessage){
        String WARNING_DIVIDER = "\txxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n";
        System.out.print(WARNING_DIVIDER + "\tERROR: " + errorMessage + WARNING_DIVIDER);
    }
}