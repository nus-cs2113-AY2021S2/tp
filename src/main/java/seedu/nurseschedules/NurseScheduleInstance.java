package seedu.nurseschedules;

import seedu.duke.storage.NurseScheduleStorage;
import seedu.nurseschedules.parser.Parser;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class NurseScheduleInstance {

    private Parser parser;
    private NurseScheduleActions actions;
    private NurseScheduleStorage storage;

    List<NurseSchedule> nurseSchedules = new ArrayList<NurseSchedule>();

    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main() {
        new NurseScheduleInstance().run();
    }

    public void run() {
        start();
        runCommandLoopUntilExit();
    }

    private void start() {
        this.parser = new Parser();
        this.actions = new NurseScheduleActions();
        this.storage = new NurseScheduleStorage();

        storage.load(nurseSchedules);
    }

    private void runCommandLoopUntilExit() {
        boolean isRun = true;
        while (isRun) {
            System.out.print("->NSchedule: ");
            String line = parser.getUserInput().trim();
            String command = parser.getFirstWord(line);
            String[] details = parser.getDetails(line);

            if (command.equals("add")) {
                try {
                    System.out.println("Trip to " + details[1] + " on " + parser.formatDate(line) + " added!");
                    nurseSchedules.add(new NurseSchedule(details[0], details[1], details[2]));
                } catch (ParseException e) {
                    System.out.println("Invalid date!");
                }
            } else if (command.equals("list")) {
                actions.listSchedules(nurseSchedules, parser.getDetails(line));
            } else if (command.equals("delete")) {
                actions.deleteSchedule(nurseSchedules, parser.getDetails(line));
            } else if (command.equals("return")) {
                storage.writeToFile(nurseSchedules);
                System.out.println("Back to main menu");
                isRun = false;
            }
        }
    }
}
