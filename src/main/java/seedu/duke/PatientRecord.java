package seedu.duke;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

/**
 * This class contains all the details of a patients past visits to the polyclinic.
 * TODO: Add specialised symptom, diagnosis, prescription fields instead of a generic record
 */

public class PatientRecord {
    private ArrayList<String> records;

    /**
     * This is the constructor of the record class.
     */
    public PatientRecord() {
        this.records = new ArrayList<String>();
    }

    /**
     * Adds a new record to the patient's ArrayList of records.
     *
     * @param record a String containing the details of the new record
     */
    public void addRecord(String record) {
        records.add(record);
    }

    /**
     * Retrieves all of a patients past records.
     *
     * @return an immutable List of Strings containing the patient's past records
     */
    public List<String> getRecords() {
        return Collections.unmodifiableList(records);
    }
}
