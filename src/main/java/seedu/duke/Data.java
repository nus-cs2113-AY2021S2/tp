package seedu.duke;

import java.util.SortedMap;
import java.util.TreeMap;

import seedu.duke.model.Patient;

/**
 * This class (instance) contains all data of the running application. This
 * includes patient list and miscellaneous config.
 */
public class Data {
    private Storage storage;
    private SortedMap<String, Patient> patients;

    /**
     * This is the patient that is currently being selected. Command sub-classes can read/write
     * this attribute directly.
     * Before modification, if not loaded, it needs to call loadCurrentPatient(id) to load the patient.
     * After modification, saveCurrentPatient() needs to be called to write back any changes on this attribute.
     */
    public Patient currentPatient;

    /**
     * This initializes an empty data instance with no storage instance.
     * This can be used for testing purposes.
     */
    public Data() {
        this(null);
    }

    /**
     * This initializes an empty data instance with a storage instance.
     * @param storage an instance of the storage class
     */
    public Data(Storage storage) {
        this(storage, new TreeMap<>());
    }

    /**
     * This initializes a data instance with an existing patient list.
     * Storage instance must be specified if want to use an existing list of patients. However it can be set
     * to null (i.e. new Data(null, existingPatients)) for testing purposes.
     * @param storage an instance of the storage class
     * @param patients the patient list
     */
    public Data(Storage storage, SortedMap<String, Patient> patients) {
        this.storage = storage;
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
     * This removes a patient from the hashmap of this database.
     * @param id unique identifier of the patient to be loaded
     */
    public void deletePatient(String id) {
        patients.remove(id);
    }

    /**
     * This saves the patient in currentPatient attribute back to the hashmap.
     */
    public void saveCurrentPatient() {
        setPatient(currentPatient);
    }

    /**
     * This saves current patient list into the file using the storage instance.
     */
    public void saveFile() throws Exception {
        if (storage == null) {
            throw new Exception("We cannot save as the storage instance is null!");
        }
        storage.save(patients);
    }
}
