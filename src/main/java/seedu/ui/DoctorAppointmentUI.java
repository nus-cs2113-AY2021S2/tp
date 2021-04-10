package seedu.ui;

import seedu.duke.Constants;
import seedu.model.doctorappointment.DoctorAppointment;

import java.text.ParseException;


public class DoctorAppointmentUI extends UI {
    public static void doctorAppointmentsWelcome() {
        System.out.println("Welcome to the Appointments' Menu!");
    }

    public static void doctorAppointmentHelp() {
        System.out.println("Here is a list of Doctor Appointments Commands: ");

        int[] lengthPara = {10, 70, 50};
        printer(new String[]{Constants.HELP_HEADER_COMMAND,
                Constants.HELP_HEADER_DESCRIPTION, Constants.HELP_HEADER_FORMAT}, lengthPara);
        UI.showLongLine();
        printer(new String[]{Constants.HELP_COMMAND, Constants.APPOINTMENTS_HELP_DESCRIPTION, Constants.MARK_BLANK},
                lengthPara);
        printer(new String[]{Constants.ADD_COMMAND,
                Constants.APPOINTMENTS_ADD_DESCRIPTION, Constants.APPOINTMENTS_ADD_FORMAT}, lengthPara);
        printer(new String[]{Constants.LIST_COMMAND,
                Constants.APPOINTMENTS_LIST_DESCRIPTION, Constants.APPOINTMENTS_LIST_FORMAT}, lengthPara);
        printer(new String[]{Constants.DELETE_COMMAND,
                Constants.APPOINTMENTS_DELETE_DESCRIPTION, Constants.APPOINTMENTS_DELETE_FORMAT}, lengthPara);
        printer(new String[]{Constants.RETURN_COMMAND, Constants.RETURN_DESCRIPTION, Constants.MARK_BLANK},
                lengthPara);
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
