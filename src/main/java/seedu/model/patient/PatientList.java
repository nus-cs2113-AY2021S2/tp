package seedu.model.patient;

import seedu.ui.PatientUI;

import java.util.ArrayList;

public class PatientList {

    private static ArrayList<Patient> patients = new ArrayList<Patient>();

    public PatientList() {
    }

    public PatientList(ArrayList<Patient> load) {
        this.patients = load;
    }

    public void addPatient(String[] argArr) {
        Patient newPatient = new Patient(argArr[0], argArr[1], Integer.parseInt(argArr[2]), argArr[3], argArr[4], argArr[5]);
        patients.add(newPatient);
    }

    public void findPatient(String inputString) {
        int numberOfPatients = patients.size();
        boolean isFound = false;
        boolean isHeaderPrinted = false;
        for (int i = 0; i < numberOfPatients; i++) {
            String patientDetails = patients.get(i).getPatientDetailsString().toLowerCase();
            String[] patientDetailsArr = patients.get(i).getPatientDetailsArray();
            if (patientDetails.contains(inputString.toLowerCase())) {
                isFound = true;
                if (!isHeaderPrinted) {
                    PatientUI.patientListHeader();
                    isHeaderPrinted = true;
                }
                PatientUI.printPatientList(patientDetailsArr);
            }
        }
        if (!isFound) {
            PatientUI.patientNotFoundMessage();
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
            PatientUI.patientListHeader();
            for (int i = 0; i < numberOfPatients; i++) {
                PatientUI.printPatientList(patients.get(i).getPatientDetailsArray());
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
