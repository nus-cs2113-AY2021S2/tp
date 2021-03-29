package seedu.duke.model;

import seedu.duke.Constants;

import java.util.ArrayList;

/**
 * Each instance of this class represent a visit record. It can contain
 * medical diagnosis, prescription, test results, etc.
 */
public class Record {
    protected ArrayList<String> symptoms;
    protected ArrayList<String> diagnoses;
    protected ArrayList<String> prescriptions;

    /**
     * Initialize a new visit record.
     */
    public Record() {
        this.symptoms = new ArrayList<>();
        this.diagnoses = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
    }

    /**
     * Obtain the consultation detail of this record.
     *
     * @return A String containing the consultation details contained in this record
     */
    public String getConsultationDetail() {
        String consultationDetail = "";
        consultationDetail += "Symptoms:" + System.lineSeparator();
        for (String symptom : symptoms) {
            consultationDetail += "\t" + symptom + System.lineSeparator();
        }
        consultationDetail += "Diagnoses:" + System.lineSeparator();
        for (String diagnosis : diagnoses) {
            consultationDetail += "\t" + diagnosis + System.lineSeparator();
        }
        consultationDetail += "Prescriptions:" + System.lineSeparator();
        for (String prescription : prescriptions) {
            consultationDetail += "\t" + prescription + System.lineSeparator();
        }
        return consultationDetail;
    }

    public String printFileConsultationDetail() {
        String consultationDetail = "";
        for (String symptom : symptoms) {
            consultationDetail += symptom + "\t";
        }
        consultationDetail += Constants.SYMPTOM_DELIMITER;
        for (String diagnosis : diagnoses) {
            consultationDetail += diagnosis + "\t";
        }
        consultationDetail += Constants.DIAGNOSIS_DELIMITER;
        for (String prescription : prescriptions) {
            consultationDetail += prescription + "\t";
        }
        consultationDetail += Constants.PRESCRIPTION_DELIMITER;
        return consultationDetail;
    }

    @Override
    public String toString() {
        return getConsultationDetail();
    }

    public void addDetails(String symptom, String diagnosis, String prescription) {
        if (symptom != null) {
            symptoms.add(symptom);
        }
        if (diagnosis != null) {
            diagnoses.add(diagnosis);
        }
        if (prescription != null) {
            prescriptions.add(prescription);
        }
    }
}
