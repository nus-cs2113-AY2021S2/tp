package seedu.allinonenus.teamplannerclasses;

import seedu.allinonenus.teamplannerclasses.TeamManager;
import seedu.allinonenus.teamplannerclasses.TeamMember;
import seedu.allinonenus.teamplannerclasses.TeamPlannerException;
import seedu.allinonenus.teamplannerclasses.TeamPlannerStorage;
import seedu.allinonenus.teamplannerclasses.TeamConstants;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class TeamPlanner {

    private static final TeamManager team = new TeamManager();
    private static final TeamConstants constants = new TeamConstants();
    private static final TeamUi ui = new TeamUi();
    private static final TeamParser parser = new TeamParser();

    public static void teamPlanner() {
        ui.startUp(team);
        boolean programOn = true;
        System.out.println(constants.displayCommandsAvailable);
        while (programOn) {
            programOn = parser.mainParser(team);
        }
    }

    public void run() {
        teamPlanner();
    }


}
