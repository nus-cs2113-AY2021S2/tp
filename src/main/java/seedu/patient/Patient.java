package seedu.patient;

public class Patient {
    protected String patientID;
    protected String name;
    protected int age;
    protected String gender;
    protected String illness;
    protected String drugsNeeded;

    public Patient(String patientID, String name, int age, String gender, String illness, String drugsNeeded) {
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.illness = illness;
        this.drugsNeeded = drugsNeeded;
    }

    public String getPatientDetails() {
        return ("ID: " + patientID + " \n" +
                "name: " + name + " \n" +
                "age: " + age + " \n" +
                "gender: " + gender + " \n" +
                "illness: " + illness + " \n" +
                "drugsNeeded: " + drugsNeeded);
    }

    public String getPatientID() {
        return this.patientID;
    }

    public String getPatientName() {
        return this.name;
    }

    public String toSaveFormat() {
        return (patientID + " | " + name + " | " + age + " | " +
                gender + " | " + illness + " | " + drugsNeeded);
    }
}
