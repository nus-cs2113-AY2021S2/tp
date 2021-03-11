package seedu.duke.module;

import org.junit.jupiter.api.Test;
import seedu.duke.TestUtilAndConstants;
import seedu.duke.storage.Writer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.duke.TestUtilAndConstants.MODULE_CODE_1;
import static seedu.duke.TestUtilAndConstants.MODULE_CODE_4;
import static seedu.duke.common.Constants.FOLDER_PATH;
import static seedu.duke.common.Constants.TXT_FORMAT;

class ModuleListTest {

    @Test
    void loadModuleNames_noDirectory_sizeZero() {
        TestUtilAndConstants.removeFiles();
        ModuleList.loadModuleNames();
        assertEquals(0, ModuleList.getModules().size());
    }

    @Test
    void loadModuleNames_oneInvalidFile_sizeZero() throws IOException {
        TestUtilAndConstants.removeFiles();
        File directory = new File(FOLDER_PATH);
        directory.mkdir();
        File file1 = new File(FOLDER_PATH + "/" + "CS2113T.img");
        file1.createNewFile();
        ModuleList.loadModuleNames();
        assertEquals(0, ModuleList.getModules().size());
    }

    @Test
    void loadModuleNames_twoDifferentModules_sizeTwo() throws IOException {
        TestUtilAndConstants.removeFiles();
        File directory = new File(FOLDER_PATH);
        directory.mkdir();
        File file1 = new File(FOLDER_PATH + "/" + MODULE_CODE_1 + TXT_FORMAT);
        file1.createNewFile();
        File file2 = new File(FOLDER_PATH + "/" + MODULE_CODE_4 + TXT_FORMAT);
        file2.createNewFile();
        ModuleList.loadModuleNames();
        assertEquals(2, ModuleList.getModules().size());
    }

    @Test
    void loadModuleNames_twoSameModules_sizeTwo() throws IOException {
        TestUtilAndConstants.removeFiles();
        File directory = new File(FOLDER_PATH);
        directory.mkdir();
        File file1 = new File(FOLDER_PATH + "/" + MODULE_CODE_1 + TXT_FORMAT);
        file1.createNewFile();
        file1.createNewFile();
        ModuleList.loadModuleNames();
        assertEquals(1, ModuleList.getModules().size());
    }

    @Test
    void setSelectedModule_validName_loadsModule() throws IOException {
        TestUtilAndConstants.removeFiles();
        ModuleList.loadModuleNames();
        ModuleList.reset();
        File directory = new File(FOLDER_PATH);
        directory.mkdir();
        Path reference = Paths.get("src/test/java/seedu/duke/storage/reference/all_content_reference.txt");
        Path destination = Paths.get("Data/CS2113T.txt");
        if (Files.exists(destination)) {
            Files.delete(destination);
        }
        Files.copy(reference, destination);
        ModuleList.loadModuleNames();
        ModuleList.setSelectedModule(MODULE_CODE_1);
        assertEquals(2, ModuleList.getSelectedModule().getTaskList().size());
    }

    @Test
    void setSelectedModule_invalidName_remainNull() throws IOException {
        TestUtilAndConstants.removeFiles();
        ModuleList.loadModuleNames();
        ModuleList.reset();
        File directory = new File(FOLDER_PATH);
        directory.mkdir();
        Path reference = Paths.get("src/test/java/seedu/duke/storage/reference/all_content_reference.txt");
        Path destination = Paths.get("Data/CS2113T.txt");
        if (Files.exists(destination)) {
            Files.delete(destination);
        }
        Files.copy(reference, destination);
        ModuleList.loadModuleNames();
        ModuleList.setSelectedModule("CS2100");
        assertThrows(NullPointerException.class, () -> {
            ModuleList.getSelectedModule().getModuleCode();
        });
    }

    @Test
    void setSelectedModule_invalidFile_noTaskAndLesson() throws IOException {
        TestUtilAndConstants.removeFiles();
        ModuleList.loadModuleNames();
        ModuleList.reset();
        File directory = new File(FOLDER_PATH);
        directory.mkdir();
        Path reference = Paths.get("src/test/java/seedu/duke/storage/reference/invalid_file_reference.txt");
        Path destination = Paths.get("Data/CS2113T.txt");
        if (Files.exists(destination)) {
            Files.delete(destination);
        }
        Files.copy(reference, destination);
        ModuleList.loadModuleNames();
        ModuleList.setSelectedModule(MODULE_CODE_1);
        assertEquals(0,ModuleList.getSelectedModule().getTaskList().size());
        assertEquals(0,ModuleList.getSelectedModule().getLessonList().size());
    }

    @Test
    void setSelectedModule_invalidContent_() throws IOException {
        TestUtilAndConstants.removeFiles();
        ModuleList.loadModuleNames();
        ModuleList.reset();
        File directory = new File(FOLDER_PATH);
        directory.mkdir();
        Path reference = Paths.get("src/test/java/seedu/duke/storage/reference/invalid_content_reference.txt");
        Path destination = Paths.get("Data/CS2113T.txt");
        if (Files.exists(destination)) {
            Files.delete(destination);
        }
        Files.copy(reference, destination);
        ModuleList.loadModuleNames();
        ModuleList.setSelectedModule(MODULE_CODE_1);
        assertEquals(3,ModuleList.getSelectedModule().getLessonList().size());
        assertEquals(1,ModuleList.getSelectedModule().getTaskList().size());
    }

    @Test
    void addModule_twoDifferentModules_sizeTwo() throws IOException {
        TestUtilAndConstants.removeFiles();
        ModuleList.loadModuleNames();
        Writer writer = new Writer();
        ModuleList.addModule(MODULE_CODE_4);
        ModuleList.addModule(MODULE_CODE_1);
        Path reference = Paths.get("src/test/java/seedu/duke/storage/reference/empty_reference.txt");
        Path actual1 = Paths.get("Data/CS2113T.txt");
        Path actual2 = Paths.get("Data/CS2101.txt");
        boolean isExist = Files.exists(actual1) && Files.exists(actual2);
        boolean isIdentical = Files.readAllLines(reference).equals(Files.readAllLines(actual1));
        boolean isTwo = ModuleList.getModules().size() == 2;
        assertTrue(isExist);
        assertTrue(isIdentical);
        assertTrue(isTwo);
    }

    @Test
    void addModule_twoSameModules_sizeOne() throws  IOException {
        TestUtilAndConstants.removeFiles();
        ModuleList.loadModuleNames();
        Writer writer = new Writer();
        ModuleList.addModule(MODULE_CODE_1);
        ModuleList.addModule(MODULE_CODE_1);
        System.out.println(ModuleList.getModules().size());
        Path reference = Paths.get("src/test/java/seedu/duke/storage/reference/empty_reference.txt");
        Path actual1 = Paths.get("Data/CS2113T.txt");
        boolean isExist = Files.exists(actual1);
        boolean isIdentical = Files.readAllLines(reference).equals(Files.readAllLines(reference));
        boolean isOne = ModuleList.getModules().size() == 1;
        assertTrue(isExist);
        assertTrue(isIdentical);
        assertTrue(isOne);
    }

    @Test
    void removeModule_validIndex_removes() {
        TestUtilAndConstants.removeFiles();
        ModuleList.loadModuleNames();
        ModuleList.addModule(MODULE_CODE_1);
        ModuleList.addModule(MODULE_CODE_4);
        ModuleList.removeModule(1);
        assertEquals(1, ModuleList.getModules().size());
    }

    @Test
    void removeModule_negativeIndex_noChange() {
        TestUtilAndConstants.removeFiles();
        ModuleList.loadModuleNames();
        ModuleList.addModule(MODULE_CODE_1);
        ModuleList.addModule(MODULE_CODE_4);
        ModuleList.removeModule(-1);
        assertEquals(2, ModuleList.getModules().size());
    }

    @Test
    void removeModule_indexOutOfBounds_noChange() {
        TestUtilAndConstants.removeFiles();
        ModuleList.loadModuleNames();
        ModuleList.addModule(MODULE_CODE_1);
        ModuleList.addModule(MODULE_CODE_4);
        ModuleList.removeModule(2);
        assertEquals(2, ModuleList.getModules().size());
    }

    @Test
    void addRemoveAddModule_SameModule_sizeOne() {
        TestUtilAndConstants.removeFiles();
        ModuleList.loadModuleNames();
        ModuleList.addModule(MODULE_CODE_4);
        assertEquals(1, ModuleList.getModules().size());
        ModuleList.removeModule(0);
        assertEquals(0, ModuleList.getModules().size());
        ModuleList.addModule(MODULE_CODE_4);
        assertEquals(1, ModuleList.getModules().size());
    }
}