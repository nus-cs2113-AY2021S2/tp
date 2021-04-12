package seedu.duke.model;

import seedu.duke.Common;
import seedu.duke.exception.DataException;

import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

/**
 * Each instance of this class represents a patient, and no two patients should
 * contain the same ID field. The instance contains records for all visits.
 */
public class Patient {
    /**
     * This is the unique identifier of the patient.
     * In SG's context, we use NRIC/FIN for this field
     */
    protected String id;
    protected TreeMap<LocalDate, Record> records;
    protected String symptom;
    protected String diagnosis;
    protected String prescription;

    /**
     * Initialize a patient instance with an empty record list.
     *
     * @param id Patient's unique identifier
     */
    public Patient(String id) {
        this(id, new TreeMap<LocalDate, Record>());
    }

    /**
     * Initialize a patient instance with a pre-defined record TreeMap.
     *
     * @param id      Patient's unique identifier
     * @param records Patient's visit record list
     */
    public Patient(String id, TreeMap<LocalDate, Record> records) {
        this.id = id;
        this.records = records;
        this.symptom = null;
        this.diagnosis = null;
        this.prescription = null;
    }

    /**
     * Get unique identifier of the patient.
     *
     * @return Patient's unique identifier
     */
    public String getID() {
        return id;
    }

    private void checkRecordExists(LocalDate date) throws DataException {
        if (!records.containsKey(date)) {
            throw new DataException(DataException.Type.NO_RECORD_FOUND);
        }
    }

    /* Functionals for manipulating records */

    /**
     * Get all records associated with this patient.
     *
     * @return All records in a TreeMap, mapping consultation dates to records
     */
    public TreeMap<LocalDate, Record> getRecords() {
        return records;
    }

    /**
     * Add a record into the patient's record list. This record can contain up to 3 fields,
     * patient's symptom, diagnosis and prescription.
     *
     * @param date         Appointment date to add the record to
     * @param symptom      Patient's symptoms to add to the record
     * @param diagnosis    Patient's diagnosis to add to the record
     * @param prescription Patient's prescription to add to the record
     * @return a string containing a confirmation that the records were added to the patient
     */
    public String addRecord(LocalDate date, String symptom, String diagnosis, String prescription) {
        if (!records.containsKey(date)) {
            records.put(date, new Record());
        }
        Record record = records.get(date);
        record.addDetails(symptom, diagnosis, prescription);
        this.symptom = symptom;
        this.diagnosis = diagnosis;
        this.prescription = prescription;
        String recentDetails = "Added new details to patient "
                + id + "'s consultation at "
                + Common.formatDate(date) + System.lineSeparator();
        if (symptom != null) {
            recentDetails += "Symptom: " + symptom + System.lineSeparator();
        }
        if (diagnosis != null) {
            recentDetails += "Diagnosis: " + diagnosis + System.lineSeparator();
        }
        if (prescription != null) {
            recentDetails += "Prescription: " + prescription + System.lineSeparator();
        }
        return recentDetails;
    }

    /**
     * Checks if the patient has a visit from the specified date, and returns the records from that date.
     *
     * @param date the date of the patient's consultation
     * @return a string containing the records of the patient's visit on the date
     * @throws DataException if the patient has no visit record from the specified date
     */
    public String getRecord(LocalDate date) throws DataException {
        checkRecordExists(date);
        Record record = records.get(date);
        String recordString = "Here are " + id + "'s records:" + System.lineSeparator()
                + Common.formatDate(date) + ":" + System.lineSeparator()
                + record.toString();
        return recordString;
    }

    /**
     * Returns all the medical records of a patient. If a patient does not have any records,
     * the returned string will notify the user that there are no records
     *
     * @return a string containing all the records of the patient
     */
    public String getRecord() {
        if (records.isEmpty()) {
            return id + " has no medical records.";
        }
        String recordString = "Here are " + id + "'s records:" + System.lineSeparator();
        for (Map.Entry<LocalDate, Record> recordIterator : records.entrySet()) {
            LocalDate date = recordIterator.getKey();
            Record record = recordIterator.getValue();
            recordString += Common.formatDate(date) + ":" + System.lineSeparator()
                    + record.toString();
        }
        return recordString;
    }

    /**
     * Deletes a record from the patient's record list.
     *
     * @param date Appointment date of record to delete
     */
    public void deleteRecord(LocalDate date) throws DataException {
        checkRecordExists(date);
        records.remove(date);
    }
}
