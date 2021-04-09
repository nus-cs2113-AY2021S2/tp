package seedu.ui;

import static seedu.duke.Constants.ADD_COMMAND;
import static seedu.duke.Constants.DELETE_COMMAND;
import static seedu.duke.Constants.FIND_COMMAND;
import static seedu.duke.Constants.HELPLINEBREAK;
import static seedu.duke.Constants.HELP_COMMAND;
import static seedu.duke.Constants.HELP_HEADER_COMMAND;
import static seedu.duke.Constants.HELP_HEADER_DESCRIPTION;
import static seedu.duke.Constants.HELP_HEADER_FORMAT;
import static seedu.duke.Constants.LISTLINEBREAK;
import static seedu.duke.Constants.LIST_COMMAND;
import static seedu.duke.Constants.MARK_BLANK;
import static seedu.duke.Constants.PATIENT_ADD_DESCRIPTION;
import static seedu.duke.Constants.PATIENT_ADD_FORMAT;
import static seedu.duke.Constants.PATIENT_DELETE_DESCRIPTION;
import static seedu.duke.Constants.PATIENT_DELETE_FORMAT;
import static seedu.duke.Constants.PATIENT_FILE_PATH;
import static seedu.duke.Constants.PATIENT_FIND_DESCRIPTION;
import static seedu.duke.Constants.PATIENT_FIND_FORMAT;
import static seedu.duke.Constants.PATIENT_HELP_DESCRIPTION;
import static seedu.duke.Constants.PATIENT_LIST_DESCRIPTION;
import static seedu.duke.Constants.RETURN_COMMAND;
import static seedu.duke.Constants.RETURN_DESCRIPTION;

public class PatientUI extends UI{

    public static void printPatientHelpList(){
        UI.printEmptyLine();
        System.out.println("Here is a list of Patient commands: ");

        UI.printEmptyLine();
        int[] lengthPara = {10,60,70};
        printer(new String[]{HELP_HEADER_COMMAND, HELP_HEADER_DESCRIPTION, HELP_HEADER_FORMAT}, lengthPara);
        System.out.println(HELPLINEBREAK);
        printer(new String[]{HELP_COMMAND, PATIENT_HELP_DESCRIPTION, MARK_BLANK}, lengthPara);
        printer(new String[]{ADD_COMMAND, PATIENT_ADD_DESCRIPTION, PATIENT_ADD_FORMAT}, lengthPara);
        printer(new String[]{LIST_COMMAND, PATIENT_LIST_DESCRIPTION, MARK_BLANK}, lengthPara);
        printer(new String[]{DELETE_COMMAND, PATIENT_DELETE_DESCRIPTION, PATIENT_DELETE_FORMAT}, lengthPara);
        printer(new String[]{FIND_COMMAND, PATIENT_FIND_DESCRIPTION, PATIENT_FIND_FORMAT}, lengthPara);
        printer(new String[]{RETURN_COMMAND, RETURN_DESCRIPTION, MARK_BLANK}, lengthPara);
        UI.printEmptyLine();
    }

    public static void patientListHeader(){
        System.out.println(
                UI.prettyPrint("ID", 8) + " | "
                        + UI.prettyPrint("Name", 20) + " | "
                        + UI.prettyPrint("Age", 6) + " | "
                        + UI.prettyPrint("Gender", 8) + " | "
                        + UI.prettyPrint("Illness", 20) + " | "
                        + UI.prettyPrint("Medication Required", 20));
        System.out.println(LISTLINEBREAK);
    }

    public static void patientAddedMessage(String name) {
        System.out.println(name + " is now a patient here!");
    }

    public static void printPatientList(String[] patientDetails){
        System.out.println(
                UI.prettyPrint(patientDetails[0], 8) + " | "
                        + UI.prettyPrint(patientDetails[1], 20) + " | "
                        + UI.prettyPrint(patientDetails[2], 6) + " | "
                        + UI.prettyPrint(patientDetails[3], 8) + " | "
                        + UI.prettyPrint(patientDetails[4], 20) + " | "
                        + UI.prettyPrint(patientDetails[5], 20));
    }

    public static void emptyPatientListMessage(){
        System.out.println("OOPS! It seems like you have no patients in the list now!");
    }

    public static void notEmptyPatientListMessage(){
        System.out.println("Here are the patients currently in the list!");
    }

    public static void deletePatientMessage(String deletedPatient, int inputInt) {
        System.out.println("Noted. I've removed this patient: \n" + deletedPatient);
        System.out.println("Now you have " + inputInt + " patients in the list");
    }

    public static void patientCommandWelcome(){
        System.out.println("Welcome to the patient Commands section!");
        System.out.println("Type \"help\" for patient menu command");
    }

    public void corruptedFileErrorMessage(){
        System.out.println("The file (" + PATIENT_FILE_PATH + ") is corrupted!\n"
                + "Please exit the program and delete the corrupted file before trying to access Patient Menu!");
    }

    public static void patientNotFoundMessage(){
        System.out.println("There is no patient in the list that matches your keywords!");
    }
}
