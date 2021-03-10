package seedu.duke.module;

import org.junit.jupiter.api.Test;
import seedu.duke.storage.Loader;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.duke.storage.StorageConstants.FOLDER_PATH;
import static seedu.duke.storage.StorageConstants.TXT_FORMAT;

class LoadModuleNamesTest {

    @Test
    void loadModuleNames_noDirectory_sizeZero() {
        removeFiles();
        ModuleList.loadModuleNames(new Loader());
        assertEquals(0, ModuleList.getModuleList().size());
    }

    @Test
    void loadModuleNames_oneInvalidFile_sizeZero() throws IOException {
        removeFiles();
        File directory = new File(FOLDER_PATH);
        directory.mkdir();
        File file1 = new File(FOLDER_PATH + "/" + "CS2113T.img");
        file1.createNewFile();
        ModuleList.loadModuleNames(new Loader());
        assertEquals(0, ModuleList.getModuleList().size());
    }

    @Test
    void loadModuleNames_twoDifferentModules_sizeTwo() throws IOException {
        removeFiles();
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
        removeFiles();
        File directory = new File(FOLDER_PATH);
        directory.mkdir();
        File file1 = new File(FOLDER_PATH + "/" + "CS2113T" + TXT_FORMAT);
        file1.createNewFile();
        file1.createNewFile();
        ModuleList.loadModuleNames(new Loader());
        assertEquals(1, ModuleList.getModuleList().size());
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