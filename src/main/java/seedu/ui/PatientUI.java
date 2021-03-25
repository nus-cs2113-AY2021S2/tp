package seedu.ui;

public class PatientUI extends UI{
    public static void printPatientHelpList() {
        System.out.println("Here is a list of patient commands: ");
        System.out.println("\"help\" brings up this list of commands!");
        System.out.println("\"add [Patient ID] [Name] [Age] [Gender] [Illness] [Drugs Needed]\" " +
                "adds a patient to the patient list!");
        System.out.println("*The name must not have a space included!");
        System.out.println("*The patient ID must start with a \"P\" and have a 5 digit number after! eg. P12345");
        System.out.println("*The age must be an integer!");
        System.out.println("\"list\" brings up the list of all current patients!");
        System.out.println("\"delete [Patient ID]\" deletes the patient with the ID from the list!");
        System.out.println("\"find [Patient ID]\" finds the corresponding patient that matches the ID!");
        System.out.println("\"return\" returns you to the Start Menu!");
        System.out.println("Please take note the follow the number of parameters in each command strictly!");
    }

    public static void patientAddedMessage(String name) {
        System.out.println(name + " is now a patient here!");
    }

    public static void printPatientList(int i, String patientDetails) {
        System.out.println(i + "." + patientDetails);
    }

    public static void emptyPatientListMessage() {
        System.out.println("OOPS! It seems like you have no patients in the list now!");
    }

    public static void notEmptyPatientListMessage() {
        System.out.println("Here are the patients currently in the list!");
    }

    public static void deletePatientMessage(String deletedPatient, int inputInt) {
        System.out.println("Noted. I've removed this patient: \n" + deletedPatient);
        System.out.println("Now you have " + inputInt + " patients in the list");
    }

    public static void patientMenuPrompt() {
        System.out.print("Patient --> ");
    }

    public static void patientCommandWelcome() {
        System.out.println("Welcome to the patient Commands section!");
        System.out.println("Here is a list of patient commands: ");
        System.out.println("\"add [Patient ID] [Name] [Age] [Gender] [Illness] [Drugs Needed]\" adds a patient to the patient list!");
        System.out.println("\"list\" brings up the list of all current patients!");
        System.out.println("\"delete [Patient ID]\" deletes the patient with the ID from the list!");
        System.out.println("\"find [Patient ID]\" finds the corresponding patient that matches the ID!");
        System.out.println("\"help\" brings up a list of commands!");
        System.out.println("\"return\" returns you to the Start Menu!");
    }
}
