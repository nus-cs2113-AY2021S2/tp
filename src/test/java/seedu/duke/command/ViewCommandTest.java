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

class ViewCommandTest {
    private ParserHandler parserHandler;

    @Test
    public void executeViewExpense_viewExpenseCmd_success() {
        String expectedOutput = "====================================================================="
                + System.lineSeparator()
                + "The total amount for expense is $12.88" + System.lineSeparator()
                + "=====================================================================" + System.lineSeparator();
        runViewCmdTest("executeViewExpense_viewExpenseCmd_success", "expense", "view -e", expectedOutput);
    }

    @Test
    public void executeViewLoan_viewLoanCmd_success() {
        String expectedOutput = "====================================================================="
                + System.lineSeparator()
                + "The total amount for loan is $14.35" + System.lineSeparator()
                + "=====================================================================" + System.lineSeparator();
        runViewCmdTest("executeViewLoan_viewLoanCmd_success", "loan", "view -l", expectedOutput);
    }

    @Test
    public void executeViewSaving_viewSavingCmd_success() {
        String expectedOutput = "====================================================================="
                + System.lineSeparator()
                + "The total amount for saving is $9,876,543,211.54" + System.lineSeparator()
                + "=====================================================================" + System.lineSeparator();
        runViewCmdTest("executeViewSaving_viewSavingCmd_success", "saving", "view -s", expectedOutput);
    }

    @Test
    public void executeViewSaving_viewAllCmd_success() {
        String expectedOutput = "====================================================================="
                + System.lineSeparator()
                + "The total amount for expense is $2.00" + System.lineSeparator()
                + "The total amount for loan is $10.60" + System.lineSeparator()
                + "The total amount for saving is $9,876,543,210.54" + System.lineSeparator()
                + "=====================================================================" + System.lineSeparator();
        runViewCmdTest("executeViewSaving_viewAllCmd_success", "all", "view -a", expectedOutput);
    }

    private void runViewCmdTest(String viewCmdTestName, String viewCmdTypeToTest,
                                String viewCmdStr, String expectedOutput) {
        Ui ui = new Ui();
        Storage storage = new Storage();
        ParserHandler parserHandler = new ParserHandler();
        CreditScoreReturnedLoansMap creditScoreReturnedLoansMap =
                new CreditScoreReturnedLoansMap(new HashMap<>());
        RecordList records = getPopulatedRecordList(viewCmdTypeToTest);
        CommandHandler commandHandler = new CommandHandler();

        Command command = commandHandler.parseCommand(parserHandler.getParseInput(viewCmdStr), records);

        assertTrue(command instanceof ViewCommand, String.format("Failed test '%s', "
                + "command object returned by parseCommand() is not an instance of ViewCommand.", viewCmdTestName));

        PrintStream originalOut = System.out;
        ByteArrayOutputStream viewCmdBos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(viewCmdBos));
        command.execute(records, ui, storage, creditScoreReturnedLoansMap);
        System.setOut(originalOut);
        assertTrue(viewCmdBos.toString().equals(expectedOutput), String.format("Failed test '%s', wrong output.",
                viewCmdTestName));
    }

    private RecordList getPopulatedRecordList(String viewCmdTypeToTest) {
        RecordList records = new RecordList();

        if (viewCmdTypeToTest.equals("expense")) {
            records.addRecord(new Expense(new BigDecimal("2"), validateDate("2020/01/01"), "electric bills"));
            records.addRecord(new Expense(new BigDecimal("10.88"), validateDate("2020/01/02"), "phone bills"));
        }

        if (viewCmdTypeToTest.equals("loan")) {
            records.addRecord(new Loan(new BigDecimal("10.60"), validateDate("2020/01/01"), "loan to bob", "bob"));
            records.addRecord(new Loan(new BigDecimal("3.75"), validateDate("2020/01/02"), "loan to alice", "alice"));
        }

        if (viewCmdTypeToTest.equals("saving")) {
            records.addRecord(new Saving(new BigDecimal("9876543210.54"), validateDate("2020/01/01"), "red packet"));
            records.addRecord(new Saving(new BigDecimal("1.00"), validateDate("2020/01/02"), "pocket money"));
        }
        if (viewCmdTypeToTest.equals("all")) {
            records.addRecord(new Expense(new BigDecimal("2"), validateDate("2020/01/01"), "electric bills"));
            records.addRecord(new Loan(new BigDecimal("10.60"), validateDate("2020/01/01"), "loan to bob", "bob"));
            records.addRecord(new Saving(new BigDecimal("9876543210.54"), validateDate("2020/01/01"), "red packet"));
        }
        return records;
    }
}
