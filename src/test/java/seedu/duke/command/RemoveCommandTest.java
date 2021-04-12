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
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.duke.common.Validators.validateDate;

class RemoveCommandTest {

    @Test
    void executeRemoveExpense_removeExpenseCmd_success() {
        RecordList records = new RecordList();
        CommandHandler commandHandler = new CommandHandler();
        records.addRecord(new Expense(new BigDecimal("220.50"), validateDate("2020/01/01"), "electric bills"));
        records.addRecord(new Expense(new BigDecimal("420.50"), validateDate("2020/01/02"), "phone bills"));
        records.addRecord(new Loan(new BigDecimal("100"), validateDate("2020/01/01"), "loan to bob", "bob"));
        records.addRecord(new Saving(new BigDecimal("20"), validateDate("2020/01/01"), "red packet"));
        String removeExpenseCmd = "remove -i 1";
        ParserHandler parserHandler = new ParserHandler();
        Command command = commandHandler.parseCommand(parserHandler.getParseInput(removeExpenseCmd), records);
        assertTrue(command instanceof RemoveCommand, "Failed test 'executeRemoveExpense_removeExpenseCmd_success', "
                + "command object returned by parseCommand() is not an instance of RemoveCommand");
        Ui ui = new Ui();
        Storage storage = new Storage();
        CreditScoreReturnedLoansMap creditScoreReturnedLoansMap =
                new CreditScoreReturnedLoansMap(new HashMap<>());
        PrintStream originalOut = System.out;
        ByteArrayOutputStream removeCmdBos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(removeCmdBos));
        String expectedOutput = "====================================================================="
                + System.lineSeparator() + System.lineSeparator()
                + "This record will be removed:"
                + System.lineSeparator() + System.lineSeparator()
                + "[ID: 1] [E] [2020-01-01] [$220.50] electric bills "
                + System.lineSeparator() + System.lineSeparator()
                + "====================================================================="
                + System.lineSeparator();
        command.execute(records, ui, storage, creditScoreReturnedLoansMap);
        System.setOut(originalOut);
        assertTrue(removeCmdBos.toString().equals(expectedOutput), "Failed test "
                + "'executeRemoveExpense_removeExpenseCmd_success', wrong output.");
    }

    @Test
    void executeRemoveLoan_removeLoanCmd_success() {
        RecordList records = new RecordList();
        CommandHandler commandHandler = new CommandHandler();
        records.addRecord(new Expense(new BigDecimal("220.50"), validateDate("2020/01/01"), "electric bills"));
        records.addRecord(new Expense(new BigDecimal("420.50"), validateDate("2020/01/02"), "phone bills"));
        records.addRecord(new Loan(new BigDecimal("100"), validateDate("2020/01/01"), "loan to bob", "bob"));
        records.addRecord(new Saving(new BigDecimal("20"), validateDate("2020/01/01"), "red packet"));

        String removeLoanCmd = "remove -i 3";
        ParserHandler parserHandler = new ParserHandler();
        Command command = commandHandler.parseCommand(parserHandler.getParseInput(removeLoanCmd), records);

        assertTrue(command instanceof RemoveCommand, "Failed test 'executeRemoveLoan_removeLoanCmd_success', "
                + "command object returned by parseCommand() is not an instance of RemoveCommand");

        Ui ui = new Ui();
        Storage storage = new Storage();
        CreditScoreReturnedLoansMap creditScoreReturnedLoansMap =
                new CreditScoreReturnedLoansMap(new HashMap<>());
        PrintStream originalOut = System.out;
        ByteArrayOutputStream removeCmdBos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(removeCmdBos));
        String expectedOutput = "====================================================================="
                + System.lineSeparator() + System.lineSeparator()
                + "This record will be removed:"
                + System.lineSeparator() + System.lineSeparator()
                + "[ID: 3] [L] [2020-01-01] [$100.00] loan to bob [ ]"
                + System.lineSeparator() + System.lineSeparator()
                + "====================================================================="
                + System.lineSeparator();
        command.execute(records, ui, storage, creditScoreReturnedLoansMap);
        System.setOut(originalOut);
        assertTrue(removeCmdBos.toString().equals(expectedOutput), "Failed test "
                + "'executeRemoveLoan_removeLoanCmd_success', wrong output.");
    }

    @Test
    void executeRemoveSaving_removeSavingCmd_success() {
        RecordList records = new RecordList();
        CommandHandler commandHandler = new CommandHandler();
        records.addRecord(new Expense(new BigDecimal("220.50"), validateDate("2020/01/01"), "electric bills"));
        records.addRecord(new Expense(new BigDecimal("420.50"), validateDate("2020/01/02"), "phone bills"));
        records.addRecord(new Loan(new BigDecimal("100"), validateDate("2020/01/01"), "loan to bob", "bob"));
        records.addRecord(new Saving(new BigDecimal("20"), validateDate("2020/01/01"), "red packet"));

        String removeSavingCmd = "remove -i 4";
        ParserHandler parserHandler = new ParserHandler();
        Command command = commandHandler.parseCommand(parserHandler.getParseInput(removeSavingCmd), records);
        assertTrue(command instanceof RemoveCommand, "Failed test 'executeRemoveSaving_removeSavingCmd_success', "
                + "command object returned by parseCommand() is not an instance of RemoveCommand");

        Ui ui = new Ui();
        Storage storage = new Storage();
        CreditScoreReturnedLoansMap creditScoreReturnedLoansMap =
                new CreditScoreReturnedLoansMap(new HashMap<>());
        PrintStream originalOut = System.out;
        ByteArrayOutputStream removeCmdBos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(removeCmdBos));
        String expectedOutput = "====================================================================="
                + System.lineSeparator() + System.lineSeparator()
                + "This record will be removed:"
                + System.lineSeparator() + System.lineSeparator()
                + "[ID: 4] [S] [2020-01-01] [$20.00] red packet "
                + System.lineSeparator() + System.lineSeparator()
                + "====================================================================="
                + System.lineSeparator();
        command.execute(records, ui, storage, creditScoreReturnedLoansMap);
        System.setOut(originalOut);
        assertTrue(removeCmdBos.toString().equals(expectedOutput), "Failed test "
                + "'executeRemoveSaving_removeSavingCmd_success', wrong output.");
    }
}
