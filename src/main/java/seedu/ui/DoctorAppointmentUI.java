package seedu.ui;

import seedu.model.DoctorAppointment;

import java.text.ParseException;

import static seedu.duke.Constants.*;
import static seedu.duke.Constants.MARK_BLANK;

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

    public static void invalidCommandPrompt() {
        System.out.println("Sorry, I don't know what that means :(");
        UI.showLine();
    }

    public static void printAddedAppointment() {
        System.out.println("Appointment Added");
    }

    public static void deletedDocID(String DocID, String AptID) {
        System.out.println("DoctorID / Appointment ID: " + DocID + "/" + AptID + " has been deleted!");
    }

    public static void deletedAptID(String AptID) {
        System.out.println("Appointment ID: " + AptID + " has been deleted!");
    }

    public static void printList(DoctorAppointment doc, String indicator) throws ParseException {
        if (indicator.equals("D")) {
            System.out.println("Doctor ID: " + doc.getDoctorId());
        }
        System.out.println("Appointment ID: " + doc.getAppointmentId());
        System.out.println("Patient's Name: " + doc.getPatientsName());
        System.out.println("Gender: " + doc.getGender());
        System.out.println("Date: " + doc.getDateFormat(doc.getDate()));
        System.out.print("\n");

    }

    public static void AptPrintList(DoctorAppointment doc, String indicator) {
        if (indicator.equals("D")) {
            System.out.println(
                    UI.prettyPrint("Doctor ID", 10) + " | " + UI.prettyPrint("Appointment ID", 10) + " | " + UI.prettyPrint("Name", 10) + " | "
                            + UI.prettyPrint("Gender", 10) + UI.prettyPrint("Date", 10));
        } else {
            System.out.println(
                    UI.prettyPrint("Appointment ID", 10) + " | " + UI.prettyPrint("Name", 10) + " | "
                            + UI.prettyPrint("Gender", 10) + UI.prettyPrint("Date", 10));
        }
    }

}
