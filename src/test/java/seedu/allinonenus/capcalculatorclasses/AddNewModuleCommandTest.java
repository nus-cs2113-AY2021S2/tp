package seedu.allinonenus.capcalculatorclasses;

import org.junit.jupiter.api.Test;
import seedu.allinonenus.capcalculatorclasses.commandsforcapcalculator.AddNewModuleCommand;
import seedu.allinonenus.capcalculatorclasses.commandsforcapcalculator.ModuleData;
import seedu.allinonenus.capcalculatorclasses.exceptionsforcapcalculator.InvalidGradeException;
import seedu.allinonenus.capcalculatorclasses.logicforcapcalculator.ModuleList;
import seedu.allinonenus.capcalculatorclasses.storageforcapcalculator.ModuleStorage;
import seedu.allinonenus.capcalculatorclasses.uiforcapcalculator.UiText;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AddNewModuleCommandTest {

    @Test
    void executeAddCommandIntegrationExceptionTest() {
        AddNewModuleCommand moduleCommand = new AddNewModuleCommand();
        UiText ui = new UiText();
        String command = "add CS2113T G 4";
        ModuleList ml = new ModuleList();
        ModuleStorage moduleStorage = new ModuleStorage();

        assertThrows(InvalidGradeException.class , () -> moduleCommand.executeCommand(ml,moduleStorage,ui,command));

    }

    @Test
    void executemissingParametersIntegrationExceptionTest() {
        AddNewModuleCommand moduleCommand = new AddNewModuleCommand();
        UiText ui = new UiText();
        String command = "CS2113T G 4";
        ModuleList ml = new ModuleList();
        ModuleStorage moduleStorage = new ModuleStorage();

        assertThrows(ArrayIndexOutOfBoundsException.class , () -> moduleCommand.executeCommand(ml,moduleStorage,ui,command));

    }

    @Test
    void checkIfModuleExistTest(){
        AddNewModuleCommand moduleCommand = new AddNewModuleCommand();
        ModuleList ml = new ModuleList();
        ModuleData md = new ModuleData("CS2040C","B-",4,2);
        ml.add(md);
        assertEquals(true,moduleCommand.checkIfModuleExists(ml,"CS1010",2));
        assertEquals(false,moduleCommand.checkIfModuleExists(ml,"CS2040C",2));

    }

    @Test
    void checkMcFormatTest() {
        AddNewModuleCommand moduleCommand = new AddNewModuleCommand();
        int mcs = 2;
        assertEquals(true,moduleCommand.checkMcFormat(mcs));
        mcs = 1;
        assertEquals(false,moduleCommand.checkMcFormat(mcs));
        mcs = 12;
        assertEquals(true,moduleCommand.checkMcFormat(mcs));
        mcs = 13;
        assertEquals(false,moduleCommand.checkMcFormat(mcs));
    }



}
