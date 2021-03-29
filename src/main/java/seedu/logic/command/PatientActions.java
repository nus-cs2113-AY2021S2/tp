package seedu.logic.command;

import seedu.model.Patient;
import seedu.ui.PatientUI;
import seedu.ui.UI;

import java.util.ArrayList;

public class PatientActions {
    private static ArrayList<Patient> patients = new ArrayList<Patient>();

    public PatientActions() {
    }

    public PatientActions(ArrayList<Patient> load) {
        this.patients = load;
    }

    public void addPatient(String[] argArr) {
        Patient newPatient = new Patient(argArr[0], argArr[1], Integer.parseInt(argArr[2]), argArr[3], argArr[4], argArr[5]);
        patients.add(newPatient);
    }

    public void findPatient(String inputString) {
        int numberOfPatients = patients.size();
        for (int i = 0; i < numberOfPatients; i++) {
            String patientDetails = patients.get(i).getPatientDetails();
            if (patientDetails.contains(inputString)) {
                PatientUI.printPatientList(i+1, patientDetails);
            }
        }
    }

    public boolean isIDTaken(String inputString) {
        for (Patient patient : patients) {
            String patientID = patient.getPatientID();
            if (patientID.equals(inputString)) {
                return true;
            }
        }
        return false;
    }

    public void listPatients() {
        int numberOfPatients = patients.size();
        if (numberOfPatients == 0) {
            PatientUI.emptyPatientListMessage();
        } else {
            PatientUI.notEmptyPatientListMessage();
            for (int i = 0; i < numberOfPatients; i++) {
                UI.showLine();
                PatientUI.printPatientList(i + 1, patients.get(i).getPatientDetails());
            }
        }
    }

    public void deletePatient(String inputID) {
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
        PatientUI.deletePatientMessage(patientName, patients.size());
    }

    public int getSize() {
        return patients.size();
    }

    public String toSaveFile(int i) {
        return patients.get(i).toSaveFormat();
    }
}
