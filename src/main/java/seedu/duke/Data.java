package seedu.duke;

import java.time.LocalDate;
import java.util.SortedMap;
import java.util.TreeMap;

import seedu.duke.exception.DataException;
import seedu.duke.exception.StorageException;
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
    private Patient currentPatient;

    /**
     * This initializes an empty data instance with no storage instance.
     * This can be used for testing purposes.
     */
    public Data() {
        this(null);
    }

    /**
     * This initializes an empty data instance with a storage instance.
     *
     * @param storage an instance of the storage class
     */
    public Data(Storage storage) {
        this(storage, new TreeMap<>());
    }

    /**
     * This initializes a data instance with an existing patient list.
     * Storage instance must be specified if want to use an existing list of patients. However it can be set
     * to null (i.e. new Data(null, existingPatients)) for testing purposes.
     *
     * @param storage  an instance of the storage class
     * @param patients the patient list
     */
    public Data(Storage storage, SortedMap<String, Patient> patients) {
        this.storage = storage;
        this.patients = patients;
        currentPatient = null;
    }

    /**
     * Helper methods to check if there is a patient, or if a patient has been previously added to the list.
     * If they fail, they will throw a DataException with the corresponding error message.
     */
    private void checkLoadedPatient() throws DataException {
        if (currentPatient == null) {
            throw new DataException(DataException.Type.NO_PATIENT_LOADED);
        }
    }

    private void checkPatientExists(String id) throws DataException {
        if (!patients.containsKey(id)) {
            throw new DataException(DataException.Type.PATIENT_NOT_FOUND);
        }
    }

    /**
     * This retrieves the full hashmap of patients.
     *
     * @return the patient hashmap
     */
    public SortedMap<String, Patient> getPatients() {
        return patients;
    }

    /**
     * This retrieves a single patient bases on its unique identifier.
     *
     * @param id unique identifier of the patient to be retrieved
     * @return the patient instance associated with this ID if found, otherwise null is returned
     */
    public Patient getPatient(String id) {
        return patients.get(id);
    }

    /**
     * Add or update a new patient to the hashmap of this database.
     *
     * @param patient the patient to be added/updated
     */
    public void setPatient(Patient patient) {
        patients.put(patient.getID(), patient);
    }

    /**
     * This loads a patient to the currentPatient attribute.
     * Take note that currentPatient can still be null if there is no patients with this id in the hashmap.
     *
     * @param id unique identifier of the patient to be loaded
     * @return true if a patient is successfully loaded, otherwise false
     */
    public Boolean loadCurrentPatient(String id) {
        Patient newCurrentPatient = getPatient(id);
        if (newCurrentPatient == null) {
            return false;
        }
        currentPatient = newCurrentPatient;
        return true;
    }

    /**
     * This removes a patient from the hashmap of this database.
     *
     * @param id unique identifier of the patient to be loaded
     * @throws DataException if the patient has not been added to the database previously
     */
    public void deletePatient(String id) throws DataException {
        checkPatientExists(id);
        patients.remove(id);
    }

    /**
     * This saves current patient list into the file using the storage instance.
     */
    public void saveFile() throws StorageException {
        // If storage is null, we just silently ignore it (for testing)
        if (storage != null) {
            storage.save(patients);
        }
    }

    /**
     * Add medical record(s) to the currently loaded patient.
     *
     * @param date         the date of the patient's consultation
     * @param symptom      symptoms reported by the patient
     * @param diagnosis    diagnosis made by the doctor
     * @param prescription prescription made by the doctor
     * @return a string containing a confirmation that the records were added to the patient
     * @throws DataException if there is no loaded patient
     */
    public String addRecord(LocalDate date, String symptom, String diagnosis, String prescription)
            throws DataException {
        checkLoadedPatient();
        boolean containsSymptom = symptom != null && !symptom.isEmpty();
        boolean containsDiagnosis = diagnosis != null && !diagnosis.isEmpty();
        boolean containsPrescription = prescription != null && !prescription.isEmpty();
        if (!containsSymptom && !containsDiagnosis && !containsPrescription) {
            throw new DataException(DataException.Type.EMPTY_DESCRIPTION);
        }
        String recentDetails = currentPatient.addRecord(date, symptom, diagnosis, prescription);
        return recentDetails;
    }

    /**
     * Retrieves the currently loaded patient's medical records for a specific date.
     *
     * @param date the date of the patient's consultation
     * @return a string containing the records of the patient's visit on the date
     * @throws DataException if there is no loaded patient
     */
    public String getRecords(LocalDate date) throws DataException {
        checkLoadedPatient();
        String records = currentPatient.getRecord(date);
        return records;
    }

    /**
     * Retrieves all of the currently loaded patient's medical records. If a patient does not have any records,
     * the returned string will notify the user that there are no records.
     *
     * @return a string containing all the records of the patient
     * @throws DataException if there is no loaded patient
     */
    public String getRecords() throws DataException {
        checkLoadedPatient();
        String records = currentPatient.getRecord();
        return records;
    }

    /**
     * Deletes the patient's medical record for a specific date.
     *
     * @param date Appointment date of record to delete
     * @throws DataException if there is no loaded patient, or the patient does not have any medical records for the
     *                       specified date
     */
    public void deleteRecord(LocalDate date) throws DataException {
        checkLoadedPatient();
        currentPatient.deleteRecord(date);
    }

    /**
     * Loads a patient based on their ID number.
     *
     * @param id ID number of the patient to be loaded
     * @return a string containing a confirmation message
     * @throws DataException if the patient with the specified ID number does not exist
     */
    public String loadPatient(String id) throws DataException {
        checkPatientExists(id);
        currentPatient = patients.get(id);
        return "Patient " + currentPatient.getID() + "\'s data has been found and loaded.";
    }

    public String getCurrentPatientDetails() {
        if (currentPatient == null) {
            return "There is no patient being loaded now.";
        }
        return "The currently loaded patient's ID is " + currentPatient.getID() + ".";
    }
}
