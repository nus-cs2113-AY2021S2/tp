package seedu.duke;

import seedu.duke.model.Patient;
import seedu.duke.model.Record;

import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
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

                message.append(id + Constants.KEY_VALUE_SEPARATOR + records + "\n");
            }
            System.out.println(message);
            fileWriter.write(message.toString());
            fileWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String convertRecordToString(Patient patient) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Record record : patient.getRecords()) {
            stringBuilder.append(record.getConsultationDetail());
            stringBuilder.append(Constants.PATIENT_RECORDS_SEPARATOR);
        }

        return (stringBuilder.toString());
    }

    public ArrayList<Record> convertStringToRecord(String recordString) {
        String[] splitString = recordString.split(Constants.PATIENT_RECORDS_SEPARATOR);
        ArrayList<Record> records = new ArrayList<Record>();
        for (String str : splitString){
            records.add(new Record(str));
        }
        return records;
    }

    //TODO: Fix load function
    public SortedMap<String, Patient> load() throws IOException {
        SortedMap<String, Patient> data = new TreeMap<>();
        try {
            File inFile = new File(filePath);
            Scanner scanner = new Scanner(inFile);
            while (scanner.hasNextLine()) {
                String[] retrievedPatientsData = scanner.nextLine().split(Constants.KEY_VALUE_SEPARATOR);
                String id = retrievedPatientsData[0];
                ArrayList<Record> records = convertStringToRecord(retrievedPatientsData[1]);
                Patient patient = new Patient(id, records);
                data.put(id, patient);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }
}
