package seedu.ui;

import seedu.model.doctorappointment.DoctorAppointment;

import java.text.ParseException;

import static seedu.duke.Constants.HELP_HEADER_COMMAND;
import static seedu.duke.Constants.HELP_COMMAND;
import static seedu.duke.Constants.HELP_HEADER_DESCRIPTION;
import static seedu.duke.Constants.HELP_HEADER_FORMAT;
import static seedu.duke.Constants.APPOINTMENTS_ADD_FORMAT;
import static seedu.duke.Constants.APPOINTMENTS_DELETE_DESCRIPTION;
import static seedu.duke.Constants.APPOINTMENTS_DELETE_FORMAT;
import static seedu.duke.Constants.APPOINTMENTS_ADD_DESCRIPTION;
import static seedu.duke.Constants.MARK_BLANK;
import static seedu.duke.Constants.APPOINTMENTS_HELP_DESCRIPTION;
import static seedu.duke.Constants.ADD_COMMAND;
import static seedu.duke.Constants.LIST_COMMAND;
import static seedu.duke.Constants.APPOINTMENTS_LIST_DESCRIPTION;
import static seedu.duke.Constants.APPOINTMENTS_LIST_FORMAT;
import static seedu.duke.Constants.DELETE_COMMAND;
import static seedu.duke.Constants.RETURN_COMMAND;
import static seedu.duke.Constants.RETURN_DESCRIPTION;


public class DoctorAppointmentUI extends UI {
    public static void doctorAppointmentsWelcome() {
        System.out.println("Welcome to the Appointments' Menu!");
    }

    public static void doctorAppointmentHelp() {
        System.out.println("Here is a list of Doctor Appointments Commands: ");

        int[] lengthPara = {10, 70, 50};
        printer(new String[]{HELP_HEADER_COMMAND, HELP_HEADER_DESCRIPTION, HELP_HEADER_FORMAT}, lengthPara);
        UI.showLongLine();
        printer(new String[]{HELP_COMMAND, APPOINTMENTS_HELP_DESCRIPTION, MARK_BLANK}, lengthPara);
        printer(new String[]{ADD_COMMAND, APPOINTMENTS_ADD_DESCRIPTION, APPOINTMENTS_ADD_FORMAT}, lengthPara);
        printer(new String[]{LIST_COMMAND, APPOINTMENTS_LIST_DESCRIPTION, APPOINTMENTS_LIST_FORMAT}, lengthPara);
        printer(new String[]{DELETE_COMMAND, APPOINTMENTS_DELETE_DESCRIPTION, APPOINTMENTS_DELETE_FORMAT}, lengthPara);
        printer(new String[]{RETURN_COMMAND, RETURN_DESCRIPTION, MARK_BLANK}, lengthPara);
        UI.printEmptyLine();
    }

    public void printAppointmentMenuPrompt() {
        System.out.println("Type 'help' for appointment menu commands\n");
    }


    public static void printAddedAppointment() {
        System.out.println("Appointment Added");
    }

    public static void deletedDocID(String doctorId, String appointmentId) {
        System.out.println("DoctorID / Appointment ID: " + doctorId + "/" + appointmentId + " has been deleted!");
    }

    public static void deletedAptID(String appointmentId) {
        System.out.println("Appointment ID: " + appointmentId + " has been deleted!");
    }

    public static void printList(DoctorAppointment doc, String indicator) throws ParseException {
        if (indicator.equals("all")) {
            printEmptyCell(doc.getDoctorId());
        }
        printEmptyCell(doc.getAppointmentId());
        printEmptyCell(doc.getPatientsName());
        printEmptyCell(doc.getGender());
        System.out.print(doc.getDateFormat(doc.getDate()));
        System.out.print("\n");

    }

    public static void appointmentPrintList(String indicator) {
        if (indicator.equals("D") || indicator.equals("all")) {
            System.out.println(
                    UI.prettyPrint("Doctor ID", 14) + " | " + UI.prettyPrint("Appointment ID",
                            14) + " | " + UI.prettyPrint("Name", 14) + " | "
                            + UI.prettyPrint("Gender", 14) + " | " + UI.prettyPrint("Date",
                            14));
        } else {
            System.out.println(
                    UI.prettyPrint("Appointment ID", 14) + " | " + UI.prettyPrint("Name",
                            14) + " | "
                            + UI.prettyPrint("Gender", 14) + " | " + UI.prettyPrint("Date",
                            14));
        }
    }

    public static void printEmptyCell(String s) {
        System.out.print(UI.prettyPrint(s, 14) + " | ");
    }

    public static void corruptedFileErrorMessage() {
        System.out.println("File (data/DoctorAppointment.txt) is corrupted. Please delete the file "
                + "before running the Doctor Appointment Menu.");
    }

    public static void printNewLine() {
        System.out.print("\n");
    }


}
