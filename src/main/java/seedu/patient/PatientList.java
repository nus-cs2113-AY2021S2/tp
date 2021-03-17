package seedu.duke;

import java.util.ArrayList;

public class PatientList {
    private static ArrayList<Patient> patients = new ArrayList<Patient>();

    public PatientList() {
    }

    public PatientList(ArrayList<Patient> load) {
        this.patients = load;
    }

    public static void addPatient(String patientID, String name, int age, String gender, String illness, String drugsNeeded) {
        Patient newPatient = new Patient(patientID, name, age, gender, illness, drugsNeeded);
        patients.add(newPatient);
        Ui.patientAddedMessage(name);
    }

    public static void findPatient(String inputString) {
        int numberOfPatients = patients.size();
        for (int i = 0; i < numberOfPatients; i++) {
            String patientDetails = patients.get(i).getPatientDetails();
            if (patientDetails.contains(inputString)) {
                Ui.printPatientList(i, patientDetails);
            }
        }
    }

    public static void listPatients() {
        int numberOfPatients = patients.size();
        if (numberOfPatients == 0) {
            Ui.emptyPatientListMessage();
        } else {
            Ui.notEmptyPatientListMessage();
            for (int i = 0; i < numberOfPatients; i++) {
                Ui.printPatientList(i, patients.get(i).getPatientDetails());
            }
        }
    }

    public static void deletePatient(int inputInt) {
        int patientIndex = inputInt - 1;
        if (inputInt <= 0 || inputInt > patients.size()) {
            Ui.incorrectInput();
        }
        Patient toBeDeleted = patients.get(patientIndex);
        patients.remove(patientIndex);
        Ui.deletePatientMessage(toBeDeleted.getPatientDetails(), patients.size());
    }

    public int getSize() {
        return patients.size();
    }

    public String toSaveFile(int i) {
        return patients.get(i).toSaveFormat();
    }
}
