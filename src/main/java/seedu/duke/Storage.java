package seedu.duke;

import seedu.duke.model.Patient;
import seedu.duke.model.Record;

import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * This class handles the loading and saving of data from/to a plaintext file on
 * the hard drive.
 */
public class Storage {
    protected String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public void save(SortedMap<String, Patient> patientData) throws IOException {
        try {
            File inFile = new File(filePath);
            inFile.createNewFile();
            FileWriter fileWriter = new FileWriter(inFile.getAbsolutePath(), false);
            StringBuffer message = new StringBuffer();
            Set patientSet = patientData.entrySet();
            Iterator patientIterator = patientSet.iterator();

            while (patientIterator.hasNext()) {
                Map.Entry m = (Map.Entry)patientIterator.next();

                String id = (String)m.getKey();
                Patient patient = (Patient)m.getValue();
                String records = convertRecordToString(patient);

                message.append(id + Constants.ID_DELIMITER + records + "\n");
            }
            fileWriter.write(message.toString());
            fileWriter.close();

        } catch (FileNotFoundException e) {
            Ui ui = new Ui();
            ui.printException(e);
        }
    }

    public String convertRecordToString(Patient patient) {
        StringBuilder stringBuilder = new StringBuilder();
        TreeMap<LocalDate, Record> records = patient.getRecords();
        for (Map.Entry<LocalDate, Record> record : records.entrySet()) {
            String localDate = record.getKey().format(DateTimeFormatter.ofPattern(Constants.DATE_PATTERN));
            Record patientRecord = record.getValue();

            stringBuilder.append(localDate + Constants.DATE_DELIMITER + patientRecord.printFileConsultationDetail());
        }

        return (stringBuilder.toString());
    }

    /*public TreeMap<LocalDate, Record> convertStringToRecords(String recordString) {
        String[] splitString = recordString.split(Constants.DATE_DELIMITER);
        TreeMap<LocalDate, Record> records = new TreeMap<>();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(Constants.DATE_PATTERN);
        LocalDate dt = dateTimeFormatter.parseLocalDate(splitString[0]);

        return records;
    }

    public SortedMap<String, Patient> load() throws IOException {
        SortedMap<String, Patient> data = new TreeMap<>();
        try {
            File inFile = new File(filePath);
            Scanner scanner = new Scanner(inFile);
            while (scanner.hasNextLine()) {
                String[] retrievedPatientsData = scanner.nextLine().split(Constants.ID_DELIMITER);
                String id = retrievedPatientsData[0];
                TreeMap<LocalDate, Record> records = convertStringToRecords(retrievedPatientsData[1]);
                Patient patient = new Patient(id, records);
                data.put(id, patient);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            Ui ui = new Ui();
            ui.printException(e);
        }
        return data;
    }*/
}
