package seedu.duke;

import seedu.duke.exception.StorageException;
import seedu.duke.model.Patient;
import seedu.duke.model.Record;

import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.LinkedHashSet;
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
    private String filePath;

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
     *
     * @param patientData The data to be written to file
     * @throws StorageException when unusual events happen during file saving
     */
    public void save(SortedMap<String, Patient> patientData) throws StorageException {
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
            throw new StorageException(StorageException.Type.FILE_CREATION_FAIL, e);
        } catch (IOException e) {
            throw new StorageException(StorageException.Type.FILE_WRITE_FAIL, e);
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
     * @throws StorageException when unusual events happen during file loading
     */
    public SortedMap<String, Patient> load() throws StorageException {
        SortedMap<String, Patient> data = new TreeMap<>();
        try {
            File inFile = new File(filePath);
            // If inFile does not exist, FNF Exception will be triggered and captured below
            Scanner scanner = new Scanner(inFile);
            while (scanner.hasNextLine()) {
                String[] retrievedPatientsData = scanner.nextLine().split(Constants.ID_DELIMITER);
                String id = retrievedPatientsData[0];
                Patient patient;
                if (retrievedPatientsData.length > 1) {
                    patient = new Patient(id, convertStringToRecords(retrievedPatientsData[1]));
                } else {
                    patient = new Patient(id);
                }
                data.put(id, patient);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new StorageException(StorageException.Type.FILE_NOT_FOUND, e);
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

            LinkedHashSet<String> prescriptions = new LinkedHashSet<>();
            LinkedHashSet<String> symptoms = new LinkedHashSet<>();
            LinkedHashSet<String> diagnoses = new LinkedHashSet<>();

            String[] symptomSplitString = splitString[1].split(Constants.SYMPTOM_DELIMITER);
            if (!symptomSplitString[0].isEmpty()) {
                symptoms = splitDetailString(symptomSplitString[0]);
            }

            String[] diagnosisSplitString = symptomSplitString[1].split(Constants.DIAGNOSIS_DELIMITER);
            if (!diagnosisSplitString[0].isEmpty()) {
                diagnoses = splitDetailString(diagnosisSplitString[0]);
            }

            String[] prescriptionSplitString = diagnosisSplitString[1].split(Constants.PRESCRIPTION_DELIMITER);
            if (prescriptionSplitString.length > 0) {
                prescriptions = splitDetailString(prescriptionSplitString[0]);
            }

            Record record = new Record(symptoms, diagnoses, prescriptions);

            records.put(dt, record);
        }

        return records;
    }

    /**
     * This function splits a string using DETAILS_DELIMITER, then create a new arraylist and add it in.
     * @param stringToSplit the string that is to be splitted using DETAILS_DELIMITER
     * @return a LinkedHashSet containing the data
     */
    private LinkedHashSet<String> splitDetailString(String stringToSplit) {
        String[] stringArray = stringToSplit.split(Constants.DETAILS_DELIMITER);
        LinkedHashSet<String> arrayList = new LinkedHashSet<>();
        for (String string : stringArray) {
            arrayList.add(string);
        }

        return arrayList;
    }

    //@@author fsgmhoward
    /**
     * This is the getter for filePath.
     * @return the file path of save file used by this storage instance
     */
    public String getFilePath() {
        return filePath;
    }
}
