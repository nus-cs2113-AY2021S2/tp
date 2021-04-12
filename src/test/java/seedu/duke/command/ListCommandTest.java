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

class ListCommandTest {

    @Test
    public void executeListExpense_listExpenseCmd_success() {
        String expectedOutput = "====================================================================="
                + System.lineSeparator()
                + "Here is your Expense list:" + System.lineSeparator()
                + "[ID: 1] [E] [2020-01-01] [$220.50] electric bills " + System.lineSeparator()
                + "[ID: 2] [E] [2020-01-02] [$420.50] phone bills " + System.lineSeparator()
                + "=====================================================================" + System.lineSeparator();
        runListCmdTest("executeListExpense_listExpenseCmd_success", "expense", "list -e", expectedOutput);
    }

    @Test
    public void executeListLoan_listLoanCmd_success() {
        String expectedOutput = "====================================================================="
                + System.lineSeparator()
                + "Here is your Loan list:" + System.lineSeparator()
                + "[ID: 2] [L] [2020-01-01] [$100.00] loan to bob [ ]" + System.lineSeparator()
                + "[ID: 3] [L] [2020-01-02] [$300.00] loan to alice [ ]" + System.lineSeparator()
                + "=====================================================================" + System.lineSeparator();
        runListCmdTest("executeListLoan_listLoanCmd_success", "loan", "list -l", expectedOutput);
    }

    @Test
    public void executeListSaving_listSavingCmd_success() {
        String expectedOutput = "====================================================================="
                + System.lineSeparator()
                + "Here is your Saving list:" + System.lineSeparator()
                + "[ID: 3] [S] [2020-01-01] [$20.00] red packet " + System.lineSeparator()
                + "[ID: 4] [S] [2020-01-02] [$40.00] pocket money " + System.lineSeparator()
                + "=====================================================================" + System.lineSeparator();
        runListCmdTest("executeListSaving_listSavingCmd_success", "saving", "list -s", expectedOutput);
    }

    private void runListCmdTest(String listCmdTestName, String listCmdTypeToTest,
                                String listCmdStr, String expectedOutput) {
        Ui ui = new Ui();
        Storage storage = new Storage();
        ParserHandler parserHandler = new ParserHandler();
        RecordList records = getPopulatedRecordList(listCmdTypeToTest);
        CreditScoreReturnedLoansMap creditScoreReturnedLoansMap =
                new CreditScoreReturnedLoansMap(new HashMap<>());
        CommandHandler commandHandler = new CommandHandler();

        Command command = commandHandler.parseCommand(parserHandler.getParseInput(listCmdStr), records);
        assertTrue(command instanceof ListCommand, String.format("Failed test '%s', "
                + "command object returned by parseCommand() is not an instance of ListCommand.", listCmdTestName));

        PrintStream originalOut = System.out;
        ByteArrayOutputStream listCmdBos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(listCmdBos));
        command.execute(records, ui, storage, creditScoreReturnedLoansMap);
        System.setOut(originalOut);
        assertTrue(listCmdBos.toString().equals(expectedOutput), String.format("Failed test '%s', wrong output.",
                listCmdTestName));
    }

    private RecordList getPopulatedRecordList(String listCmdTypeToTest) {
        RecordList records = new RecordList();
        records.addRecord(new Expense(new BigDecimal("220.50"), validateDate("2020/01/01"), "electric bills"));
        if (listCmdTypeToTest.equals("expense")) {
            records.addRecord(new Expense(new BigDecimal("420.50"), validateDate("2020/01/02"), "phone bills"));
        }

        records.addRecord(new Loan(new BigDecimal("100"), validateDate("2020/01/01"), "loan to bob", "bob"));
        if (listCmdTypeToTest.equals("loan")) {
            records.addRecord(new Loan(new BigDecimal("300"), validateDate("2020/01/02"), "loan to alice", "alice"));
        }

        records.addRecord(new Saving(new BigDecimal("20"), validateDate("2020/01/01"), "red packet"));
        if (listCmdTypeToTest.equals("saving")) {
            records.addRecord(new Saving(new BigDecimal("40"), validateDate("2020/01/02"), "pocket money"));
        }
        return records;
    }
}
