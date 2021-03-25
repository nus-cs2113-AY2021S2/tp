package seedu.ui;

public class DoctorAppointmentUI {
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
}
