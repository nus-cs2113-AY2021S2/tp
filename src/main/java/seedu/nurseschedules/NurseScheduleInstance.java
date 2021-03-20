package seedu.nurseschedules;

import seedu.duke.storage.NurseScheduleStorage;
import seedu.nurseschedules.parser.Parser;
import seedu.duke.ui.NurseScheduleUI;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class NurseScheduleInstance {

    private Parser parser;
    private NurseScheduleActions actions;
    private NurseScheduleStorage storage;
    private NurseScheduleUI ui;

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
        this.ui = new NurseScheduleUI();

        storage.load(nurseSchedules);

        ui.printNurseScheduleWelcomeMessage();
    }

    private void runCommandLoopUntilExit() {
        boolean isRun = true;
        while (isRun) {
            ui.nurseSchedulePrompt();
            String line = parser.getUserInput().trim();
            String command = parser.getFirstWord(line);
            String[] details = parser.getDetails(line);

            if (command.equals("add")) {
                try {
                    ui.printAddedSchedule(details[1], parser.formatDate(line));
                    nurseSchedules.add(new NurseSchedule(details[0], details[1], details[2]));
                    storage.writeToFile(nurseSchedules);
                } catch (ParseException e) {
                    System.out.println("Invalid date!");
                }
            } else if (command.equals("list")) {
                actions.listSchedules(nurseSchedules, parser.getDetails(line));
            } else if (command.equals("delete")) {
                actions.deleteSchedule(nurseSchedules, parser.getDetails(line));
                storage.writeToFile(nurseSchedules);
            } else if (command.equals("help")) {
                ui.printNurseScheduleHelpList();
            } else if (command.equals("return")) {
                storage.writeToFile(nurseSchedules);
                ui.returnToStart();
                isRun = false;
            }
        }
    }
}
