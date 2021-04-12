package seedu.allinonenus.teamplannerclasses;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class TeamPlannerStorage {
    public static void loadFile(TeamManager team) throws FileNotFoundException {
        File filePath = new File("team.txt");
        if (!filePath.exists()) {
            throw new FileNotFoundException();
        }
        Scanner s = new Scanner(filePath);
        if (filePath.length() != 0) {
            while (s.hasNext()) {
                String currentLine = s.nextLine();
                currentLine = currentLine.trim();
                String[] words = currentLine.split(" ");
                if (words[1].equals("[M]")) {
                    String teamMemberName = "";
                    for (int i = 2; i < words.length - 1; i++) {
                        teamMemberName += words[i] + " ";
                    }
                    teamMemberName = teamMemberName.trim();
                    TeamMember teamMember = new TeamMember(teamMemberName, false);
                    team.addMember(teamMember);
                    int numTasks = Integer.parseInt(words[words.length - 1]);
                    if (numTasks > 0) {
                        int memberIndex = team.getMemberCount() - 1;
                        for (int i = 0; i < numTasks; i++) {
                            String currentTask = s.nextLine();
                            currentTask = currentTask.trim();
                            String[] taskDetails = currentTask.split(" ");
                            int priorityLevel = -1;
                            if (taskDetails[1].equals("[HIGH]")) {
                                priorityLevel = 1;
                            } else if (taskDetails[1].equals("[MED]")) {
                                priorityLevel = 2;
                            } else if (taskDetails[1].equals("[LOW]")) {
                                priorityLevel = 3;
                            }
                            boolean isDone = false;
                            int startingIndex = 3;
                            if (taskDetails[2].equals("[X]")) {
                                isDone = true;
                            } else {
                                startingIndex = 4;
                            }
                            String taskDescription = " ";
                            for (int j = startingIndex; j < taskDetails.length; j++) {
                                taskDescription += taskDetails[j] + " ";
                            }
                            taskDescription = taskDescription.trim();
                            Task task = new Task(taskDescription, priorityLevel, isDone);
                            (team.getTeamMember(memberIndex)).addTask(task);
                        }
                    }
                } else if (words[1].equals("[L]")) {
                    String teamMemberName = "";
                    for (int i = 2; i < words.length - 1; i++) {
                        teamMemberName += words[i] + " ";
                    }
                    teamMemberName = teamMemberName.trim();
                    TeamMember teamMember = new TeamMember(teamMemberName, true);
                    team.addMember(teamMember);
                    int numTasks = Integer.parseInt(words[words.length - 1]);
                    if (numTasks > 0) {
                        int memberIndex = team.getMemberCount() - 1;
                        for (int i = 0; i < numTasks; i++) {
                            String currentTask = s.nextLine();
                            currentTask = currentTask.trim();
                            String[] taskDetails = currentTask.split(" ");
                            int priorityLevel = -1;
                            if (taskDetails[1].equals("[HIGH]")) {
                                priorityLevel = 1;
                            } else if (taskDetails[1].equals("[MED]")) {
                                priorityLevel = 2;
                            } else if (taskDetails[1].equals("[LOW]")) {
                                priorityLevel = 3;
                            }
                            boolean isDone = false;
                            int startingIndex = 3;
                            if (taskDetails[2].equals("[X]")) {
                                isDone = true;
                            } else {
                                startingIndex = 4;
                            }
                            String taskDescription = " ";
                            for (int j = startingIndex; j < taskDetails.length; j++) {
                                taskDescription += taskDetails[j] + " ";
                            }
                            taskDescription = taskDescription.trim();
                            Task task = new Task(taskDescription, priorityLevel, isDone);
                            (team.getTeamMember(memberIndex)).addTask(task);
                        }
                    }
                } else if (words[0].equals("[P]")) {
                    String password = "";
                    for (int i = 1; i < words.length; i++) {
                        password += words[i];
                    }
                    password = password.trim();
                    team.setPassword(password);
                }
            }
        }
    }

    public static void saveFile(TeamManager team) throws IOException {
        File filePath = new File("team.txt");
        if (!filePath.exists()) {
            if (filePath.exists()) {
                throw new IOException();
            }
        }
        FileWriter fileWriter = new FileWriter(filePath);
        for (int i = 0; i < team.getMemberCount(); i++) {
            String teamMember = (i + 1) + ". " + team.getTeamMember(i).toString() + " ";
            teamMember += (team.getTeamMember(i)).getTaskCount() + "\n";
            fileWriter.write(teamMember);
            for (int j = 0; j < (team.getTeamMember(i)).getTaskCount(); j++) {
                String task = "  " + (j + 1) + ".";
                switch (team.getTeamMember(i).getTask(j).getPriority()) {
                case 1:
                    task += " [HIGH]";
                    break;
                case 2:
                    task += " [MED]";
                    break;
                case 3:
                    task += " [LOW]";
                    break;
                }
                task += team.getTeamMember(i).getTask(j) + "\n";
                fileWriter.write(task);
            }
        }
        String password = "[P] " + team.getPassword();
        fileWriter.write(password);
        fileWriter.close();
    }
}
