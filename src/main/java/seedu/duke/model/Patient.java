package seedu.duke.model;

import java.util.ArrayList;

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
    protected ArrayList<Record> records;

    /**
     * Initialize a patient instance with an empty record list.
     * @param id Patient's unique identifier
     */
    public Patient(String id) {
        this(id, new ArrayList<>());
    }

    /**
     * Initialize a patient instance with a pre-defined record list.
     * @param id Patient's unique identifier
     * @param records Patient's visit record list
     */
    public Patient(String id, ArrayList<Record> records) {
        this.id = id;
        this.records = records;
    }

    /**
     * Get unique identifier of the patient.
     * @return Patient's unique identifier
     */
    public String getID() {
        return id;
    }

    /* Functionals for manipulating records */
    /**
     * Get all records associated with this patient.
     * @return All records in an ArrayList
     */
    public ArrayList<Record> getRecords() {
        return records;
    }

    /**
     * Add a single record into the patient's record list.
     * @param record Record to be inserted to the back
     */
    public void addRecord(Record record) {
        records.add(record);
    }
}
