package seedu.exceptions.inventory;
import seedu.exceptions.DukeException;
public class DuplicateDrugException extends DukeException{
    public DuplicateDrugException(String error) {
        this.error = error;
    }
    @Override
    public void getError(String input) {
        super.getError(input);
    }

}
