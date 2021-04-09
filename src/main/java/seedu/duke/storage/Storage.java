package seedu.duke.storage;

import static seedu.duke.features.link.LinkInfo.isValidLink;

import seedu.duke.features.capsimulator.HelpGraduation;
import seedu.duke.features.link.LinkInfo;
import seedu.duke.features.link.LinkLoadException;
import seedu.duke.features.link.ZoomLinkInfo;
import seedu.duke.features.moduleinfo.Module;
import seedu.duke.features.moduleinfo.ModuleInfo;
import seedu.duke.features.task.tasktypes.Assignment;
import seedu.duke.features.task.tasktypes.FinalExam;
import seedu.duke.features.task.tasktypes.Task;
import seedu.duke.features.task.tasktypes.Midterm;
import seedu.duke.features.task.TaskManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;

//@@author nivikcivik-reused
//Reused from https://github.com/nivikcivik/ip/blob/master/src/main/java/dukehandler/FileManager.java with minor modifications
public class Storage {

    public static String filePathForModules = new File("").getAbsolutePath();
    public static String filePathForTasks = new File("").getAbsolutePath();
    public static String filePathForAssignments = new File("").getAbsolutePath();
    public static String filePathForMidterms = new File("").getAbsolutePath();
    public static String filePathForFinalExams = new File("").getAbsolutePath();
    public static String filePathForPinnedTasks = new File("").getAbsolutePath();
    public static String filePathForLinks = new File("").getAbsolutePath();
    public static String filePathForZoom = new File("").getAbsolutePath();
    public static String filePathForMcs = new File("").getAbsolutePath();

    public static void saveAllFiles() throws IOException {
        modulesFileSaver();
        tasksFileSaver();
        assignmentsFileSaver();
        midtermsFileSaver();
        finalExamsFileSaver();
        pinnedTasksFileSaver();
        linksFileSaver();
        zoomLinksFileSaver();
        modularCreditSaver();

    }

    public static void loadAllFiles() throws LinkLoadException {
        loadModuleInfoFile();
        loadTasksFile();
        loadAssignmentsFile();
        loadMidtermsFile();
        loadFinalExamsFile();
        loadPinnedTasksFile();
        loadLinkInfoFile();
        loadZoomLinkInfoFile();
        loadMcsInfoFile();
    }

    /**
     * Checks if file exists, or creates new file if it doesn't already exist. Edits filepath
     * variable within storage
     */
    public static void loadModuleInfoFile() {
        filePathForModules += "/UniTracker Data";
        File data = new File(filePathForModules);
        if (!data.exists()) {
            boolean isCreated = data.mkdir();
            if (!isCreated) {
                System.out.println("New directory could not be created:(");
            }
        }
        try {
            filePathForModules += "/modules.txt";
            data = new File(filePathForModules);
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
        File f = new File(filePathForModules); // create a File for the given file path
        Scanner s = new Scanner(f); // create a Scanner using the File as the source
        while (s.hasNext()) {
            String[] part = s.nextLine().split(" ~~ ");
            Module module = new Module(part[0], part[1]);
            String components = part[4];
            StringBuilder review = new StringBuilder();
            while (true) {
                String line = s.nextLine();
                if (line.contains(" -- end of module --")) {
                    review.append(line.split(" -- end of module --")[0]);
                    break;
                }
                review.append(line).append("\n");

            }
            //components = parseComponent(components);
            Hashtable<String, Integer> table = new Hashtable<>();
            if (!components.equals("{}")) {
                components = components.substring(1, components.length() - 1);
                String[] keyValuePairs = components.split(",");
                for (String pair : keyValuePairs) {
                    String[] entry = pair.split("=");
                    table.put(entry[0].trim(), Integer.parseInt(entry[1].trim()));
                }
            }

            int modularCredit = Integer.parseInt(part[2]);
            String grade = part[3];

            module.setComponents(table);
            module.setGrade(grade);
            module.setMc(modularCredit);
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
        FileWriter fw = new FileWriter(filePathForModules);
        for (Module module : ModuleInfo.modules) {
            fw.write(module.getName() + " ~~ "
                    + module.getDescription() + " ~~ "
                    + module.getMc() + " ~~ "
                    + module.getGrade() + " ~~ ");
            fw.write(module.getComponents().toString());
            fw.write("\n" + module.getReview());
            fw.write(" -- end of module --");
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
            TaskManager.tasks.add(task);
        }
    }

    public static void tasksFileSaver() throws IOException {
        FileWriter fw = new FileWriter(filePathForTasks);
        for (Task task : TaskManager.tasks) {
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
            TaskManager.assignments.add(assignment);
        }
    }

    public static void assignmentsFileSaver() throws IOException {
        FileWriter fw = new FileWriter(filePathForAssignments);
        for (Assignment assignment : TaskManager.assignments) {
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
            TaskManager.midterms.add(midterm);
        }
    }

    public static void midtermsFileSaver() throws IOException {
        FileWriter fw = new FileWriter(filePathForMidterms);
        for (Midterm midterm : TaskManager.midterms) {
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
            TaskManager.finalExams.add(finalExam);
        }
    }

    public static void finalExamsFileSaver() throws IOException {
        FileWriter fw = new FileWriter(filePathForFinalExams);
        for (FinalExam finalExam : TaskManager.finalExams) {
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
            TaskManager.pinnedTasks.computeIfAbsent(part[0], k -> new ArrayList<>());
            switch (part[0]) {
            case "[Assignment]":
                Assignment assignment = new Assignment(part[1], part[3], part[4], part[5]);
                TaskManager.pinnedTasks.get(part[0]).add(assignment);
                if (part[2].equals("[DONE] ")) {
                    assignment.markAsDone();
                }
                break;
            case "[Midterm]":
                Midterm midterm = new Midterm(part[1], part[3], part[4], part[5]);
                TaskManager.pinnedTasks.get(part[0]).add(midterm);
                if (part[2].equals("[DONE] ")) {
                    midterm.markAsDone();
                }
                break;
            case "[Final Exam]":
                FinalExam finalExam = new FinalExam(part[1], part[3], part[4], part[5]);
                TaskManager.pinnedTasks.get(part[0]).add(finalExam);
                if (part[2].equals("[DONE] ")) {
                    finalExam.markAsDone();
                }
                break;
            default:
                Task task = new Task(part[1], part[3], part[4]);
                TaskManager.pinnedTasks.get(part[0]).add(task);
                if (part[2].equals("[DONE] ")) {
                    task.markAsDone();
                }
                break;
            }
        }
    }

    public static void pinnedTasksFileSaver() throws IOException {
        FileWriter fw = new FileWriter(filePathForPinnedTasks);
        Set<String> taskTypes = TaskManager.pinnedTasks.keySet();
        for (String taskType : taskTypes) {
            switch (taskType) {
            case "[Assignment]":
                ArrayList<Task> assignments = TaskManager.pinnedTasks.get(taskType);
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
                ArrayList<Task> midterms = TaskManager.pinnedTasks.get(taskType);
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
                ArrayList<Task> finalExams = TaskManager.pinnedTasks.get(taskType);
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
                ArrayList<Task> tasks = TaskManager.pinnedTasks.get(taskType);
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

    public static void loadLinkInfoFile() throws LinkLoadException {
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

    /**
     * Creates a link object from the string in the text file and adds it into the links list.
     * Checks for a valid link first before adding into the list, and blank lines are accepted(not
     * viewed as bugs)
     *
     * @throws FileNotFoundException if there was problem opening the file
     * @throws LinkLoadException     if the link entered in the text file was invalid
     */
    public static void downloadLinks() throws FileNotFoundException, LinkLoadException {
        File f = new File(filePathForLinks); // create a File for the given file path
        Scanner s = new Scanner(f); // create a Scanner using the File as the source
        while (s.hasNext()) {
            String line = s.nextLine().toLowerCase().trim();
            if (!isValidLink(line) && !line.isBlank()) {
                throw new LinkLoadException(
                        "Link information is corrupted! Please delete and try again");
            }
            LinkInfo link = new LinkInfo(line);
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

    public static void loadMcsInfoFile() {
        filePathForMcs += "/UniTracker Data";
        File data = new File(filePathForMcs);
        if (!data.exists()) {
            boolean isCreated = data.mkdir();
            if (!isCreated) {
                System.out.println("New directory could not be created:(");
            }
        }

        try {
            filePathForMcs += "/mcs.txt";
            data = new File(filePathForMcs);
            if (data.createNewFile()) {
                return;
            }
            downloadMcs();
        } catch (IOException e) {
            System.out.println("There was an I/O error:(");
        }
    }

    public static void downloadMcs() throws FileNotFoundException {
        File f = new File(filePathForMcs);
        Scanner scanner = new Scanner(f);
        while (scanner.hasNext()) {
            String[] part = scanner.nextLine().split("~~");
            int modularCredit = Integer.parseInt(part[0]);
            double cap = Double.parseDouble(part[1]);
            HelpGraduation.setTotalMcs(modularCredit);
            HelpGraduation.setCurrentCap(cap);
        }
    }

    public static void modularCreditSaver() throws IOException {
        FileWriter fw = new FileWriter(filePathForMcs);
        fw.write(HelpGraduation.getNumberOfGradedMCsTaken() + "~~"
                + HelpGraduation.getCurrentCap());
        fw.close();
    }

}
