package seedu.allinonenus.capcalculatorclasses;

import org.junit.jupiter.api.Test;
import seedu.allinonenus.capcalculatorclasses.commandsforcapcalculator.ChangeSemesterViewCommand;
import seedu.allinonenus.capcalculatorclasses.exceptionsforcapcalculator.IncorrectCommandsException;
import seedu.allinonenus.capcalculatorclasses.parserforcapcalculator.ParserForCapCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParserForCapCalculatorTest {

    @Test
    void parserTest() throws IncorrectCommandsException {
        ParserForCapCalculator ps = new ParserForCapCalculator();
        String command = "view";
        assertTrue(ps.parse(command) instanceof  ChangeSemesterViewCommand);

    }
}
