package seedu.model.patient;

import java.util.Locale;

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

    public String[] getPatientDetailsArray() {
        return (patientDetails) ;
    }

    public String getPatientDetailsString() {
        return(patientID + " | " + name + " | " + age + " | " + gender + " | " + illness + " | " + medicationNeeded);
    }

    public String getPatientID() {
        return this.patientID;
    }

    public String getPatientName() {
        return this.name;
    }

    public String toSaveFormat() {
        return (patientID + " | " + name + " | " + age + " | " +
                gender + " | " + illness + " | " + medicationNeeded);
    }
}
