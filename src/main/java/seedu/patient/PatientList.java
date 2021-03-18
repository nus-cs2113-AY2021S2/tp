package seedu.patient;

import seedu.duke.ui.UI;

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
        UI.patientAddedMessage(name);
    }

    public static void findPatient(String inputString) {
        int numberOfPatients = patients.size();
        for (int i = 0; i < numberOfPatients; i++) {
            String patientDetails = patients.get(i).getPatientDetails();
            if (patientDetails.contains(inputString)) {
                UI.printPatientList(i, patientDetails);
            }
        }
    }

    public static boolean isIDTaken(String inputString) {
        int numberOfPatients = patients.size();
        for (int i = 0; i < numberOfPatients; i++) {
            String patientID = patients.get(i).getPatientID();
            if (patientID.equals(inputString)) {
                return true;
            }
        }
        return false;
    }

    public static void listPatients() {
        int numberOfPatients = patients.size();
        if (numberOfPatients == 0) {
            UI.emptyPatientListMessage();
        } else {
            UI.notEmptyPatientListMessage();
            for (int i = 0; i < numberOfPatients; i++) {
                UI.showLine();
                UI.printPatientList(i+1, patients.get(i).getPatientDetails());
            }
        }
    }

    public static void deletePatient(String inputID) {
        int patientIndex = 0;
        String patientName = null;
        for (int i = 0; i < patients.size(); i++) {
            Patient patientTemp = patients.get(i);
            String tempID = patientTemp.getPatientID();
            String tempName = patientTemp.getPatientName();
            if (tempID.equals(inputID)) {
                patientIndex = i;
                patientName = tempName;
                break;
            }
        }
        patients.remove(patientIndex);
        UI.deletePatientMessage(patientName, patients.size());
    }

    public int getSize() {
        return patients.size();
    }

    public String toSaveFile(int i) {
        return patients.get(i).toSaveFormat();
    }
}
