package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.model.Patient;
import seedu.duke.model.Record;

import java.io.IOException;
import java.time.LocalDate;
import java.util.SortedMap;

public class StorageTest {
    @Test
    public void storeData() {
        Data data = new Data();
        Patient patient = new Patient("S1234567D");
        LocalDate date = LocalDate.now();
        patient.addRecord(date, "head pain, dizziness", "heat stroke", "cooling packs, medicine");
        data.setPatient(patient);
        patient = new Patient("S7654321B");
        patient.addRecord(date, "abdominal pain", "mild UTI", "antibiotics, referral to hospital");
        data.setPatient(patient);


        Storage storage = new Storage("testFile.txt");
        try {
            storage.save(data.patients);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*@Test
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
    }*/

}
