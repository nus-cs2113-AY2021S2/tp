package seedu.duke.command;

import org.junit.jupiter.api.Test;
import seedu.duke.parser.ParserHandler;
import seedu.duke.record.RecordList;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddCommandTest {
    @Test
    public void executeAddCommand_addExpenseCmd_success() {
        String testName = "executeAddExpense_addExpenseCmd_success";
        String expectedOutput = "====================================================================="
                + System.lineSeparator()
                + System.lineSeparator()
                + "Expense has been added..." + System.lineSeparator()
                + System.lineSeparator()
                + "[ID: 1] [E] [2021-04-07] [$5.00] Dinner " + System.lineSeparator()
                + System.lineSeparator()
                + "=====================================================================" + System.lineSeparator();
        String addExpInput = "add -e Dinner -a 5.00 -d 07/04/2021";
        runAddExpTest(expectedOutput, addExpInput, testName);
    }

    private void runAddExpTest(String expectedOutput, String addExpInput, String testName) {
        Ui ui = new Ui();
        Storage storage = new Storage();
        RecordList recordList = new RecordList();
        CreditScoreReturnedLoansMap creditScoreReturnedLoansMap = new CreditScoreReturnedLoansMap(new HashMap<>());
        ParserHandler parserHandler = new ParserHandler();
        CommandHandler commandHandler = new CommandHandler();

        Command command = commandHandler.parseCommand(parserHandler.getParseInput(addExpInput), recordList);
        assertTrue(command instanceof AddCommand, String.format("Failed test '%s' command object "
                + "returned by parseCommand() is not an instance of AddCommand", testName));

        PrintStream originalOut = System.out;
        ByteArrayOutputStream tempBos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(tempBos));
        command.execute(recordList, ui, storage, creditScoreReturnedLoansMap);
        System.setOut(originalOut);
        assertTrue(tempBos.toString().equals(expectedOutput), String.format("Failed test "
                + "'%s', wrong output.", testName));
    }
}
