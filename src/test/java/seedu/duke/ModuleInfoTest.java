package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.features.moduleinfo.Module;
import seedu.duke.features.moduleinfo.ModuleInfo;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.duke.features.moduleinfo.ModuleInfo.checkIfIndexIsWithinBounds;

class ModuleInfoTest {
    @Test
    void isEmptyList_emptyList_printEmptyListMessage() {
        ModuleInfo.modules = new ArrayList<>();
        assertFalse(ModuleInfo.viewAllModules());
    }

    @Test
    void isModuleDeleted_moduleIsDeleted_printDeletedModuleMessage() {
        ModuleInfo.modules = new ArrayList<>();
        Module module = new Module("CS2113T", "Software Eng & OOP");
        ModuleInfo.modules.add(module);
        assertTrue(ModuleInfo.testDeleteModule(0));
    }

    @Test
    void isValidIndex_indexIsInvalid_returnFalse() {
        ModuleInfo.modules = new ArrayList<>();
        Module module = new Module("testModule1", "fakeModule1");
        ModuleInfo.modules.add(module);
        module = new Module("testModule2", "fakeModule2");
        ModuleInfo.modules.add(module);
        assertFalse(checkIfIndexIsWithinBounds(2));
    }

    @Test
    void isValidIndex_indexIsValid_returnTrue() {
        ModuleInfo.modules = new ArrayList<>();
        Module module = new Module("testModule1", "fakeModule1");
        ModuleInfo.modules.add(module);
        module = new Module("testModule2", "fakeModule2");
        ModuleInfo.modules.add(module);
        assertTrue(checkIfIndexIsWithinBounds(0));
    }

}
