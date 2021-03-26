package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.model.Patient;
import seedu.duke.model.Record;

import java.io.IOException;
import java.util.SortedMap;

public class StorageTest {
    @Test
    public void storeData() {
        Data data = new Data();
        Patient patient = new Patient("S1234567D");
        patient.addRecord(new Record("fever, cough"));
        patient.addRecord(new Record("headache & no appetite"));
        data.setPatient(patient);
        patient = new Patient("S7654321B");
        patient.addRecord(new Record("acute stomach pain"));
        data.setPatient(patient);


        Storage storage = new Storage("testFile.txt");
        try {
            storage.save(data.patients);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void loadData() {
        Storage storage = new Storage("testFile.txt");
        try {
            SortedMap<String, Patient> data = storage.load();
            for (String patientID : data.keySet()) {
                System.out.println(patientID);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
