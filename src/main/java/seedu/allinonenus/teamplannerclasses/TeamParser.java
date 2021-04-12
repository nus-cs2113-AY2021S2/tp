package seedu.allinonenus.teamplannerclasses;

import java.util.Scanner;

public class TeamParser {
    private static final TeamConstants constants = new TeamConstants();
    private static final TeamUi ui = new TeamUi();

    public static boolean mainParser(TeamManager team) {
        Scanner in = new Scanner(System.in);
        String command = in.nextLine();
        String[] commandArguments = command.split(" ");
        try {
            if (commandArguments[0].equals("add") && commandArguments[1].equals("member")) {
                ui.addMember(team, commandArguments);
            } else if (commandArguments[0].equals("delete") && commandArguments[1].equals("member")) {
                ui.deleteMember(team, commandArguments);
            } else if (commandArguments[0].equals("show") && commandArguments[1].equals("members")) {
                ui.showTeamMembers(team);
            } else if (commandArguments[0].equals("clear") && commandArguments[1].equals("members")) {
                ui.clearMembers(team);
            } else if (commandArguments[0].equals("help")) {
                ui.displayCommands();
            } else if (commandArguments[0].equals("add") && commandArguments[1].equals("task")) {
                ui.addTask(team);
            } else if (commandArguments[0].equals("delete") && commandArguments[1].equals("task")) {
                ui.deleteTask(team);
            } else if (commandArguments[0].equals("mark") && commandArguments[1].equals("done")) {
                ui.markTaskAsDone(team);
            } else if (commandArguments[0].equals("show") && commandArguments[1].equals("tasks")) {
                ui.showTask(team);
            } else if (commandArguments[0].equals("quit")) {
                return false;
            } else {
                throw new TeamPlannerException("invalid_input");
            }
        } catch (TeamPlannerException e) {
            System.out.println("Invalid input");
            System.out.println(constants.displayCommandsAvailable);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid input");
            System.out.println(constants.displayCommandsAvailable);
        }
        return true;
    }
}