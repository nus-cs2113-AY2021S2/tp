package seedu.igraduate.logic.command.updatecommand;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.igraduate.logic.command.Command;
import seedu.igraduate.logic.parser.Parser;
import seedu.igraduate.model.list.ModuleList;
import seedu.igraduate.storage.Storage;
import seedu.igraduate.ui.Ui;

import seedu.igraduate.exception.InvalidModuleGradeException;
import seedu.igraduate.exception.InvalidModuleCodeException;
import seedu.igraduate.exception.InvalidModularCreditException;
import seedu.igraduate.exception.UnableToDeletePrereqModuleException;
import seedu.igraduate.exception.PrerequisiteNotFoundException;
import seedu.igraduate.exception.ModuleNotFoundException;
import seedu.igraduate.exception.SaveModuleFailException;
import seedu.igraduate.exception.InputNotNumberException;
import seedu.igraduate.exception.ExistingModuleException;
import seedu.igraduate.exception.IllegalParametersException;
import seedu.igraduate.exception.ModuleNotCompleteException;
import seedu.igraduate.exception.IncorrectParameterCountException;
import seedu.igraduate.exception.InvalidCommandException;
import seedu.igraduate.exception.InvalidModuleTypeException;
import seedu.igraduate.exception.InvalidListTypeException;
import seedu.igraduate.exception.PrerequisiteNotMetException;
import seedu.igraduate.exception.AddSelfToPrereqException;
import seedu.igraduate.exception.MarkCompletedModuleException;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.nio.file.Paths;

public class UpdateCommandIntegrationTest {
    private static final File FILEPATH = Paths.get("./commandteststorage/updateCommandData.json").toFile();

    private Storage storage = Storage.getStorage(FILEPATH);
    private Ui ui = new Ui();
    private ModuleList moduleList = new ModuleList();
    private Parser parser = new Parser();

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void populateList() throws InvalidCommandException, InvalidModuleTypeException, InputNotNumberException,
            IncorrectParameterCountException, ExistingModuleException, InvalidModularCreditException,
            ModuleNotCompleteException, SaveModuleFailException, InvalidModuleGradeException,
            UnableToDeletePrereqModuleException, PrerequisiteNotFoundException, ModuleNotFoundException,
            InvalidListTypeException, PrerequisiteNotMetException, AddSelfToPrereqException,
            MarkCompletedModuleException, IllegalParametersException, InvalidModuleCodeException {
        String module = "add Programming Methodology -mc 4 -t core -c cs1010";
        Command addModule = parser.parseCommand(module);
        addModule.execute(moduleList, ui, storage);
        String setToDone = "done cs1010 -g A+";
        Command doneModule = parser.parseCommand(setToDone);
        doneModule.execute(moduleList, ui, storage);
    }

    @Test
    void executeUpdateCommand_validParameters_success() throws InvalidModularCreditException, InputNotNumberException,
            InvalidModuleGradeException, PrerequisiteNotFoundException, ModuleNotCompleteException,
            ExistingModuleException, InvalidModuleTypeException, PrerequisiteNotMetException, ModuleNotFoundException,
            InvalidListTypeException, AddSelfToPrereqException, SaveModuleFailException, InvalidCommandException,
            UnableToDeletePrereqModuleException, IncorrectParameterCountException, MarkCompletedModuleException,
            IllegalParametersException, InvalidModuleCodeException {
        String line = "update CS1010 -g A- -mc 2";
        Command updateCommand = parser.parseCommand(line);
        System.setOut(new PrintStream(outContent));
        updateCommand.execute(moduleList, ui, storage);
        assertEquals("Nice! I've updated this module:" + System.lineSeparator() + "  "
                + "[C][O] CS1010    Programming Methodology                                  A-   2 MC"
                + System.lineSeparator(), outContent.toString());
        System.setOut(originalOut);
    }

    @Test
    void executeUpdateCommand_nonexistentModule_exceptionThrown() throws InvalidCommandException,
            InvalidModuleTypeException, InvalidListTypeException, InputNotNumberException,
            IncorrectParameterCountException, InvalidModularCreditException, IllegalParametersException,
            InvalidModuleGradeException, InvalidModuleCodeException {
        String line = "update CS2040 -g A- -mc 2";
        Command updateCommand = parser.parseCommand(line);
        Exception exception = assertThrows(ModuleNotFoundException.class,
            () -> updateCommand.execute(moduleList, ui, storage));
        assertEquals(ModuleNotFoundException.MODULE_NOT_FOUND_ERROR_MESSAGE, exception.getMessage());
    }

    @Test
    void executeUpdateCommand_invalidGrade_exceptionThrown() throws InvalidCommandException, InvalidModuleTypeException,
            InvalidListTypeException, InputNotNumberException, IncorrectParameterCountException,
            InvalidModularCreditException, IllegalParametersException, InvalidModuleGradeException,
            InvalidModuleCodeException {
        String line = "update CS1010 -g O- -mc 2";
        Command updateCommand = parser.parseCommand(line);
        Exception exception = assertThrows(InvalidModuleGradeException.class,
            () -> updateCommand.execute(moduleList, ui, storage));
        assertEquals(InvalidModuleGradeException.INVALID_MODULE_GRADE_ERROR_MESSAGE, exception.getMessage());
    }

    @Test
    void executeUpdateCommand_incorrectMC_exceptionThrown() throws InvalidCommandException, InvalidModuleTypeException,
            InvalidListTypeException, InputNotNumberException, IncorrectParameterCountException,
            InvalidModularCreditException, IllegalParametersException, InvalidModuleGradeException,
            InvalidModuleCodeException {
        String line = "update CS1010 -n Introduction to Computer Organisation -mc -4";
        Command updateCommand = parser.parseCommand(line);
        Exception exception = assertThrows(InvalidModularCreditException.class,
            () -> updateCommand.execute(moduleList, ui, storage));
        assertEquals(InvalidModularCreditException.INVALID_MODULAR_CREDIT_ERROR_MESSAGE, exception.getMessage());
    }

    /*
    @Test
    void executeUpdateCommand_invalidFlag_ExceptionThrown() throws InvalidModuleTypeException,
            InvalidListTypeException, InputNotNumberException, IncorrectParameterCountException,
            InvalidModularCreditException, IllegalParametersException, InvalidModuleGradeException,
            InvalidModuleCodeException, InvalidCommandException {
        String line = "update CS1010 -n Introduction to Computer-Organisation -mc 4 -invalidTag testing";
        Command updateCommand = parser.parseCommand(line);
        Exception exception = assertThrows(InvalidCommandException.class,
            () -> updateCommand.execute(moduleList, ui, storage));
        assertEquals(String.format(InvalidCommandException.INVALID_COMMAND_ERROR_MESSAGE, "Unknown flags" + 
                "detected. The update command only accepts -[n|mc|g|p] as flags."), exception.getMessage());
    }*/

    @AfterEach
    void tearDownList() throws InvalidCommandException, InvalidModuleTypeException, InputNotNumberException,
            IncorrectParameterCountException, ExistingModuleException, InvalidModularCreditException,
            ModuleNotCompleteException, SaveModuleFailException, InvalidModuleGradeException,
            UnableToDeletePrereqModuleException, PrerequisiteNotFoundException, ModuleNotFoundException,
            InvalidListTypeException, PrerequisiteNotMetException, AddSelfToPrereqException,
            MarkCompletedModuleException, IllegalParametersException, InvalidModuleCodeException {
        String module = "Delete cs1010";
        Command deleteModule = parser.parseCommand(module);
        deleteModule.execute(moduleList, ui, storage);
    }
}
