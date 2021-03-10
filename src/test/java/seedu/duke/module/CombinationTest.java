package seedu.duke.module;

import org.junit.jupiter.api.Test;
import seedu.duke.storage.Loader;
import seedu.duke.storage.Writer;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.duke.storage.StorageConstants.FOLDER_PATH;

class CombinationTest {

    @Test
    void addRemoveAddModule_SameModule_sizeOne() {
        removeFiles();
        ModuleList.loadModuleNames(new Loader());
        Writer writer = new Writer();
        ModuleList.addModule("CS2101", writer);
        assertEquals(1, ModuleList.getModuleList().size());
        ModuleList.removeModule(0, writer);
        assertEquals(0, ModuleList.getModuleList().size());
        ModuleList.addModule("CS2101", writer);
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