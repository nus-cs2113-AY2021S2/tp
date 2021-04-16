package seedu.igraduate.logic.command.capcommand;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.igraduate.logic.command.CapCommand;
import seedu.igraduate.logic.command.Command;
import seedu.igraduate.model.list.ModuleList;
import seedu.igraduate.logic.parser.Parser;
import seedu.igraduate.storage.Storage;
import seedu.igraduate.ui.Ui;

import seedu.igraduate.exception.InvalidModuleGradeException;
import seedu.igraduate.exception.InvalidModuleCodeException;
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
import seedu.igraduate.exception.InvalidModularCreditException;
import seedu.igraduate.exception.MarkCompletedModuleException;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.nio.file.Paths;

public class CapCommandTest {

    private static final File FILEPATH = Paths.get("./commandteststorage/capCommandData.json").toFile();

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
        String firstModule = "add Programming Methodology -mc 4 -t core -c cs1010";
        String secondModule = "add Computer Org -mc 4 -t core -c cs2100";
        Command addFirst = parser.parseCommand(firstModule);
        addFirst.execute(moduleList, ui, storage);
        Command addSecond = parser.parseCommand(secondModule);
        addSecond.execute(moduleList, ui, storage);
        String setFirstToDone = "done cs1010 -g A+";
        String setSecondToDone = "done cs2100 -g A-";
        Command doneFirst = parser.parseCommand(setFirstToDone);
        Command doneSecond = parser.parseCommand(setSecondToDone);
        doneFirst.execute(moduleList, ui, storage);
        doneSecond.execute(moduleList, ui, storage);
    }

    /*----------------- Unit test -----------------------*/
    @Test
    void executeCapCommand_validParameters_success() throws InvalidModuleTypeException, InputNotNumberException,
            ExistingModuleException, AddSelfToPrereqException, ModuleNotCompleteException, SaveModuleFailException,
            InvalidModuleGradeException, UnableToDeletePrereqModuleException, PrerequisiteNotFoundException,
            ModuleNotFoundException, InvalidListTypeException, PrerequisiteNotMetException,
            InvalidModularCreditException, MarkCompletedModuleException, InvalidCommandException {

        Command capCommand = new CapCommand();
        System.setOut(new PrintStream(outContent));
        capCommand.execute(moduleList, ui, storage);
        assertEquals(String.format(Ui.CAP_MESSAGE, 4.75, "Honours (Highest Distinction)") + System.lineSeparator(),
                outContent.toString());
        System.setOut(originalOut);
    }

    @AfterEach
    void tearDownList() throws InvalidCommandException, InvalidModuleTypeException, InputNotNumberException,
            IncorrectParameterCountException, ExistingModuleException, InvalidModularCreditException,
            ModuleNotCompleteException, SaveModuleFailException, InvalidModuleGradeException,
            UnableToDeletePrereqModuleException, PrerequisiteNotFoundException, ModuleNotFoundException,
            InvalidListTypeException, PrerequisiteNotMetException, AddSelfToPrereqException,
            MarkCompletedModuleException, IllegalParametersException, InvalidModuleCodeException {
        String firstModule = "Delete cs1010";
        String secondModule = "Delete cs2100";
        Command deleteFirst = parser.parseCommand(firstModule);
        Command deleteSecond = parser.parseCommand(secondModule);
        deleteFirst.execute(moduleList, ui, storage);
        deleteSecond.execute(moduleList, ui, storage);
    }
}
