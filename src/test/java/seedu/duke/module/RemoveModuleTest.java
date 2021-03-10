package seedu.duke.module;

import org.junit.jupiter.api.Test;
import seedu.duke.storage.Loader;
import seedu.duke.storage.Writer;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.duke.storage.StorageConstants.FOLDER_PATH;

class RemoveModuleTest {

    @Test
    void removeModule_validIndex_removes() {
        removeFiles();
        ModuleList.loadModuleNames(new Loader());
        Writer writer = new Writer();
        ModuleList.addModule("CS2113T", writer);
        ModuleList.addModule("CS2101", writer);
        ModuleList.removeModule(1, writer);
        assertEquals(1, ModuleList.getModuleList().size());
    }

    @Test
    void removeModule_negativeIndex_noChange() {
        removeFiles();
        ModuleList.loadModuleNames(new Loader());
        Writer writer = new Writer();
        ModuleList.addModule("CS2113T", writer);
        ModuleList.addModule("CS2101", writer);
        ModuleList.removeModule(-1, writer);
        assertEquals(2, ModuleList.getModuleList().size());
    }

    @Test
    void removeModule_indexOutOfBounds_noChange() {
        removeFiles();
        ModuleList.loadModuleNames(new Loader());
        Writer writer = new Writer();
        ModuleList.addModule("CS2113T", writer);
        ModuleList.addModule("CS2101", writer);
        ModuleList.removeModule(2, writer);
        assertEquals(2, ModuleList.getModuleList().size());
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