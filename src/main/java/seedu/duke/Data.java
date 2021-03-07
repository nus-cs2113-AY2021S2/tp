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
     * This initilizes a empty data instance.
     */
    public Data() {
        this(new HashMap<>());
    }

    /**
     * This initializes a data instance with an existing patient list.
     * @param patients The patient list
     */
    public Data(HashMap<String, Patient> patients) {
        this.patients = patients;
    }

    /**
     * This retrieves the full hashmap of patients.
     * @return the patient hashmap
     */
    public HashMap<String, Patient> getPatients() {
        return patients;
    }

    /**
     * Add a new patient to the hashmap of this database.
     * @param patient the patient to be added
     */
    public void addPatient(Patient patient) {
        patients.put(patient.getID(), patient);
    }
}
