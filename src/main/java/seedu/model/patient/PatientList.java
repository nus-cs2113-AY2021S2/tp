package seedu.model.patient;

import seedu.ui.PatientUI;

import java.util.ArrayList;

/**
 * Represents the list of all patients in the hospital.
 */
public class PatientList {

    private static ArrayList<Patient> patients = new ArrayList<Patient>();

    public PatientList() {
    }

    public PatientList(ArrayList<Patient> load) {
        this.patients = load;
    }

    /**
     * Adds a patient to the list of patients.
     *
     * @param patientDetailsArr the details of the patient to be added.
     */
    public void addPatient(String[] patientDetailsArr) {
        Patient newPatient = new Patient(patientDetailsArr[0], patientDetailsArr[1],
                Integer.parseInt(patientDetailsArr[2]), patientDetailsArr[3], patientDetailsArr[4],
                patientDetailsArr[5]);
        patients.add(newPatient);
    }

    /**
     * Finds a patient with details macthing the keyword inputted by the user.
     *
     * @param inputString the specific keyword that the user is searching for.
     */
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

    /**
     * Checks through the list of patients for a matching ID.
     *
     * @param inputString the ID that the method is trying to find.
     * @return true if there is a matching ID found, false if there is not.
     */
    public boolean isIdTaken(String inputString) {
        for (Patient patient : patients) {
            String patientID = patient.getPatientID();
            if (patientID.equals(inputString)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Lists all patients currently in the list.
     */
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

    /**
     * Deletes a patient from the list of current patients.
     *
     * @param inputID the ID of the patients who is supposed to be removed.
     */
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
