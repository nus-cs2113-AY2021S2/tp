package seedu.duke.command;

import org.junit.jupiter.api.Test;
import seedu.duke.parser.ParserHandler;
import seedu.duke.record.Loan;
import seedu.duke.record.RecordList;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.duke.common.Validators.validateDate;

public class CreditScoreCommandTest {

    @Test
    public void executeCredScoreCommand_returnCmd_success() {
        String testName = "executeCredScoreCommand_returnCmd_success";
        String expectedOutput = "====================================================================="
                + System.lineSeparator()
                + "Credit score for andy is: 50" + System.lineSeparator()
                + "=====================================================================" + System.lineSeparator();
        String credScoreCmdInput = "creditscore andy";
        runCredScoreCmdTest(expectedOutput, credScoreCmdInput, testName);
    }

    private void runCredScoreCmdTest(String expectedOutput, String credScoreCmdInput, String testName) {
        Ui ui = new Ui();
        Storage storage = new Storage();
        RecordList loans = getLoanList();
        CreditScoreReturnedLoansMap creditScoreReturnedLoansMap = new CreditScoreReturnedLoansMap(new HashMap<>());
        ParserHandler parserHandler = new ParserHandler();
        CommandHandler commandHandler = new CommandHandler();

        Command command = commandHandler.parseCommand(parserHandler.getParseInput(credScoreCmdInput), loans);
        assertTrue(command instanceof CreditScoreCommand, String.format("Failed test '%s' command object "
                + "returned by parseCommand() is not an instance of CreditScoreCommand", testName));

        PrintStream originalOut = System.out;
        ByteArrayOutputStream tempBos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(tempBos));
        command.execute(loans, ui, storage, creditScoreReturnedLoansMap);
        System.setOut(originalOut);
        System.out.println(expectedOutput);
        assertTrue(tempBos.toString().equals(expectedOutput), String.format("Failed test "
                + "'%s', wrong output.", testName));
    }

    private RecordList getLoanList() {
        RecordList loans = new RecordList();
        loans.addRecord(new Loan(new BigDecimal("500.00"), validateDate("2021/01/15"),
                "Loan to Andy", "andy"));
        return loans;
    }
}
