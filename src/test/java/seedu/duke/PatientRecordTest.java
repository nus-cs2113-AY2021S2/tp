package seedu.duke;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PatientRecordTest {
    @Test
    public void addRecord_noRecords_emptyListReturned() {
        PatientRecord patientRecord = new PatientRecord();
        assertEquals(0, patientRecord.getRecords().size());
    }

    @Test
    public void addRecord_addRecords() {
        PatientRecord patientRecord = new PatientRecord();
        patientRecord.addRecord("coughing");
        patientRecord.addRecord("fever");
        assertEquals(2, patientRecord.getRecords().size());
    }
}
