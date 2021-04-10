package seedu.duke.model;

import seedu.duke.Constants;

import java.util.LinkedHashSet;

/**
 * Each instance of this class represent a visit record. It can contain
 * medical diagnosis, prescription, test results, etc.
 */
public class Record {
    protected LinkedHashSet<String> symptoms;
    protected LinkedHashSet<String> diagnoses;
    protected LinkedHashSet<String> prescriptions;

    /**
     * Initialize a new visit record.
     */
    public Record() {
        this.symptoms = new LinkedHashSet<>();
        this.diagnoses = new LinkedHashSet<>();
        this.prescriptions = new LinkedHashSet<>();
    }

    /**
     * Generates a record with existing data.
     *
     * @param symptoms      existing symptoms data
     * @param diagnoses     existing diagnoses data
     * @param prescriptions existing prescriptions data
     */
    public Record(
            LinkedHashSet<String> symptoms,
            LinkedHashSet<String> diagnoses,
            LinkedHashSet<String> prescriptions
    ) {
        this.symptoms = symptoms;
        this.diagnoses = diagnoses;
        this.prescriptions = prescriptions;
    }

    /**
     * Obtain the consultation detail of this record.
     *
     * @return A String containing the consultation details contained in this record
     */
    public String getConsultationDetail() {
        String consultationDetail = "";
        if (!symptoms.isEmpty()) {
            consultationDetail += extractField("Symptoms", symptoms);
        }
        if (!diagnoses.isEmpty()) {
            consultationDetail += extractField("Diagnoses", diagnoses);
        }
        if (!prescriptions.isEmpty()) {
            consultationDetail += extractField("Prescriptions", prescriptions);
        }
        return consultationDetail;
    }

    private String extractField(String fieldName, LinkedHashSet<String> field) {
        String fieldString = "";
        if (field.isEmpty()) {
            return fieldString;
        }
        fieldString += fieldName + ":" + System.lineSeparator();
        for (String string : field) {
            fieldString += Constants.INDENT + string + System.lineSeparator();
        }
        return fieldString;
    }

    /**
     * Obtain a print-friendly consultation detail of this record for the storage file.
     *
     * @return A String containing the consultation details contained in this record, separated by delimiters.
     */
    public String printFileConsultationDetail() {
        String consultationDetail = "";
        for (String symptom : symptoms) {
            consultationDetail += symptom + Constants.DETAILS_DELIMITER;
        }
        consultationDetail += Constants.SYMPTOM_DELIMITER;
        for (String diagnosis : diagnoses) {
            consultationDetail += diagnosis + Constants.DETAILS_DELIMITER;
        }
        consultationDetail += Constants.DIAGNOSIS_DELIMITER;
        for (String prescription : prescriptions) {
            consultationDetail += prescription + Constants.DETAILS_DELIMITER;
        }
        consultationDetail += Constants.PRESCRIPTION_DELIMITER;
        return consultationDetail;
    }

    @Override
    public String toString() {
        return getConsultationDetail();
    }

    /**
     * This adds 3 different type of details into this record.
     *
     * @param symptom      symptoms of the patient
     * @param diagnosis    diagnosis based on patient's symptoms and other tests
     * @param prescription prescription given for this visit
     */
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
