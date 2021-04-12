package seedu.allinonenus.teamplannerclasses;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class TeamUi {
    private static final TeamConstants constants = new TeamConstants();

    /*
     * The startUp method checks if a text file titled "team.txt" exists.
     * If such a text file does not exist, the user will be prompted to input the details of the team.
     * @params team to load the contents of the text file, or to enter the details of the team.
     * */
    public static void startUp(TeamManager team) {
        System.out.println(constants.welcomeMessage);
        boolean fileNotFoundFlag = loadFile(team);
        if (!fileNotFoundFlag) {
            initializeTeam(team);
        }
    }

    /*
     * The initializeTeam method prompts the user to key in all the team details.
     * The team details are: team leader name, password, size of team(excluding team leader) and team member name
     * @params team to store the information requested.
     * */
    public static void initializeTeam(TeamManager team) {
        boolean passwordEntered = false;
        String password = "";
        enterTeamDetails(team);
        while (!passwordEntered) {
            System.out.println(constants.requestTeamLeaderPassword);
            Scanner in = new Scanner(System.in);
            password = in.nextLine();
            while (password.length() == 0) {
                System.out.println(constants.emptyPasswordField);
                password = in.nextLine();
            }
            System.out.println(constants.requestTeamLeaderPasswordConfirmation);
            if (password.equals(in.nextLine())) {
                passwordEntered = true;
                System.out.println(constants.passwordConfirmation);
            } else {
                System.out.println(constants.passwordDoNotMatch);
            }
        }
        team.setPassword(password);
        saveFile(team);
    }

    /*
     * The enterTeamDetails method prompts the user to key in the team details.
     * The team details are: team leader name, size of team(excluding team leader) and team member name
     * @params team to store the information requested.
     * */
    public static void enterTeamDetails(TeamManager team) {
        //Initialize the teamManager class
        System.out.println(constants.requestTeamLeaderName);
        Scanner in = new Scanner(System.in);
        String teamLeaderName = in.nextLine();
        while (teamLeaderName.length() == 0) {
            System.out.println(constants.emptyLeaderField);
            teamLeaderName = in.nextLine();
        }
        //Add leader to the teamManager class.
        TeamMember teamLeader = new TeamMember(teamLeaderName, true);
        team.addMember(teamLeader);
        System.out.println(constants.requestTeamSize);
        int size = 0;
        boolean validTeamSize = false;
        while (!validTeamSize) {
            try {
                size = Integer.parseInt(in.nextLine());
                validTeamSize = true;
            } catch (NumberFormatException e) {
                System.out.println(constants.numberException);
            }
        }
        System.out.println(constants.requestTeamMembersName);
        for (int i = 0; i < size; i++) {
            String teamMemberName = in.nextLine();
            while (teamMemberName.length() == 0) {
                System.out.println(constants.emptyMemberField);
                teamMemberName = in.nextLine();
            }
            //Add each member to the teamManager class.
            TeamMember teamMember = new TeamMember(teamMemberName, false);
            team.addMember(teamMember);
        }
        showTeamMembers(team);
    }

    /*
     * The saveFile method saves the current details of the team.
     * @params team is where is the details to be saved are retrieved from.
     * */
    public static void saveFile(TeamManager team) {
        try {
            TeamPlannerStorage.saveFile(team);
        } catch (IOException e) {
            System.out.println(constants.errorSavingFile);
        }
    }

    /*
     * The loadFile method load saved details of the team.
     * @params team is where is the details to be loaded will be added to.
     * */
    public static boolean loadFile(TeamManager team) {
        try {
            TeamPlannerStorage.loadFile(team);
            return true;
        } catch (FileNotFoundException e) {
            System.out.println(constants.errorFileNotFound);
            return false;
        }
    }

    /*
     * The displayCommands method shows the list of available commands.
     * */
    public static void displayCommands() {
        System.out.println(constants.displayCommandsAvailable);
    }

    /*
     * The addMember method adds a member to the team.
     * This feature requires password authentication
     * @params team is where the member is to be added to.
     * @params commandArguments specifies the name of the team member to be added.
     * */
    public static void addMember(TeamManager team, String[] commandArguments) {
        if (commandArguments.length == 2) {
            System.out.println(constants.missingInputParameter);
            return;
        }
        passwordValidation(team);
        String teamMemberName = commandArguments[2].trim();
        TeamMember teamMember = new TeamMember(teamMemberName, false);
        team.addMember(teamMember);
        System.out.println(team.getTeamMember(team.getMemberCount() - 1)
                + " has been added to the team");
        saveFile(team);
    }

    /*
     * The deleteMember method deletes a member from the team.
     * This feature requires password authentication.
     * @params team is where the the member is deleted from.
     * @params commandArguments specifies the name of the team member to be added.
     * */
    public static void deleteMember(TeamManager team, String[] commandArguments) {
        if (commandArguments.length == 2) {
            System.out.println(constants.missingInputParameter);
            return;
        }
        passwordValidation(team);
        String teamMemberName = commandArguments[2].trim();
        int memberIndex = team.getIndexOfTeamMember(teamMemberName);
        if (memberIndex == -1) {
            System.out.println(constants.errorInvalidMemberDeleted);
            return;
        } else {
            team.removeMember(memberIndex);
        }
        saveFile(team);
    }

    /*
     * The clearMembers method clears the current team.
     * @params team clears the team and loads the team with new details as per the user input.
     * */
    public static void clearMembers(TeamManager team) {
        passwordValidation(team);
        team.clearTeam();
        saveFile(team);
        initializeTeam(team);
        saveFile(team);
    }

    /*
     * The showTeamMembers method displays the current members on the team without the corresponding tasks.
     * @params team contains the details of the team to be retrieved.
     * */
    public static void showTeamMembers(TeamManager team) {
        System.out.println(constants.displayTeamDetails);
        for (int i = 0; i < team.getMemberCount(); i++) {
            if ((team.getTeamMember(i)).isTeamLeader()) {
                System.out.println((i + 1) + ". [L] " + (team.getTeamMember(i)).getName());
            } else {
                System.out.println((i + 1) + ". [M] " + (team.getTeamMember(i)).getName());
            }
        }
    }

    /*
     * The passwordValidation method checks if the password inputted is the correct password.
     * @params team contains the password that was set.
     * */
    public static void passwordValidation(TeamManager team) {
        boolean passwordCorrect = false;
        while (!passwordCorrect) {
            System.out.println(constants.requestPassword);
            Scanner input = new Scanner(System.in);
            String passwordInputed = input.nextLine();
            if (passwordInputed.equals(team.getPassword())) {
                passwordCorrect = true;
            }
        }
    }

    /*
     * addTask method adds a task to a member.
     * The user is first prompted to enter the member to add the task to.
     * Following which, the user is prompted to enter the details of the task.
     * Lastly, the user is prompted to state the priority level of the task(HIGH/MED/LOW).
     * @params team contains the team member to add the task to.
     * */
    public static void addTask(TeamManager team) {
        Scanner in = new Scanner(System.in);
        System.out.println(constants.requestMemberNameToAddTask);
        String teamMemberName = in.nextLine();
        teamMemberName = teamMemberName.trim();
        int memberIndex = team.getIndexOfTeamMember(teamMemberName);
        while (memberIndex == -1) {
            System.out.println(constants.errorInvalidMemberAdded);
            teamMemberName = in.nextLine();
            teamMemberName = teamMemberName.trim();
            memberIndex = team.getIndexOfTeamMember(teamMemberName);
        }
        System.out.println(constants.requestTask);
        String taskDescription = in.nextLine();
        taskDescription = taskDescription.trim();
        System.out.println(constants.requestPriorityLevel);
        String priorityLevelInput = in.nextLine();
        int priorityLevel = 0;
        while (priorityLevel == 0) {
            if (priorityLevelInput.equals("HIGH")) {
                priorityLevel = 1;
                break;
            } else if (priorityLevelInput.equals("MED")) {
                priorityLevel = 2;
                break;
            } else if (priorityLevelInput.equals("LOW")) {
                priorityLevel = 3;
                break;
            }
            System.out.println(constants.errorPriorityLevel);
            priorityLevelInput = in.nextLine();
        }
        Task task = new Task(taskDescription, priorityLevel, false);
        (team.getTeamMember(memberIndex)).addTask(task);
        System.out.println(taskDescription + " has been assigned to " + (team.getTeamMember(memberIndex))
                + " with a priority level of " + priorityLevel);
        saveFile(team);
    }

    /*
     * deleteTask method deletes a task from a member.
     * The user is first prompted to enter the member to delete the task from.
     * Following which, the user is prompted to key in the index of the task to be deleted.
     * @params team contains the team member to delete the task from.
     * */
    public static void deleteTask(TeamManager team) {
        Scanner in = new Scanner(System.in);
        System.out.println(constants.requestMemberNameToDeleteTask);
        String teamMemberName = in.nextLine();
        teamMemberName = teamMemberName.trim();
        int memberIndex = team.getIndexOfTeamMember(teamMemberName);
        while (memberIndex == -1) {
            System.out.println(constants.errorInvalidTeamMember);
            teamMemberName = in.nextLine();
            teamMemberName = teamMemberName.trim();
            memberIndex = team.getIndexOfTeamMember(teamMemberName);
        }
        TeamMember teamMember = team.getTeamMember(memberIndex);
        if(teamMember.getTaskCount()==0){
            System.out.println(constants.emptyTaskList);
            return;
        }
        System.out.println(constants.requestTaskIndexToDeleteTask);
        int taskIndex = -1;
        while (taskIndex == -1) {
            try {
                taskIndex = Integer.parseInt(in.nextLine()) - 1;
                if (taskIndex < 0 || taskIndex + 1 > teamMember.getTaskCount()) {
                    System.out.println(constants.errorTaskIndex);
                    taskIndex = -1;
                }
            } catch (NumberFormatException e) {
                System.out.println(constants.errorTaskIndexNumber);
            }
        }
        try {
            teamMember.deleteTask(taskIndex);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(constants.errorTaskIndex);
        } catch (NumberFormatException e) {
            System.out.println(constants.errorTaskIndexNumber);
        }
        saveFile(team);
    }

    /*
     * markTaskAsDone method marks a task as done for a member.
     * The user is first prompted to enter the member the task corresponds to.
     * Following which, the user is prompted to key in the index of the task to be marked as done.
     * @params team contains the team member to mark the task as done from.
     * */
    public static void markTaskAsDone(TeamManager team) {
        Scanner in = new Scanner(System.in);
        System.out.println(constants.requestMemberNameToMarkDone);
        String teamMemberName = in.nextLine();
        teamMemberName = teamMemberName.trim();
        int memberIndex = team.getIndexOfTeamMember(teamMemberName);
        while (memberIndex == -1) {
            System.out.println(constants.errorInvalidTeamMember);
            teamMemberName = in.nextLine();
            teamMemberName = teamMemberName.trim();
            memberIndex = team.getIndexOfTeamMember(teamMemberName);
        }
        TeamMember teamMember = (team.getTeamMember(memberIndex));
        System.out.println(constants.requestTaskIndexToMarkDone);
        int taskIndex = -1;
        while (taskIndex == -1) {
            try {
                taskIndex = Integer.parseInt(in.nextLine()) - 1;
            } catch (NumberFormatException e) {
                System.out.println(constants.errorTaskIndexNumber);
            }
        }
        try {
            teamMember.markTaskAsDone(taskIndex);
            System.out.println(teamMember.getTask(taskIndex) + " has been marked as done for " + teamMember);
        } catch (NumberFormatException e) {
            System.out.println(constants.errorTaskIndexNumber);
        }
        saveFile(team);
    }

    /*
     * The showTask method shows the current members on the team as well as the task assigned to each member
     * @team contains the details to be retrieved to show the team and task details.
     * */
    public static void showTask(TeamManager team) {
        for (int i = 0; i < team.getMemberCount(); i++) {
            System.out.println((i + 1) + ". " + team.getTeamMember(i));
            for (int j = 0; j < (team.getTeamMember(i)).getTaskCount(); j++) {
                System.out.print("  " + (j + 1) + ".");
                switch (team.getTeamMember(i).getTask(j).getPriority()) {
                case 1:
                    System.out.print(" [HIGH]");
                    break;
                case 2:
                    System.out.print(" [MED] ");
                    break;
                case 3:
                    System.out.print(" [LOW] ");
                    break;
                }
                System.out.print((team.getTeamMember(i)).getTask(j) + "\n");
            }
        }
    }
}
