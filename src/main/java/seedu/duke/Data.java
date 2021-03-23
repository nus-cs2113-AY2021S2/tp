package seedu.duke;

import java.util.SortedMap;
import java.util.TreeMap;

import seedu.duke.model.Patient;

/**
 * This class (instance) contains all data of the running application. This
 * includes patient list and miscellaneous config.
 */
public class Data {
    protected SortedMap<String, Patient> patients;

    /**
     * This is the patient that is currently being selected. Command sub-classes can read/write
     * this attribute directly.
     * Before modification, if not loaded, it needs to call loadCurrentPatient(id) to load the patient.
     * After modification, saveCurrentPatient() needs to be called to write back any changes on this attribute.
     */
    public Patient currentPatient;

    /**
     * This initilizes a empty data instance.
     */
    public Data() {
        this(new TreeMap<>());
    }

    /**
     * This initializes a data instance with an existing patient list.
     * @param patients The patient list
     */
    public Data(SortedMap<String, Patient> patients) {
        this.patients = patients;
        currentPatient = null;
    }

    /**
     * This retrieves the full hashmap of patients.
     * @return the patient hashmap
     */
    public SortedMap<String, Patient> getPatients() {
        return patients;
    }

    /**
     * This retrieves a single patient bases on its unique identifier.
     * @param id unique identifier of the patient to be retrieved
     * @return the patient instance associated with this ID if found, otherwise null is returned
     */
    public Patient getPatient(String id) {
        return patients.get(id);
    }

    /**
     * Add or update a new patient to the hashmap of this database.
     * @param patient the patient to be added/updated
     */
    public void setPatient(Patient patient) {
        patients.put(patient.getID(), patient);
    }

    /**
     * This loads a patient to the currentPatient attribute.
     * Take note that currentPatient can still be null if there is no patients with this id in the hashmap.
     * @param id unique identifier of the patient to be loaded
     */
    public void loadCurrentPatient(String id) {
        currentPatient = getPatient(id);
    }

    /**
     * This saves the patient in currentPatient attribute back to the hashmap.
     */
    public void saveCurrentPatient() {
        setPatient(currentPatient);
    }
}
