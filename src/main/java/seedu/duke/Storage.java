package seedu.duke;

import seedu.duke.model.Patient;
import seedu.duke.model.Record;

import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * This class handles the loading and saving of data from/to a plaintext file on
 * the hard drive.
 */
public class Storage {
    protected String filePath;

    /**
     * This is the constructor without a parameter. Default path will be used.
     */
    public Storage() {
        this(Constants.STORAGE_DEFAULT_PATH);
    }

    /**
     * This is the constructor of the Storage class.
     * @param filePath A String of the path to the file that is used for saving/loading
     */
    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Saves a SortedMap of data into the file specified by filePath.
     * @param patientData The data to be written to file
     * @throws IOException When file is not found etc
     */
    public void save(SortedMap<String, Patient> patientData) throws IOException {
        try {
            File inFile = new File(filePath);
            if (!inFile.exists()) {
                inFile.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(inFile.getAbsolutePath(), false);
            StringBuffer message = new StringBuffer();
            Set<Map.Entry<String, Patient>> patientSet = patientData.entrySet();
            Iterator<Map.Entry<String, Patient>> patientIterator = patientSet.iterator();

            while (patientIterator.hasNext()) {
                Map.Entry<String, Patient> m = patientIterator.next();

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

    /**
     * Convert records in a patient object into a string, separated by delimiters.
     * @param patient Patient object whose records will be converted
     * @return A string to be used by the save() method
     */
    public String convertRecordToString(Patient patient) {
        StringBuilder stringBuilder = new StringBuilder();
        TreeMap<LocalDate, Record> records = patient.getRecords();
        for (Map.Entry<LocalDate, Record> record : records.entrySet()) {
            String localDate = record.getKey().format(DateTimeFormatter.ofPattern(Constants.DATE_PATTERN));
            Record patientRecord = record.getValue();

            stringBuilder.append(localDate + Constants.DATE_DELIMITER + patientRecord.printFileConsultationDetail());
            stringBuilder.append(Constants.RECORDS_DELIMITER);
        }

        return (stringBuilder.toString());
    }
}
