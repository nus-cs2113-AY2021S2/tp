package seedu.duke.ui;

public class NurseScheduleUI extends UI {

    public void nurseSchedulePrompt() {
        System.out.print("NSchedule --> ");
    }

    public void printNurseScheduleWelcomeMessage() {
        System.out.println("Welcome to Nurse Schedules!");
        System.out.println("Type \"help\" to for nurse schedules commands");
        showLine();
    }

    public void printNurseScheduleHelpList() {
        System.out.println("Here is a list of Nurse Schedules commands: ");
        System.out.println("\"help\" brings up this list of commands!");
        System.out.println("\"add [NurseID] [Patient ID] [Date (DDMMYYYY)]\" adds a schedule to the schedule list!");
        System.out.println("\"list [NurseID/all]\" brings up the list of either all or specified nurse schedules!");
        System.out.println("\"delete [NurseID] [Date (DDMMYYYY)]\" deletes the schedule with the specified nurse ID!");
        System.out.println("\"return\" returns you to the Start Menu!");
        showLine();
    }

    public void printDeletedSchedule(String id, String datetime) {
        System.out.println("Trip to " + id +
                " on " + datetime + " has been cancelled!");
        showLine();
    }

    public void printAddedSchedule(String id, String datetime) {
        System.out.println("Trip to " + id + " on " + datetime + " added!");
        showLine();
    }

    public void invalidCommandMessage() {
        System.out.println("OOPS! Please check to see if your command is properly formatted!");
        showLine();
    }

    public void invalidInputsMessage() {
        System.out.println("Invalid inputs!");
    }

    public void addHelpMessage() {
        System.out.println("Format: add [NurseID] [Patient ID] [Date (DDMMYYYY)]");
        showLine();
    }

    public void listHelpMessage() {
        System.out.println("Format: list [NurseID/all]");
        showLine();
    }

    public void deleteHelpMessage() {
        System.out.println("Format: delete [NurseID] [Date (DDMMYYYY)]");
        showLine();
    }
}
