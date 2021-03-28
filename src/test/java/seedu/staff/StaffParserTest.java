package seedu.staff;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import seedu.duke.exceptions.NoInputException;
import seedu.duke.exceptions.staffexceptions.AbortException;
import seedu.duke.exceptions.staffexceptions.WrongListInputException;
import seedu.duke.exceptions.staffexceptions.WrongStaffIdException;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.staff.Parser.commandHandler;


public class StaffParserTest {
    @Test
    void testReturnCommandHandlerReturnValue() throws NoInputException, WrongListInputException,
            WrongStaffIdException, IOException, AbortException {
        String line = "return";
        assertEquals(commandHandler(line), 0);
    }

    @Test
    void testValidCommandHandlerReturnValue(){
        Assertions.assertAll(
                () -> assertEquals(1, commandHandler("list")),
                () -> assertEquals(1, commandHandler("add N12345")),
                () -> assertEquals(1, commandHandler("delete N12345")),
                () -> assertEquals(1, commandHandler("find N12345"))
        );
    }

}
