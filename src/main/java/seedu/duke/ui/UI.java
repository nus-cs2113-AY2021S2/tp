package seedu.duke.ui;
import java.util.Scanner;

public class UI {

    static Scanner scanner = new Scanner(System.in);
    static String LINEBREAK = "____________________________________________________________";
    static String LOGO = " __   __  ______  _______  _  ________  __   __  __  __  _______  __   __  _             __   \n"
            + "|  | |  ||   ___||   _   || ||___    _||  | |  ||  ||  ||   _   ||  | |  || | _   _     /  \\  \n"
            + "|  |_|  ||  |___ |  |_|  || |    |  |  |  |_|  ||  ||  ||  |_|  ||  | |  || || |_| |___/ / \\\\ \n"
            + "|   _   ||   ___||   _   || |    ||=|  |   _   |\\  \\/  /|   _   ||  | |  || ||_________  | | |\n"
            + "|  | |  ||  |___ |  | |  || |___ ||=|  |  | |  | \\    / |  | |  ||  |_|  || |_____     \\ \\ // \n"
            + "|__| |__||______||__| |__||_____||__|  |__| |__|  \\__/  |__| |__||_______||_______|     \\__/  \n";

    public static String scanInput() {
        String input = scanner.nextLine().trim();
        return input;
    }

    public static void printPatientHelpList() {
        System.out.println("Here is a list of patient commands: ");
        System.out.println("\"help\" brings up this list of commands!");
        System.out.println("\"add [Patient ID] [Name] [Age] [Gender] [Illness] [Drugs Needed]\" adds a patient to the patient list!");
        System.out.println("*The name must not have a space included!");
        System.out.println("*The patient ID must start with a \"P\" and have a 5 digit number after! eg. P12345");
        System.out.println("*The age must be an integer!");
        System.out.println("\"list\" brings up the list of all current patients!");
        System.out.println("\"delete [Patient ID]\" deletes the patient with the ID from the list!");
        System.out.println("\"find [Patient ID]\" finds the corresponding patient that matches the ID!");
        System.out.println("\"return\" returns you to the Start Menu!");
        System.out.println("Please take note the follow the number of parameters in each command strictly!");
    }

    public static void unrecognizedCommandMessage() {
        System.out.println("OOPS! I cant recognize that command! ");
    }
    public static void noCommandErrorMessage() {
        System.out.println("OOPS! There is no command entered! ");
    }

    public static void invalidFormatMessage() {
        System.out.println("OOPS! Please check to see if your command is properly formatted! ");
    }

    public static void showLine() {
        System.out.println(LINEBREAK);
    }

    public static void emptyLine() {
        System.out.print("\n");
    }

    public static void printWelcome() {
        System.out.println("Welcome to \n" + LOGO + "What is your name?");
        showLine();
    }

    public static void printUserName(String userName) {
        System.out.println("Hello " + userName + "!");
        showLine();
    }

    public static void printStartMenu() {
        System.out.println("Start Menu");
        System.out.println("Commands:");
        System.out.println("\"1\" to go to staff");
        System.out.println("\"2\" to go to patients");
        System.out.println("\"3\" to go to doctors appointments");
        System.out.println("\"4\" to go to nurse schedules");
        System.out.println("\"5\" to go to drugs inventory");
        System.out.println("\"help\" to see what each of the sections contain");
        System.out.println("\"bye\" to exit the application");
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

    public static void incorrectInput() {
        System.out.println("OOPS! Please check to see if your command is properly formatted! ");
    }

    public static void deletePatientMessage(String deletedPatient, int inputInt) {
        System.out.println("Noted. I've removed this patient: \n" + deletedPatient);
        System.out.println("Now you have " + inputInt + " patients in the list");
    }

    public static void printGoodbye() {
        System.out.println("Goodbye! Have a nice day!");
    }

    public static void patientMenuPrompt() {
        System.out.print("Patient --> ");
    }

    public static void startMenuPrompt() {
        System.out.print("Start Menu --> ");
    }

    public static void userNamePrompt() {
        System.out.print("User Name --> ");
    }

    public void patientCommandWelcome() {
        System.out.println("Welcome to the patient Commands section!");
        System.out.println("Here is a list of patient commands: ");
        System.out.println("\"add [Patient ID] [Name] [Age] [Gender] [Illness] [Drugs Needed]\" adds a patient to the patient list!");
        System.out.println("\"list\" brings up the list of all current patients!");
        System.out.println("\"delete [Patient ID]\" deletes the patient with the ID from the list!");
        System.out.println("\"find [Patient ID]\" finds the corresponding patient that matches the ID!");
        System.out.println("\"help\" brings up a list of commands!");
        System.out.println("\"return\" returns you to the Start Menu!");
    }

    public static void returningToStartMenuMessage() {
        System.out.println("Returning to start Menu!");
    }

    public void showLoadingError() {
        System.out.println("OOPS! There was an error loading the file!");
    }


    public static void hiredOutput(String line) {
        if (line.split(" ")[1].charAt(0) == 'D') {
            try {
                System.out.println("Doctor " + line.split(" ")[2] + " hired!");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Unknown Doctor hired!");
            }
        }
        else if (line.split(" ")[1].charAt(0) == 'N') {
            try {
                System.out.println("Nurse " + line.split(" ")[2] + " hired!");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Unknown Doctor hired!");
            }
        }
    }

    public static void firedOutput(String line) {
        System.out.println(line.split(" ")[1] + " has been fired.");
    }

    public static void staffDoesNotExist(String line) {
        System.out.println("Staff with ID: " + line.split(" ")[1]+ " does not exist");
    }

    public static String prettyPrint(String string, int length) {
        return String.format("%1$-" + length + "s", string);
    }

    public static String repeat(int count, String with) {
        return new String(new char[count]).replace("\0", with);
    }

    public static void staffListHeader() {
        System.out.println(
                prettyPrint("ID", 10) + " | " + prettyPrint("Name", 10) + " | "
                        + prettyPrint("Age",5) + " | " + prettyPrint("Specialisation", 20));
    }

    public static void printStaffHelpList() {
        System.out.println("Here is a list of Staff commands: ");
        System.out.println("\"help\" brings up this list of commands!");
        System.out.println("\"add [Staff ID] [Name] [Age] [Specialisation]\" adds a Staff to the staff list!");
        System.out.println("\"list\" brings up the list of all current staff!");
        System.out.println("\"delete [Staff ID]\" deletes the staff with the specified ID from the list!");
        System.out.println("\"find [keyword or phrase]\" finds a keyword or phrase and shows its corresponding staff!");
        System.out.println("\"return\" returns you to the Start Menu!");
    }

    public static void WrongStaffIDErrorMessage() {
        System.out.println("Error in Staff ID input\nPlease input with the following format [D/N][5 digit ID number]");
    }

    public static void WrongListInputErrorMessage() {
        System.out.println("Invalid List command parameter\nPlease input with the following format:\n\tlist\n\tlist nurses\n\tlist doctors");
    }

    public static void NoInputErrorMessage() {
        System.out.println("Command is missing input parameter");
    }
    public static void staffMenuPrompt() {
        System.out.print("Staff --> ");
    }
    public static void staffMenuHeader() {
        System.out.print("Welcome to Staff Menu!\nType \"help\" for staff menu commands\n\n");
    }

    public static boolean isListTypo() {
        Scanner in = new Scanner(System.in);
        String input;
        System.out.println("Do you mean \"list\" (y/n)");
        input = in.nextLine();
        return input.equals("y");
    }

    public static boolean isFindTypo() {
        Scanner in = new Scanner(System.in);
        String input;
        System.out.println("Do you mean \"find\" (y/n)");
        input = in.nextLine();
        return input.equals("y");
    }

    public static void doctorAppointmentsWelcome(){
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
