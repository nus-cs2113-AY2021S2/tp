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

    /**
     * This is the constructor of the Storage class.
     * @param filePath A String of the path to the file that is used for saving/loading
     */
    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Saves a SortedMap of data into the file specified by filePath.
     *
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

    /**
     * Convert records in a patient object into a string, separated by delimiters.
     *
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

    //@@author leowxx
    /**
     * Reads from the data file and converts the data into a format usable by Patient Manager.
     *
     * @return data used by Patient Manager
     * @throws IOException errors when reading file
     */
    public SortedMap<String, Patient> load() throws IOException {
        SortedMap<String, Patient> data = new TreeMap<>();
        try {
            File inFile = new File(filePath);
            if (!inFile.exists()) {
                return data;
            }
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
    }

    //@@author Emkay16
    /**
     * Converts lines read from the data file into records used by Patient Manager.
     *
     * @param recordString line of text read from data file
     * @return TreeMap of records converted from recordString
     */
    public TreeMap<LocalDate, Record> convertStringToRecords(String recordString) {
        TreeMap<LocalDate, Record> records = new TreeMap<>();

        String[] recordsPresent = recordString.split(Constants.RECORDS_DELIMITER);

        for (String r : recordsPresent) {
            String[] splitString = r.split(Constants.DATE_DELIMITER);
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(Constants.DATE_PATTERN);
            final LocalDate dt = LocalDate.parse(splitString[0], dateTimeFormatter);

            String[] symptomSplitString = splitString[1].split(Constants.SYMPTOM_DELIMITER);
            ArrayList<String> symptoms = splitStringIntoArrayList(symptomSplitString[0]);

            String[] diagnosisSplitString = symptomSplitString[1].split(Constants.DIAGNOSIS_DELIMITER);
            ArrayList<String> diagnoses = splitStringIntoArrayList(diagnosisSplitString[0]);

            String[] prescriptionSplitString = diagnosisSplitString[1].split(Constants.PRESCRIPTION_DELIMITER);
            ArrayList<String> prescriptions = splitStringIntoArrayList(prescriptionSplitString[0]);

            Record record = new Record(symptoms, diagnoses, prescriptions);

            records.put(dt, record);
        }

        return records;
    }

    private ArrayList<String> splitStringIntoArrayList(String stringToSplit) {
        String[] stringArray = stringToSplit.split(Constants.DETAILS_DELIMITER);
        ArrayList<String> arrayList = new ArrayList<>();
        for (String string : stringArray) {
            arrayList.add(string);
        }

        return arrayList;
    }
}
