package seedu.duke;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ModuleInfoTest {
    @Test
    void isEmptyList_emptyList_printEmptyListMessage() {
        ModuleInfo.modules = new ArrayList<>();
        assertFalse(ModuleInfo.viewAllModules());
    }
}