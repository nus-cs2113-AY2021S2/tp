package seedu.duke.command;

import org.junit.jupiter.api.Test;
import seedu.duke.parser.ParserHandler;
import seedu.duke.record.Expense;
import seedu.duke.record.Loan;
import seedu.duke.record.RecordList;
import seedu.duke.record.Saving;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.duke.common.Validators.validateDate;

class RemoveCommandTest {

    @Test
    void executeRemoveExpense_removeExpenseCmd_success() {
        RecordList records = new RecordList();
        records.addRecord(new Expense(new BigDecimal("220.50"), validateDate("2020/01/01"), "electric bills"));
        records.addRecord(new Expense(new BigDecimal("420.50"), validateDate("2020/01/02"), "phone bills"));
        records.addRecord(new Loan(new BigDecimal("100"), validateDate("2020/01/01"), "loan to bob"));
        records.addRecord(new Saving(new BigDecimal("20"), validateDate("2020/01/01"), "red packet"));

        String removeExpenseCmd = "remove -i 1";
        Command command = CommandHandler.parseCommand(ParserHandler.getParseInput(removeExpenseCmd), records);
        assertTrue(command instanceof RemoveCommand, "Failed test 'executeRemoveExpense_removeExpenseCmd_success', "
                + "command object returned by parseCommand() is not an instance of RemoveCommand");

        Ui ui = new Ui();
        Storage storage = new Storage();
        ByteArrayOutputStream removeCmdBos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(removeCmdBos));
        PrintStream originalOut = System.out;
        String expectedOutput = "=========================================================" + System.lineSeparator()
                + "This record will be removed: [E][2020-01-01] electric bills " + System.lineSeparator()
                + "=========================================================" + System.lineSeparator();
        command.execute(records, ui, storage);
        assertTrue(removeCmdBos.toString().equals(expectedOutput), "Failed test "
                + "'executeRemoveExpense_removeExpenseCmd_success', wrong output.");
        System.setOut(originalOut);
    }

    @Test
    void executeRemoveLoan_removeLoanCmd_success() {
        RecordList records = new RecordList();
        records.addRecord(new Expense(new BigDecimal("220.50"), validateDate("2020/01/01"), "electric bills"));
        records.addRecord(new Expense(new BigDecimal("420.50"), validateDate("2020/01/02"), "phone bills"));
        records.addRecord(new Loan(new BigDecimal("100"), validateDate("2020/01/01"), "loan to bob"));
        records.addRecord(new Saving(new BigDecimal("20"), validateDate("2020/01/01"), "red packet"));

        String removeLoanCmd = "remove -i 3";
        Command command = CommandHandler.parseCommand(ParserHandler.getParseInput(removeLoanCmd), records);
        assertTrue(command instanceof RemoveCommand, "Failed test 'executeRemoveLoan_removeLoanCmd_success', "
                + "command object returned by parseCommand() is not an instance of RemoveCommand");

        Ui ui = new Ui();
        Storage storage = new Storage();
        ByteArrayOutputStream removeCmdBos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(removeCmdBos));
        PrintStream originalOut = System.out;
        String expectedOutput = "=========================================================" + System.lineSeparator()
                + "This record will be removed: [L][2020-01-01] loan to bob [ ]" + System.lineSeparator()
                + "=========================================================" + System.lineSeparator();
        command.execute(records, ui, storage);
        assertTrue(removeCmdBos.toString().equals(expectedOutput), "Failed test "
                + "'executeRemoveLoan_removeLoanCmd_success', wrong output.");
        System.setOut(originalOut);
    }

    @Test
    void executeRemoveSaving_removeSavingCmd_success() {
        RecordList records = new RecordList();
        records.addRecord(new Expense(new BigDecimal("220.50"), validateDate("2020/01/01"), "electric bills"));
        records.addRecord(new Expense(new BigDecimal("420.50"), validateDate("2020/01/02"), "phone bills"));
        records.addRecord(new Loan(new BigDecimal("100"), validateDate("2020/01/01"), "loan to bob"));
        records.addRecord(new Saving(new BigDecimal("20"), validateDate("2020/01/01"), "red packet"));

        String removeSavingCmd = "remove -i 4";
        Command command = CommandHandler.parseCommand(ParserHandler.getParseInput(removeSavingCmd), records);
        assertTrue(command instanceof RemoveCommand, "Failed test 'executeRemoveSaving_removeSavingCmd_success', "
                + "command object returned by parseCommand() is not an instance of RemoveCommand");

        Ui ui = new Ui();
        Storage storage = new Storage();
        ByteArrayOutputStream removeCmdBos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(removeCmdBos));
        PrintStream originalOut = System.out;
        String expectedOutput = "=========================================================" + System.lineSeparator()
                + "This record will be removed: [S][2020-01-01] red packet " + System.lineSeparator()
                + "=========================================================" + System.lineSeparator();
        command.execute(records, ui, storage);
        assertTrue(removeCmdBos.toString().equals(expectedOutput), "Failed test "
                + "'executeRemoveSaving_removeSavingCmd_success', wrong output.");
        System.setOut(originalOut);
    }
}
