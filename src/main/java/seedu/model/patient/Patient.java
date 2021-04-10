package seedu.model.patient;

/**
 * Represents a Patient within the hospital's database.
 */
public class Patient {
    protected String patientID;
    protected String name;
    protected int age;
    protected String gender;
    protected String illness;
    protected String medicationNeeded;
    protected String[] patientDetails;

    public Patient(String patientID, String name, int age, String gender, String illness, String drugsNeeded) {
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.illness = illness;
        this.medicationNeeded = drugsNeeded;
        this.patientDetails = new String[] {patientID, name, String.valueOf(age), gender, illness, medicationNeeded};
    }

    /**
     * This method returns the patients details in the form of an array.
     * This data format is used by most of the methods.
     *
     * @return patient details in array format.
     */
    public String[] getPatientDetailsArray() {
        return (patientDetails);
    }

    /**
     * This method returns the patient's details in a string format.
     * This data format is used for methods which finding specific patient details.
     *
     * @return patient details in string format.
     */
    public String getPatientDetailsString() {
        return (patientID
                + " | "
                + name
                + " | "
                + age
                + " | "
                + gender
                + " | "
                + illness
                + " | "
                + medicationNeeded);
    }

    public String getPatientID() {
        return this.patientID;
    }

    public String getPatientName() {
        return this.name;
    }

    /**
     * This method returns the patient's details in a string format.
     * This data format is used for storing a patient's details.
     *
     * @return patient details in string format.
     */
    public String toSaveFormat() {
        return (patientID
                + "|"
                + name
                + "|"
                + age
                + "|"
                + gender
                + "|"
                + illness
                + "|"
                + medicationNeeded);
    }
}
