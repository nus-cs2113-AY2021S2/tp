package seedu.ui;

import seedu.model.DoctorAppointment;

import java.text.ParseException;

public class DoctorAppointmentUI extends UI {
    public static void doctorAppointmentsWelcome() {
        System.out.println("Welcome to the Appointments' Menu!");
    }

    public static void doctorAppointmentHelp() {
        System.out.println("Welcome to the Appointments Commands section!");
        System.out.println("Here is a list of doctor appointments commands: ");
        System.out.println("\"add [Doctor ID] [Patient's Name] [Gender] [DDMMYYYY]\" adds a appointment to the appointment list!");
        System.out.println("\"list [Doctor ID]\" brings up the list of current appointments for the doctor!");
        System.out.println("\"delete [Appointment ID]\" deletes the appointment with the indicated ID from the list!");
        System.out.println("\"help\" brings up a list of commands!");
        System.out.println("\"return\" returns you to the Start Menu!");
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

}
