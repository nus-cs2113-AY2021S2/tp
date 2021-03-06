package seedu.duke;

import java.util.HashMap;

import seedu.duke.model.Patient;

/**
 * This class (instance) contains all data of the running application. This
 * includes patient list and miscellaneous config.
 */
public class Data {
    protected HashMap<String, Patient> patients;

    /**
     * Initilize a empty data instance.
     */
    public Data() {
        this(new HashMap<>());
    }

    /**
     * Initialize a data instance with an existing patient list.
     * @param patients The patient list
     */
    public Data(HashMap<String, Patient> patients) {
        this.patients = patients;
    }
}
