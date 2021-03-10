package seedu.duke.module;

import org.junit.jupiter.api.Test;
import seedu.duke.storage.Loader;
import seedu.duke.storage.Writer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static seedu.duke.storage.StorageConstants.FOLDER_PATH;

class SetSelectedModuleTest {

    @Test
    void setSelectedModule_validName_loadsModule() throws IOException {
        removeFiles();
        ModuleList.loadModuleNames(new Loader());
        ModuleList.reset();
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
        removeFiles();
        ModuleList.loadModuleNames(new Loader());
        ModuleList.reset();
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
        removeFiles();
        ModuleList.loadModuleNames(new Loader());
        ModuleList.reset();
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
        removeFiles();
        ModuleList.loadModuleNames(new Loader());
        ModuleList.reset();
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

    private void removeFiles() {
        File directory = new File(FOLDER_PATH);
        File[] files = directory.listFiles();
        if (files == null) {
            return;
        }
        for (File file : files) {
            file.delete();
        }
        directory.delete();
    }
}