package seedu.ui;

import static seedu.duke.Constants.*;

public class PatientUI extends UI{

    public static void printPatientHelpList() {
        UI.printEmptyLine();
        System.out.println("Here is a list of Patient commands: ");

        UI.printEmptyLine();
        int[] lengthPara = {10,60,70};
        printer(new String[]{HELP_HEADER_COMMAND, HELP_HEADER_DESCRIPTION, HELP_HEADER_FORMAT}, lengthPara);
        UI.showLongLine();
        printer(new String[]{HELP_COMMAND, PATIENT_HELP_DESCRIPTION, MARK_BLANK}, lengthPara);
        printer(new String[]{ADD_COMMAND, PATIENT_ADD_DESCRIPTION, PATIENT_ADD_FORMAT}, lengthPara);
        printer(new String[]{LIST_COMMAND, PATIENT_LIST_DESCRIPTION, MARK_BLANK}, lengthPara);
        printer(new String[]{DELETE_COMMAND, PATIENT_DELETE_DESCRIPTION, PATIENT_DELETE_FORMAT}, lengthPara);
        printer(new String[]{FIND_COMMAND, PATIENT_FIND_DESCRIPTION, PATIENT_FIND_FORMAT}, lengthPara);
        printer(new String[]{RETURN_COMMAND, RETURN_DESCRIPTION, MARK_BLANK}, lengthPara);
        UI.printEmptyLine();
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

    public static void patientCommandWelcome() {
        System.out.println("Welcome to the patient Commands section!");
        System.out.println("Type \"help\" for patient menu command");
    }
}
