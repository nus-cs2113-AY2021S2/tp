package seedu.connoisseur.exceptions;

public class InvalidRatingException extends Throwable {
    private static final long serialVersionUID = 1L;
    
    /**
     * Exception when rating not between 0-5. 
     */
    public InvalidRatingException() {
    }
}
