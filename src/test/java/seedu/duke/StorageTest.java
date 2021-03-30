package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.model.Patient;
import seedu.duke.model.Record;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.SortedMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StorageTest {
    @Test
    public void storeData() {
        Data data = new Data();
        Patient patient = new Patient("S1234567D");
        LocalDate date = LocalDate.now();
        patient.addRecord(date, "head pain, dizziness", "heat stroke", "cooling packs, medicine");
        patient.addRecord(date.plus(1, ChronoUnit.DAYS), "fainting", "severe heat stroke", "referral to hospital");
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

    @Test
    public void loadData() {
        Storage storage = new Storage("testFile.txt");

        final PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        try {
            SortedMap<String, Patient> data = storage.load();

            for (String patientID : data.keySet()) {
                System.out.println(patientID);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals("S1234567D" + System.lineSeparator()
                + "S7654321B" + System.lineSeparator() , bos.toString());
        System.setOut(originalOut);
    }

}
