package seedu.allinonenus.capcalculatorclasses.uiforcapcalculator;

import seedu.allinonenus.capcalculatorclasses.commandsforcapcalculator.ModuleData;
import seedu.allinonenus.capcalculatorclasses.exceptionsforcapcalculator.EmptyLineException;

import java.util.Scanner;

public class UiText {

    public static final int SEPARATOR_LENGTH = 72;
    private static final String SEPARATOR = "-".repeat(SEPARATOR_LENGTH);
    private final Scanner in;

    public UiText() {
        in = new Scanner(System.in);

    }

    public String readCommand() throws EmptyLineException {

        String info = in.nextLine();
        if (info.isEmpty()) {
            throw new EmptyLineException();
        }
        return info;
    }

    public void greetUser() {
        System.out.print("Welcome to All-In-One-NUS Cap Calculator\n");

    }

    public void getHelp() {
        System.out.print("Invalid command: Please type \"help\" should you require assistance\n");
    }

    public void listManual() {
        System.out.print("Here are the list of commands available :\n"
                + "_______________________________________________\n"
                + "1. [add] - adds your module data\n"
                + "   Format: add [Module Code] [Grade] [MCs]\n"
                + "   Example: add CS1231 A- 4\n"
                + "_______________________________________________\n"
                + "2. [delete] - delete specified module data\n"
                + "   Format: delete [Module Code]\n"
                + "   Example: delete CS1231\n"
                + "_______________________________________________\n"
                + "3. [list] - lists your current semester's module data, CAP for your\n"
                + "   current semester and overall CAP for Sem 1 to your current semester\n"
                + "   Format: list\n"
                + "_______________________________________________\n"
                + "4. [edit] - make edits to your module data\n"
                + "   Format: 1. edit [Module code]\n"
                + "           2. [new grade]\n"
                + "   Example: edit CS1231\n"
                + "        A+\n"
                + "_______________________________________________\n"
                + "5. [view] - view module and CAP information for Year a Semester b\n"
                + "   Format: view YaSb\n"
                + "   Example: as a Year 2 sem 2 student you will have to type:\n"
                + "   view Y2S2\n"
                + "_______________________________________________\n"
                + "6. [show] - Show all modules from semester 1 to your current sem\n"
                + "   Format: show\n"
                + "_______________________________________________\n"
                + "7. [goal] - simulate the CAP you should get in order to attain your desired overall CAP\n"
                + "   IMPORTANT NOTE: Please fill your current semester with modules you are currently taking\n"
                + "   This includes arbitrary grades and the number of MCs of the modules\n"
                + "   Format: goal [Desired overall CAP]\n"
                + "   Example: goal 4.5\n"
                + "_______________________________________________\n"
                + "8. [update] - update your current student status should you commence to the next semester\n"
                + "   Format: update YaSb\n"
                + "   Example: if you are going to be a year 3 sem 1 student you will have to type:\n"
                + "   update Y3S1\n"
                + "_______________________________________________\n"
                + "9. [exit] - exit CAP Calculator\n"
                + "   Format: exit\n"
                + "_______________________________________________\n"
                + "10.[help] - lists out all options available\n"
                + "   Format: help\n"
                + "_______________________________________________\n");

    }

    public void separationLine() {
        System.out.print(SEPARATOR + "\n");
    }

    public void explainStepsForNewUser() {

        System.out.print("Please enter your year and semester\n"
                + "For instance, if you are a year 2 semester 1 student, "
                + "type: Y2S1\n");
    }

    public void printExitMessage() {
        System.out.print("Exiting CAP Calculator\n\n");
        separationLine();
    }

    public void printModuleDataHeading() {
        System.out.print("[MODULES] [GRADEs] [MCs]\n");
    }

    public void warnUserOfEmptySemester() {
        System.out.print("There are no modules added in this semester yet\n");
    }

    public void printModuleData(String moduleCode, String grade, int mcs) {
        System.out.printf("[%-7s]   [%-2s]    [%1d]%n", moduleCode, grade, mcs);
    }

    public void printCurrentSemCap(double currCap) {
        if (currCap == currCap) {
            System.out.printf("CAP for this semester is %.2f\n", currCap);
        } else {
            System.out.print("Please enter more graded modules to calculate semester CAP\n");
        }
    }

    public void printOverallCap(double overallCap) {
        if (overallCap == overallCap) {
            System.out.printf("Overall CAP is: %.2f\n", overallCap);
        } else {
            System.out.print("Please enter more graded modules to calculate overall CAP\n");
        }

    }

    public void confirmModuleUpdate(String moduleCode) {
        System.out.print("Added " + moduleCode + "\n");
    }

    public void printStudentProfile(String semInfo) {
        System.out.print("Your profile: " + semInfo + " student\n");
    }

    public void promptForCommand() {
        System.out.print("Please enter command: ");
    }

    public void currentSemView(String sem) {
        System.out.print("You are viewing: " + sem + "\n");
    }

    public void requestUsertoUpdatePriorSem() {
        System.out.print("Overall CAP: This component cannot be viewed yet as you have not filled in your module data\n"
                + "from sem 1 to your current semester. Use the \"view\" command to update in those semesters\n");

    }

    public void requestForGrade() {
        System.out.print("Enter your desired grade:\n");
    }

    public void showEditedData(ModuleData newModule) {
        System.out.print("Edited. New data:\n" + newModule);
    }

    public void printException(Exception e) {
        System.out.print(e.getMessage());
    }

    public void tryAgain() {
        System.out.print("That input was not right, please try again\n");
    }

    public void moduleAlreadyExists() {
        System.out.print("Sorry! This module already exists for this semester!\n");
    }

    public void deletedModule(String moduleToDelete) {
        System.out.print("Deleted " + moduleToDelete + "\n");
    }

    public void moduleDoesntExist() {
        System.out.print("Sorry! This module doesn't exist for this semester!\n");
    }

}
