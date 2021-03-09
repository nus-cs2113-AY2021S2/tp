package seedu.duke.module;

import org.junit.jupiter.api.Test;
import seedu.duke.storage.Loader;
import seedu.duke.storage.Writer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.duke.storage.StorageConstants.FOLDER_PATH;
import static seedu.duke.storage.StorageConstants.TXT_FORMAT;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class ModuleListStorageTest {

    @Test
    void loadModuleNames_noDirectory_sizeZero() {
        //Ensure that "Data" folder is deleted before running
        ModuleList.loadModuleNames(new Loader());
        assertEquals(0, ModuleList.getModuleList().size());
    }

    @Test
    void loadModuleNames_oneInvalidFile_sizeZero() throws IOException {
        //Ensure that "Data" folder is deleted before running
        File directory = new File(FOLDER_PATH);
        directory.mkdir();
        File file1 = new File(FOLDER_PATH + "/" + "CS2113T.img");
        file1.createNewFile();
        ModuleList.loadModuleNames(new Loader());
        assertEquals(0, ModuleList.getModuleList().size());
    }

    @Test
    void loadModuleNames_twoDifferentModules_sizeTwo() throws IOException {
        //Ensure that "Data" folder is deleted before running
        File directory = new File(FOLDER_PATH);
        directory.mkdir();
        File file1 = new File(FOLDER_PATH + "/" + "CS2113T" + TXT_FORMAT);
        file1.createNewFile();
        File file2 = new File(FOLDER_PATH + "/" + "CS2101" + TXT_FORMAT);
        file2.createNewFile();
        ModuleList.loadModuleNames(new Loader());
        assertEquals(2, ModuleList.getModuleList().size());
    }

    @Test
    void loadModuleNames_twoSameModules_sizeTwo() throws IOException {
        //Ensure that "Data" folder is deleted before running
        File directory = new File(FOLDER_PATH);
        directory.mkdir();
        File file1 = new File(FOLDER_PATH + "/" + "CS2113T" + TXT_FORMAT);
        file1.createNewFile();
        file1.createNewFile();
        ModuleList.loadModuleNames(new Loader());
        assertEquals(1, ModuleList.getModuleList().size());
    }

    @Test
    void addModule_twoDifferentModules_sizeTwo() throws IOException {
        //Ensure that "Data" folder is deleted before running
        Writer writer = new Writer();
        ModuleList.addModule("CS2101", writer);
        ModuleList.addModule("CS2113T", writer);
        Path reference = Paths.get("src/test/java/seedu/duke/storage/reference/empty_reference.txt");
        Path actual1 = Paths.get("Data/CS2113T.txt");
        Path actual2 = Paths.get("Data/CS2101.txt");
        boolean isExist = Files.exists(actual1) && Files.exists(actual2);
        boolean isIdentical = Files.readAllLines(reference).equals(Files.readAllLines(actual1));
        boolean isTwo = ModuleList.getModuleList().size() == 2;
        assertTrue(isExist & isIdentical & isTwo);
    }

    @Test
    void addModule_twoSameModules_sizeOne() throws  IOException {
        Writer writer = new Writer();
        ModuleList.addModule("CS2113T", writer);
        ModuleList.addModule("CS2113T", writer);
        Path reference = Paths.get("src/test/java/seedu/duke/storage/reference/empty_reference.txt");
        Path actual1 = Paths.get("Data/CS2113T.txt");
        boolean isExist = Files.exists(actual1);
        boolean isIdentical = Files.readAllLines(reference).equals(Files.readAllLines(actual1));
        boolean isOne = ModuleList.getModuleList().size() == 1;
        assertTrue(isExist & isIdentical & isOne);
    }

    @Test
    void removeModule_validIndex_removes() {
        Writer writer = new Writer();
        ModuleList.addModule("CS2113T", writer);
        ModuleList.addModule("CS2101", writer);
        ModuleList.removeModule(1, writer);
        assertEquals(1, ModuleList.getModuleList().size());
    }

    @Test
    void removeModule_negativeIndex_noChange() {
        Writer writer = new Writer();
        ModuleList.addModule("CS2113T", writer);
        ModuleList.addModule("CS2101", writer);
        ModuleList.removeModule(-1, writer);
        assertEquals(2, ModuleList.getModuleList().size());
    }

    @Test
    void removeModule_indexOutOfBounds_noChange() {
        Writer writer = new Writer();
        ModuleList.addModule("CS2113T", writer);
        ModuleList.addModule("CS2101", writer);
        ModuleList.removeModule(2, writer);
        assertEquals(2, ModuleList.getModuleList().size());
    }

    @Test
    void setSelectedModule_validName_loadsModule() throws IOException {
        File directory = new File(FOLDER_PATH);
        directory.mkdir();
        Path reference = Paths.get("src/test/java/seedu/duke/storage/reference/all_content_reference.txt");
        Path destination = Paths.get("Data/CS2113T.txt");
        if (Files.exists(destination)) {
            Files.delete(destination);
        }
        Files.copy(reference, destination);
        ModuleList.loadModuleNames(new Loader());
        ModuleList.setSelectedModule("CS2113T", new Loader(), new Writer());
        assertEquals(2, ModuleList.selectedModule.getTaskList().size());
    }

    @Test
    void setSelectedModule_invalidName_remainNull() throws IOException {
        File directory = new File(FOLDER_PATH);
        directory.mkdir();
        Path reference = Paths.get("src/test/java/seedu/duke/storage/reference/all_content_reference.txt");
        Path destination = Paths.get("Data/CS2113T.txt");
        if (Files.exists(destination)) {
            Files.delete(destination);
        }
        Files.copy(reference, destination);
        ModuleList.loadModuleNames(new Loader());
        ModuleList.setSelectedModule("CS2100", new Loader(), new Writer());
        assertThrows(NullPointerException.class, () -> {
            ModuleList.selectedModule.getModuleCode();
        });
    }

    @Test
    void setSelectedModule_invalidFile_noTaskAndLesson() throws IOException {
        File directory = new File(FOLDER_PATH);
        directory.mkdir();
        Path reference = Paths.get("src/test/java/seedu/duke/storage/reference/invalid_file_reference.txt");
        Path destination = Paths.get("Data/CS2113T.txt");
        if (Files.exists(destination)) {
            Files.delete(destination);
        }
        Files.copy(reference, destination);
        ModuleList.loadModuleNames(new Loader());
        ModuleList.setSelectedModule("CS2113T", new Loader(), new Writer());
        assertEquals(0,ModuleList.selectedModule.getTaskList().size());
        assertEquals(0,ModuleList.selectedModule.getLessonList().size());
    }

    @Test
    void setSelectedModule_invalidContent_() throws IOException {
        File directory = new File(FOLDER_PATH);
        directory.mkdir();
        Path reference = Paths.get("src/test/java/seedu/duke/storage/reference/invalid_content_reference.txt");
        Path destination = Paths.get("Data/CS2113T.txt");
        if (Files.exists(destination)) {
            Files.delete(destination);
        }
        Files.copy(reference, destination);
        ModuleList.loadModuleNames(new Loader());
        ModuleList.setSelectedModule("CS2113T", new Loader(), new Writer());
        assertEquals(3,ModuleList.selectedModule.getLessonList().size());
        assertEquals(1,ModuleList.selectedModule.getTaskList().size());
    }
}