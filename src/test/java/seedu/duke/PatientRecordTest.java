package seedu.duke;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PatientRecordTest {
    @Test
    public void addRecord_noRecords_emptyListReturned() {
        PatientRecord patientRecord = new PatientRecord();
        assertEquals(0, patientRecord.getRecords().size());
    }

    @Test
    public void addRecord_addRecords_newRecordsFoundInList() {
        PatientRecord patientRecord = new PatientRecord();
        patientRecord.addRecord("coughing");
        patientRecord.addRecord("fever");
        List<String> records = patientRecord.getRecords();
        List<String> expected = Arrays.asList("coughing", "fever");
        assertEquals(expected, records);
    }

    @Test
    public void addRecord_addRecords_noUnexpectedRecordsFound() {
        PatientRecord patientRecord = new PatientRecord();
        patientRecord.addRecord("coughing");
        patientRecord.addRecord("fever");
        List<String> records = patientRecord.getRecords();
        assertFalse(records.contains("vomiting"));
    }
}
