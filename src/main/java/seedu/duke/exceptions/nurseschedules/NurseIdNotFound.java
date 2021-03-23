package seedu.duke.exceptions.nurseschedules;

import seedu.duke.exceptions.HealthVaultException;

<<<<<<< HEAD:src/main/java/seedu/duke/exceptions/nurseschedules/NurseIDNotFound.java
public class NurseIDNotFound extends HealthVaultException {
=======
public class NurseIdNotFound extends DukeException {
>>>>>>> e8dc76240730cc8be272c6c187ef83791fcd388c:src/main/java/seedu/duke/exceptions/nurseschedules/NurseIdNotFound.java
    public String getMessage() {
        return "NurseID does not exist! Please check ID and try again!";
    }
}
