package seedu.duke;

import seedu.duke.link.LinkInfo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.Set;

import seedu.duke.link.ZoomLinkInfo;
import seedu.duke.task.Assignment;
import seedu.duke.task.FinalExam;
import seedu.duke.task.Midterm;
import seedu.duke.task.Task;
import seedu.duke.task.TaskList;

//@@author nivikcivik-reused
//Reused from https://github.com/nivikcivik/ip/blob/master/src/main/java/dukehandler/FileManager.java with minor modifications
public class StorageModuleInfo {

    public static String filePath = new File("").getAbsolutePath();
    public static String filePathForTasks = new File("").getAbsolutePath();
    public static String filePathForAssignments = new File("").getAbsolutePath();
    public static String filePathForMidterms = new File("").getAbsolutePath();
    public static String filePathForFinalExams = new File("").getAbsolutePath();
    public static String filePathForPinnedTasks = new File("").getAbsolutePath();
    public static String filePathForLinks = new File("").getAbsolutePath();
    public static String filePathForZoom = new File("").getAbsolutePath();

    /**
     * Checks if file exists, or creates new file if it doesn't already exist. Edits filepath
     * variable within storage
     */
    public static void loadModuleInfoFile() {
        filePath += "/UniTracker Data";
        File data = new File(filePath);
        if (!data.exists()) {
            boolean isCreated = data.mkdir();
            if (!isCreated) {
                System.out.println("New directory could not be created:(");
            }
        }
        try {
            filePath += "/modules.txt";
            data = new File(filePath);
            if (data.createNewFile()) {
                // System.out.println("New file created at:\n" + data.getAbsolutePath());
                return;
            }
            downloadModules();
        } catch (IOException e) {
            System.out.println("There was an I/O error:(");
        }
    }


    /**
     * Downloads the contents from file (modules.txt) into modules ArrayList
     *
     * @throws FileNotFoundException if modules.txt file cannot be accessed.
     */
    public static void downloadModules() throws FileNotFoundException {
        File f = new File(filePath); // create a File for the given file path
        Scanner s = new Scanner(f); // create a Scanner using the File as the source
        while (s.hasNext()) {
            String[] part = s.nextLine().split(" ~~ ");
            Module module = new Module(part[0], part[1]);
            StringBuilder review = new StringBuilder();
            while (true) {
                String line = s.nextLine();
                if (line.contains(" -- end of module -- ")) {
                    review.append(line.split(" -- end of module -- ")[0]);
                    break;
                }
                review.append(line).append("\n");
            }
            module.setReview(review.toString());
            ModuleInfo.modules.add(module);
        }
    }

    /**
     * Writes tasks ArrayList data into modules.txt file on computer Delimiter is ' ~~ '
     *
     * @throws IOException if modules.txt file cannot be accessed.
     */
    public static void modulesFileSaver() throws IOException {
        FileWriter fw = new FileWriter(filePath);
        for (Module module : ModuleInfo.modules) {
            fw.write(module.getName() + " ~~ "
                    + module.getDescription() + "\n"
                    + module.getReview());
            fw.write(" -- end of module -- ");
            fw.write(System.lineSeparator());
        }
        fw.close();
    }

    public static void loadTasksFile() {
        filePathForTasks += "/UniTracker Data";
        File data = new File(filePathForTasks);
        if (!data.exists()) {
            boolean isCreated = data.mkdir();
            if (!isCreated) {
                System.out.println("New directory could not be created:(");
            }
        }
        try {
            filePathForTasks += "/tasks.txt";
            data = new File(filePathForTasks);
            if (data.createNewFile()) {
                // System.out.println("New file created at:\n" + data.getAbsolutePath());
                return;
            }
            downloadTasks();
        } catch (IOException e) {
            System.out.println("There was an I/O error:(");
        }
    }

    public static void downloadTasks() throws FileNotFoundException {
        File f = new File(filePathForTasks); // create a File for the given file path
        Scanner s = new Scanner(f); // create a Scanner using the File as the source
        while (s.hasNext()) {
            String[] part = s.nextLine().split(" ~~ ");
            Task task = new Task(part[0], part[2], part[3]);
            if (part[1].equals("[DONE] ")) {
                task.markAsDone();
            }
            TaskList.tasks.add(task);
        }
    }

    public static void tasksFileSaver() throws IOException {
        FileWriter fw = new FileWriter(filePathForTasks);
        for (Task task : TaskList.tasks) {
            fw.write(task.getModule() + " ~~ "
                    + task.getStatus() + " ~~ "
                    + task.getDescription() + " ~~ "
                    + task.getMessage());
            fw.write(System.lineSeparator());
        }
        fw.close();
    }

    public static void loadAssignmentsFile() {
        filePathForAssignments += "/UniTracker Data";
        File data = new File(filePathForAssignments);
        if (!data.exists()) {
            boolean isCreated = data.mkdir();
            if (!isCreated) {
                System.out.println("New directory could not be created:(");
            }
        }
        try {
            filePathForAssignments += "/assignments.txt";
            data = new File(filePathForAssignments);
            if (data.createNewFile()) {
                // System.out.println("New file created at:\n" + data.getAbsolutePath());
                return;
            }
            downloadAssignments();
        } catch (IOException e) {
            System.out.println("There was an I/O error:(");
        }
    }

    public static void downloadAssignments() throws FileNotFoundException {
        File f = new File(filePathForAssignments); // create a File for the given file path
        Scanner s = new Scanner(f); // create a Scanner using the File as the source
        while (s.hasNext()) {
            String[] part = s.nextLine().split(" ~~ ");
            Assignment assignment = new Assignment(part[0], part[2], part[3], part[4]);
            if (part[1].equals("[DONE] ")) {
                assignment.markAsDone();
            }
            TaskList.assignments.add(assignment);
        }
    }

    public static void assignmentsFileSaver() throws IOException {
        FileWriter fw = new FileWriter(filePathForAssignments);
        for (Assignment assignment : TaskList.assignments) {
            fw.write(assignment.getModule() + " ~~ "
                    + assignment.getStatus() + " ~~ "
                    + assignment.getDescription() + " ~~ "
                    + assignment.getMessage() + " ~~ "
                    + assignment.getBy());
            fw.write(System.lineSeparator());
        }
        fw.close();
    }

    public static void loadMidtermsFile() {
        filePathForMidterms += "/UniTracker Data";
        File data = new File(filePathForMidterms);
        if (!data.exists()) {
            boolean isCreated = data.mkdir();
            if (!isCreated) {
                System.out.println("New directory could not be created:(");
            }
        }
        try {
            filePathForMidterms += "/midterms.txt";
            data = new File(filePathForMidterms);
            if (data.createNewFile()) {
                // System.out.println("New file created at:\n" + data.getAbsolutePath());
                return;
            }
            downloadMidterms();
        } catch (IOException e) {
            System.out.println("There was an I/O error:(");
        }
    }

    public static void downloadMidterms() throws FileNotFoundException {
        File f = new File(filePathForMidterms); // create a File for the given file path
        Scanner s = new Scanner(f); // create a Scanner using the File as the source
        while (s.hasNext()) {
            String[] part = s.nextLine().split(" ~~ ");
            Midterm midterm = new Midterm(part[0], part[2], part[3], part[4]);
            if (part[1].equals("[DONE] ")) {
                midterm.markAsDone();
            }
            TaskList.midterms.add(midterm);
        }
    }

    public static void midtermsFileSaver() throws IOException {
        FileWriter fw = new FileWriter(filePathForMidterms);
        for (Midterm midterm : TaskList.midterms) {
            fw.write(midterm.getModule() + " ~~ "
                    + midterm.getStatus() + " ~~ "
                    + midterm.getDescription() + " ~~ "
                    + midterm.getMessage() + " ~~ "
                    + midterm.getOn());
            fw.write(System.lineSeparator());
        }
        fw.close();
    }

    public static void loadFinalExamsFile() {
        filePathForFinalExams += "/UniTracker Data";
        File data = new File(filePathForFinalExams);
        if (!data.exists()) {
            boolean isCreated = data.mkdir();
            if (!isCreated) {
                System.out.println("New directory could not be created:(");
            }
        }
        try {
            filePathForFinalExams += "/finalExams.txt";
            data = new File(filePathForFinalExams);
            if (data.createNewFile()) {
                // System.out.println("New file created at:\n" + data.getAbsolutePath());
                return;
            }
            downloadFinalExams();
        } catch (IOException e) {
            System.out.println("There was an I/O error:(");
        }
    }

    public static void downloadFinalExams() throws FileNotFoundException {
        File f = new File(filePathForFinalExams); // create a File for the given file path
        Scanner s = new Scanner(f); // create a Scanner using the File as the source
        while (s.hasNext()) {
            String[] part = s.nextLine().split(" ~~ ");
            FinalExam finalExam = new FinalExam(part[0], part[2], part[3], part[4]);
            if (part[1].equals("[DONE] ")) {
                finalExam.markAsDone();
            }
            TaskList.finalExams.add(finalExam);
        }
    }

    public static void finalExamsFileSaver() throws IOException {
        FileWriter fw = new FileWriter(filePathForFinalExams);
        for (FinalExam finalExam : TaskList.finalExams) {
            fw.write(finalExam.getModule() + " ~~ "
                    + finalExam.getStatus() + " ~~ "
                    + finalExam.getDescription() + " ~~ "
                    + finalExam.getMessage() + " ~~ "
                    + finalExam.getOn());
            fw.write(System.lineSeparator());
        }
        fw.close();
    }

    public static void loadPinnedTasksFile() {
        filePathForPinnedTasks += "/UniTracker Data";
        File data = new File(filePathForPinnedTasks);
        if (!data.exists()) {
            boolean isCreated = data.mkdir();
            if (!isCreated) {
                System.out.println("New directory could not be created:(");
            }
        }
        try {
            filePathForPinnedTasks += "/pinnedTasks.txt";
            data = new File(filePathForPinnedTasks);
            if (data.createNewFile()) {
                // System.out.println("New file created at:\n" + data.getAbsolutePath());
                return;
            }
            downloadPinnedTasks();
        } catch (IOException e) {
            System.out.println("There was an I/O error:(");
        }
    }

    public static void downloadPinnedTasks() throws FileNotFoundException {
        File f = new File(filePathForPinnedTasks); // create a File for the given file path
        Scanner s = new Scanner(f); // create a Scanner using the File as the source
        while (s.hasNext()) {
            String[] part = s.nextLine().split(" ~~ ");
            TaskList.pinnedTasks.computeIfAbsent(part[0], k -> new ArrayList<>());
            switch (part[0]) {
            case "[Assignment]":
                Assignment assignment = new Assignment(part[1], part[3], part[4], part[5]);
                TaskList.pinnedTasks.get(part[0]).add(assignment);
                if (part[2].equals("[DONE] ")) {
                    assignment.markAsDone();
                }
                break;
            case "[Midterm]":
                Midterm midterm = new Midterm(part[1], part[3], part[4], part[5]);
                TaskList.pinnedTasks.get(part[0]).add(midterm);
                if (part[2].equals("[DONE] ")) {
                    midterm.markAsDone();
                }
                break;
            case "[Final Exam]":
                FinalExam finalExam = new FinalExam(part[1], part[3], part[4], part[5]);
                TaskList.pinnedTasks.get(part[0]).add(finalExam);
                if (part[2].equals("[DONE] ")) {
                    finalExam.markAsDone();
                }
                break;
            default:
                Task task = new Task(part[1], part[3], part[4]);
                TaskList.pinnedTasks.get(part[0]).add(task);
                if (part[2].equals("[DONE] ")) {
                    task.markAsDone();
                }
                break;
            }
        }
    }

    public static void pinnedTasksFileSaver() throws IOException {
        FileWriter fw = new FileWriter(filePathForPinnedTasks);
        Set<String> taskTypes = TaskList.pinnedTasks.keySet();
        for (String taskType : taskTypes) {
            switch (taskType) {
            case "[Assignment]":
                ArrayList<Task> assignments = TaskList.pinnedTasks.get(taskType);
                for (Task task : assignments) {
                    Assignment assignment = (Assignment) task;
                    fw.write("[Assignment] ~~ "
                            + assignment.getModule() + " ~~ "
                            + assignment.getStatus() + " ~~ "
                            + assignment.getDescription() + " ~~ "
                            + assignment.getMessage() + " ~~ "
                            + assignment.getBy());
                    fw.write(System.lineSeparator());
                }
                break;
            case "[Midterm]":
                ArrayList<Task> midterms = TaskList.pinnedTasks.get(taskType);
                for (Task task : midterms) {
                    Midterm midterm = (Midterm) task;
                    fw.write("[Midterm] ~~ "
                            + midterm.getModule() + " ~~ "
                            + midterm.getStatus() + " ~~ "
                            + midterm.getDescription() + " ~~ "
                            + midterm.getMessage() + " ~~ "
                            + midterm.getOn());
                    fw.write(System.lineSeparator());
                }
                break;
            case "[Final Exam]":
                ArrayList<Task> finalExams = TaskList.pinnedTasks.get(taskType);
                for (Task task : finalExams) {
                    FinalExam finalExam = (FinalExam) task;
                    fw.write("[Final Exam] ~~ "
                            + finalExam.getModule() + " ~~ "
                            + finalExam.getStatus() + " ~~ "
                            + finalExam.getDescription() + " ~~ "
                            + finalExam.getMessage() + " ~~ "
                            + finalExam.getOn());
                    fw.write(System.lineSeparator());
                }
                break;
            default:
                ArrayList<Task> tasks = TaskList.pinnedTasks.get(taskType);
                for (Task task : tasks) {
                    fw.write("[Task] ~~ "
                            + task.getModule() + " ~~ "
                            + task.getStatus() + " ~~ "
                            + task.getDescription() + " ~~ "
                            + task.getMessage());
                    fw.write(System.lineSeparator());
                }
                break;
            }
        }
        fw.close();
    }

    public static void loadLinkInfoFile() {
        filePathForLinks += "/UniTracker Data";
        File data = new File(filePathForLinks);
        if (!data.exists()) {
            boolean isCreated = data.mkdir();
            if (!isCreated) {
                System.out.println("New directory could not be created:(");
            }
        }
        try {
            filePathForLinks += "/link.txt";
            data = new File(filePathForLinks);
            if (data.createNewFile()) {
                // System.out.println("New file created at:\n" + data.getAbsolutePath());
                return;
            }
            downloadLinks();
        } catch (IOException e) {
            System.out.println("There was an I/O error:(");
        }
    }

    public static void downloadLinks() throws FileNotFoundException {
        File f = new File(filePathForLinks); // create a File for the given file path
        Scanner s = new Scanner(f); // create a Scanner using the File as the source
        while (s.hasNext()) {
            LinkInfo link = new LinkInfo(s.nextLine());
            LinkInfo.addLink(link);
        }
    }

    public static void linksFileSaver() throws IOException {
        FileWriter fw = new FileWriter(filePathForLinks);
        for (LinkInfo link : LinkInfo.linksList) {
            fw.write(link.getLink());
            fw.write(System.lineSeparator());
        }
        fw.close();
    }

    public static void loadZoomLinkInfoFile() {
        filePathForZoom += "/UniTracker Data";
        File data = new File(filePathForZoom);
        if (!data.exists()) {
            boolean isCreated = data.mkdir();
            if (!isCreated) {
                System.out.println("New directory could not be created:(");
            }
        }
        try {
            filePathForZoom += "/zoom.txt";
            data = new File(filePathForZoom);
            if (data.createNewFile()) {
                // System.out.println("New file created at:\n" + data.getAbsolutePath());
                return;
            }
            downloadZoomLinks();
        } catch (IOException e) {
            System.out.println("There was an I/O error:(");
        }
    }

    public static void downloadZoomLinks() throws FileNotFoundException {
        File f = new File(filePathForZoom); // create a File for the given file path
        Scanner s = new Scanner(f); // create a Scanner using the File as the source
        while (s.hasNext()) {
            String[] part = s.nextLine().split("~~");
            ZoomLinkInfo link = new ZoomLinkInfo(part[0], part[1], part[2]);
            ZoomLinkInfo.zoomLinksList.add(link);
        }
    }

    public static void zoomLinksFileSaver() throws IOException {
        FileWriter fw = new FileWriter(filePathForZoom);
        for (ZoomLinkInfo link : ZoomLinkInfo.zoomLinksList) {
            fw.write(link.getDescription() + "~~"
                    + link.getModuleCode() + "~~"
                    + link.getPassword());
            fw.write(System.lineSeparator());
        }
        fw.close();
    }
}
