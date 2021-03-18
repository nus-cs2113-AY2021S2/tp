package seedu.duke;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ModuleInfoTest {
    @Test
    void isEmptyList_emptyList_printEmptyListMessage() {
        ArrayList<Module> emptyList = new ArrayList<>();
        assertFalse(Ui.printAllModulesIfNotEmpty(emptyList));
    }
}