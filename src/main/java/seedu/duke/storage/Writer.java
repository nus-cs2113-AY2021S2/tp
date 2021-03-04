package seedu.duke.storage;

import seedu.duke.common.Constants;
import seedu.duke.common.Messages;
import seedu.duke.lesson.Lesson;
import seedu.duke.lesson.LessonType;
import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.task.Task;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Writer {


    /**
     * Creates file for new module.
     *
     * @param name Module name, excluding ".txt".
     */
    public void createFile(String name) {
        try {
            checkForDirectory();
            String fileName = name + Constants.FILE_FORMAT;
            File path = new File(Constants.FOLDER_PATH + "/" + fileName);
            if (path.exists()) {
                return;
            }
            path.createNewFile();
            FileWriter fileWriter = new FileWriter(path);
            writeInstructions(fileWriter, name);
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
     * @param name Module name, excluding ".txt".
     * @return True if file is gone, false if file is still around.
     */
    public boolean deleteFile(String name) {
        String fileName = name + Constants.FILE_FORMAT;
        File path = new File(Constants.FOLDER_PATH + "/" + fileName);
        if (path.exists()){
            return path.delete();
        }
        return true;
    }


    /**
     * Creates directory if it does not exist.
     *
     * @throws IOException Unable to create directory.
     */
    private void checkForDirectory() throws IOException {
        Path directory = Paths.get(Constants.FOLDER_PATH);
        if (Files.isDirectory(directory)) {
            return;
        }
        Files.createDirectory(directory);
    }


    /**
     * Updates changes to module in file.
     * Writes module instructions and data to module file.
     */
    public void writeModule() {
        try {
            Module module = ModuleList.selectedModule;
            File path = getFile(module);
            FileWriter fileWriter = new FileWriter(path);
            writeInstructions(fileWriter, module.getModuleCode());
            writeLessons(fileWriter, module);
            writeTasks(fileWriter, module);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            //Error editing file
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
        String fileName = module.getModuleCode() + Constants.FILE_FORMAT;
        File path = new File(Constants.FOLDER_PATH + "/" + fileName);
        if (!path.exists()) {
            //File does not exist
            path.createNewFile();
        }
        return path;
    }


    /**
     * Writes instructions to module file.
     *
     * @param fileWriter FileWriter for module file.
     * @param name Module name, excluding ".txt".
     * @throws IOException Unable to write to file.
     */
    private void writeInstructions(FileWriter fileWriter, String name) throws IOException {
        fileWriter.write(name + Messages.FILE_INSTRUCTIONS);
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
            String entry = Constants.KEYWORD_LESSON;
            entry += getLessonTypeString(lesson.getLessonType()) + Constants.DIVIDER_WRITE;
            entry += lesson.getTime() + Constants.DIVIDER_WRITE;
            entry += lesson.getOnlineLink() + Constants.DIVIDER_WRITE;
            entry += lesson.getTeachingStaff().getName() + Constants.DIVIDER_WRITE;
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
            String entry = Constants.KEYWORD_TASK;
            entry += task.getDescription() + Constants.DIVIDER_WRITE;
            entry += getDeadlineString(task.getDeadline()) + Constants.DIVIDER_WRITE;
            entry += getTrueFalseString(task.getDone()) + Constants.DIVIDER_WRITE;
            entry += getTrueFalseString(task.getGraded());
            if (task.getRemarks().length() > 0) {
                entry += Constants.DIVIDER_WRITE + task.getRemarks();
            }
            fileWriter.write(entry + '\n');
        }
    }


    /**
     * Returns string of lesson type.
     *
     * @param lessonType Lesson type to convert.
     * @return String of lesson type.
     */
    private String getLessonTypeString(LessonType lessonType) {
        switch (lessonType) {
        case LECTURE: {
            return Constants.TYPE_LECTURE;
        }
        case TUTORIAL: {
            return Constants.TYPE_TUTORIAL;
        }
        default: {
            return Constants.TYPE_LAB;
        }
        }
    }


    /**
     * Returns string of deadline.
     *
     * @param deadline LocalDateTime to convert.
     * @return String of deadline.
     */
    private String getDeadlineString(LocalDateTime deadline) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.DATE_IO_FORMAT);
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
            return "T";
        }
        return "F";
    }
}
