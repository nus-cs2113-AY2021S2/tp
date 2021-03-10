package seedu.duke.module;

import org.junit.jupiter.api.Test;
import seedu.duke.storage.Loader;
import seedu.duke.storage.Writer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.duke.storage.StorageConstants.FOLDER_PATH;

class AddModuleTest {

    @Test
    void addModule_twoDifferentModules_sizeTwo() throws IOException {
        removeFiles();
        ModuleList.loadModuleNames(new Loader());
        Writer writer = new Writer();
        ModuleList.addModule("CS2101", writer);
        ModuleList.addModule("CS2113T", writer);
        Path reference = Paths.get("src/test/java/seedu/duke/storage/reference/empty_reference.txt");
        Path actual1 = Paths.get("Data/CS2113T.txt");
        Path actual2 = Paths.get("Data/CS2101.txt");
        boolean isExist = Files.exists(actual1) && Files.exists(actual2);
        boolean isIdentical = Files.readAllLines(reference).equals(Files.readAllLines(actual1));
        boolean isTwo = ModuleList.getModuleList().size() == 2;
        assertTrue(isExist);
        assertTrue(isIdentical);
        assertTrue(isTwo);
    }

    @Test
    void addModule_twoSameModules_sizeOne() throws  IOException {
        removeFiles();
        ModuleList.loadModuleNames(new Loader());
        Writer writer = new Writer();
        ModuleList.addModule("CS2113T", writer);
        ModuleList.addModule("CS2113T", writer);
        System.out.println(ModuleList.getModuleList().size());
        Path reference = Paths.get("src/test/java/seedu/duke/storage/reference/empty_reference.txt");
        Path actual1 = Paths.get("Data/CS2113T.txt");
        boolean isExist = Files.exists(actual1);
        boolean isIdentical = Files.readAllLines(reference).equals(Files.readAllLines(reference));
        boolean isOne = ModuleList.getModuleList().size() == 1;
        assertTrue(isExist);
        assertTrue(isIdentical);
        assertTrue(isOne);
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