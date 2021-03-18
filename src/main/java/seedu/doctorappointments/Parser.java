package seedu.doctorappointments;


public class Parser {

    public static boolean parse(String input) throws Exception {
        String[] inputArray = input.split(" ");

        switch (inputArray[0]) {
        case "add":
            AppointmentActions.addAppointment(input);
            break;
        case "list":
            AppointmentActions.listAppointment(input);
            break;
        case "delete":
            AppointmentActions.deleteAppointment(input);
            break;
        case "return":
            return true;
        case "help":
            AppointmentActions.helpAppointment();
            break;
        default:
            System.out.println("Sorry, I don't know what that means :(");
        }
        return false;
    }
}
