package seedu.allinonenus.teamplannerclasses;

public class TeamConstants {
    public static final String welcomeMessage = "Welcome to All-In-One-NUS team manager";
    public static final String requestTeamLeaderName = "Please enter the name of the team lead (No spaces)";
    public static final String requestTeamSize = "Please enter the size of your team (excluding the team lead)";
    public static final String requestTeamMembersName = "Please enter the names of your team members,"
            + "one per line (No spaces)";
    public static final String requestTeamLeaderPassword = "[Team Lead] Please enter a password (No spaces)";
    public static final String requestTeamLeaderPasswordConfirmation = "[Team Lead] Please re-enter the password";
    public static final String passwordConfirmation = "The password has been set";
    public static final String passwordDoNotMatch = "The passwords do not match";
    public static final String displayCommandsAvailable = "Here are the list of commands available : \n"
            + "1. add member [member] - adds a member (requires password)\n"
            + "2. delete member [member] - deletes a member (requires password)\n"
            + "3. show members - shows current members\n"
            + "4. clear members - clears the current team and resets the password (requires password)\n"
            + "5. help - lists the commands available\n"
            + "6. add task\n"
            + "7. delete task\n"
            + "8. mark done\n"
            + "9. show tasks\n"
            + "10. quit - quits the program";
    public static final String requestPassword = "Please enter the password";
    public static final String emptyPasswordField = "The password field cannot be empty";
    public static final String emptyLeaderField = "The team leader field cannot be empty";
    public static final String numberException = "Please enter a number";
    public static final String emptyMemberField = "The team member field cannot be empty";
    public static final String errorSavingFile = "Unable to save current content as a text file";
    public static final String errorFileNotFound = "No saved file found";
    public static final String missingInputParameter = "Missing parameter in the input."+
            " Please specify a member on the team";
    public static final String errorInvalidMemberDeleted = "Please specify a valid team member to be deleted";
    public static final String requestMemberNameToAddTask = "Member to add task to:";
    public static final String errorInvalidMemberAdded = "Please specify a valid team member to add a task to";
    public static final String requestTask = "Task to be added:";
    public static final String requestPriorityLevel = "Priority level of the task(HIGH/MED/LOW):";
    public static final String errorPriorityLevel = "Unrecognized priority level input. Please specify HIGH/MED/LOW.";
    public static final String requestMemberNameToDeleteTask = "Member to delete task from:";
    public static final String requestTaskIndexToDeleteTask = "Index of task to be deleted:";
    public static final String errorTaskIndexNumber = "Please enter a number as the index of task";
    public static final String errorTaskIndex = "Please enter a valid task index";
    public static final String requestMemberNameToMarkDone = "Member the task is assigned to:";
    public static final String requestTaskIndexToMarkDone = "Index of task to be marked as done:";
    public static final String displayTeamDetails = "The team details are as follows:";
    public static final String errorInvalidTeamMember = "Please specify a valid team member";
    public static final String emptyTaskList = "There are no tasks assigned to this member";
}
