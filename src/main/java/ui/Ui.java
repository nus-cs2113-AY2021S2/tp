package ui;

public class Ui {
    public static void printWelcomeMessage() {
        System.out.println("Welcome to fast scheduler!");
    }

    public static void printExitMessage() {
        System.out.println("Bye, hope to see you again soon!");
    }

    public static void printHelpMessage() {
        System.out.println("Command options available:\n");
        System.out.println("add employee (add a new employee to the database)");
        System.out.println("add schedule (add a new schedule to an employee)");
        System.out.println("drop schedule (drop an existing schedule from an employee)");
        System.out.println("add shift (add a new shift for the restaurant)");
        System.out.println("assign employee (assign an employee to a shift)");
        System.out.println("unassign employee (unassign an employee from a shift)");
        System.out.println("view employee schedule (displays all schedules of an employee)");
        System.out.println("view shift status (displays all shifts and the name of the employees on the shifts)");
        System.out.println("view one shift (displays the name of the employees on a shift)");
        System.out.println("list (displays the name of all employees)");
        System.out.println("quit (quit the application)");
    }

    public static void printInvalidScheduleFeedbackMessage(){
        System.out.println("schedule must be in the format: dd/mm/yyyy");
        System.out.println("dd must be an integer between 1-31 for odd months, 1-30 for even months, 1-28 for Feb");
        System.out.println("mm must be an integer between 1-12");
        System.out.println("yyyy must be an integer between 2021-2099");
    }
}
