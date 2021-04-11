package seedu.duke.storage;

import seedu.duke.lesson.Lesson;
import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.task.Task;
import seedu.duke.ui.UI;

import static seedu.duke.common.Constants.DIVIDER_WRITE;
import static seedu.duke.common.Constants.FALSE_STRING;
import static seedu.duke.common.Constants.FOLDER_PATH;
import static seedu.duke.common.Constants.FORMAT_DATE_IO;
import static seedu.duke.common.Constants.KEYWORD_LESSON;
import static seedu.duke.common.Constants.KEYWORD_TASK;
import static seedu.duke.common.Constants.STRING_CHEATSHEET;
import static seedu.duke.common.Constants.TRUE_STRING;
import static seedu.duke.common.Constants.TXT_FORMAT;
import static seedu.duke.common.Messages.FILE_INSTRUCTIONS;
import static seedu.duke.common.Messages.MESSAGE_WRITER_FAILED_TO_SAVE;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Writer {

    //@@author 8kdesign
    /**
     * Creates file for new module.
     *
     * @param moduleCode Module code, excluding ".txt".
     */
    public void createFile(String moduleCode) {
        try {
            checkForDirectories(moduleCode);
            String fileName = moduleCode + TXT_FORMAT;
            File path = new File(FOLDER_PATH + "/" + moduleCode + "/" + fileName);
            path.createNewFile();
            FileWriter fileWriter = new FileWriter(path);
            writeInstructions(fileWriter, moduleCode);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            //Error creating file
        }
    }

    /**
     * Deletes specified file.
     * Returns true if deleted, or file does not exist, false if unable to delete.
     *
     * @param moduleCode Module code, excluding ".txt".
     * @return True if file is gone, false if file is still around.
     */
    public boolean deleteDirectory(String moduleCode) {
        File directory = new File(FOLDER_PATH + "/" + moduleCode);
        return recursivelyRemoveFiles(directory);
    }

    /**
     * Deletes all files in specified directory.
     * Recursively calls itself if a directory is in the specified directory.
     * 
     * @param directory Directory to delete.
     * @return False if error deleting, true if successful.
     */
    public static boolean recursivelyRemoveFiles(File directory) {
        File[] files = directory.listFiles();
        if (files == null) {
            return true;
        }
        for (File file : files) {
            if (file.isDirectory()) {
                if (!recursivelyRemoveFiles(file)) {
                    //Unable to remove directory
                    return false;
                }
            } else if (!file.delete()) {
                //Unable to remove file
                return false;
            }
        }
        return directory.delete();
    }

    /**
     * Creates directory if it does not exist.
     *
     * @throws IOException Unable to create directory.
     */
    private void checkForDirectories(String moduleCode) throws IOException {
        String directory = FOLDER_PATH;
        File mainDirectory = new File(directory);
        mainDirectory.mkdir();
        directory += "/" + moduleCode;
        File moduleDirectory = new File(directory);
        moduleDirectory.mkdir();
        directory += "/" + STRING_CHEATSHEET;
        File cheatsheetDirectory = new File(directory);
        cheatsheetDirectory.mkdir();
    }

    /**
     * Updates changes to module in file.
     * Writes module instructions and data to module file.
     */
    public void writeModule() {
        try {
            Module module = ModuleList.getSelectedModule();
            File path = getFile(module);
            FileWriter fileWriter = new FileWriter(path);
            writeInstructions(fileWriter, module.getModuleCode());
            writeLessons(fileWriter, module);
            writeTasks(fileWriter, module);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            //Error editing file
            new UI().printMessage(MESSAGE_WRITER_FAILED_TO_SAVE);
        }
    }

    /**
     * Returns module file.
     *
     * @param module Selected module.
     * @return Module file for selected module.
     * @throws IOException Unable to create file.
     */
    private File getFile(Module module) throws IOException {
        String moduleCode = module.getModuleCode();
        String fileName = moduleCode + TXT_FORMAT;
        File path = new File(FOLDER_PATH + "/" + moduleCode + "/" + fileName);
        if (!path.exists()) {
            //File does not exist
            createFile(moduleCode);
            assert path.exists();
        }
        return path;
    }

    /**
     * Writes instructions to module file.
     *
     * @param fileWriter FileWriter for module file.
     * @param moduleCode Module code, excluding ".txt".
     * @throws IOException Unable to write to file.
     */
    private void writeInstructions(FileWriter fileWriter, String moduleCode) throws IOException {
        fileWriter.write(moduleCode + FILE_INSTRUCTIONS);
    }

    /**
     * Writes lessons to module file.
     *
     * @param fileWriter FileWriter for module file.
     * @param module Selected module.
     * @throws IOException Unable to write to file.
     */
    private void writeLessons(FileWriter fileWriter, Module module) throws IOException {
        for (Lesson lesson : module.getLessonList()) {
            String entry = KEYWORD_LESSON;
            entry += lesson.getLessonTypeString().toLowerCase() + DIVIDER_WRITE;
            entry += lesson.getTime() + DIVIDER_WRITE;
            entry += lesson.getOnlineLink() + DIVIDER_WRITE;
            entry += lesson.getTeachingStaff().getName() + DIVIDER_WRITE;
            entry += lesson.getTeachingStaff().getEmail();
            fileWriter.write(entry + '\n');
        }
    }

    /**
     * Writes tasks to module file.
     *
     * @param fileWriter FileWriter for module file.
     * @param module Selected module.
     * @throws IOException Unable to write to file.
     */
    private void writeTasks(FileWriter fileWriter, Module module) throws IOException {
        for (Task task : module.getTaskList()) {
            String entry = KEYWORD_TASK;
            entry += task.getDescription() + DIVIDER_WRITE;
            entry += getDeadlineString(task.getDeadline()) + DIVIDER_WRITE;
            entry += getTrueFalseString(task.getDone()) + DIVIDER_WRITE;
            entry += getTrueFalseString(task.getGraded());
            if (task.getRemarks().length() > 0) {
                entry += DIVIDER_WRITE + task.getRemarks();
            }
            fileWriter.write(entry + '\n');
        }
    }

    /**
     * Returns string of deadline.
     *
     * @param deadline LocalDateTime to convert.
     * @return String of deadline.
     */
    private String getDeadlineString(LocalDate deadline) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT_DATE_IO);
        return deadline.format(formatter);
    }

    /**
     * Converts boolean to storage format.
     *
     * @param isTrue Boolean to convert.
     * @return "T" if true, "F" if false.
     */
    private String getTrueFalseString(Boolean isTrue) {
        if (isTrue) {
            return TRUE_STRING;
        }
        return FALSE_STRING;
    }
}
