package seedu.staff;

import org.junit.jupiter.api.Test;
import seedu.exceptions.*;
import seedu.exceptions.staff.WrongListInputException;
import seedu.exceptions.staff.WrongStaffIdException;
import seedu.logic.command.Command;
import seedu.logic.command.StaffAggregation;
import seedu.logic.command.staff.*;
import seedu.logic.parser.StaffParser;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StaffParserTest {
        private StaffParser parser;
        private StaffAggregation staffAggregation;

    public StaffParserTest() {
        this.parser = new StaffParser();
        this.staffAggregation = new StaffAggregation();
    }

    @Test
    public void ValidAddCommand() throws ExcessInputException, InvalidIntegerException,
            WrongStaffIdException, WrongListInputException,
            InsufficientInputException, DuplicateIDException, NoInputException {
        Command c;
        c = this.parser.commandHandler("add/D12345/Owen/20/Surgeon", staffAggregation);
        assertTrue(c instanceof StaffAdd);
    }
    @Test
    public void ValidHelpCommand() throws ExcessInputException, InvalidIntegerException,
            WrongStaffIdException, WrongListInputException,
            InsufficientInputException, DuplicateIDException, NoInputException {
        Command c;
        c = this.parser.commandHandler("help", staffAggregation);
        assertTrue(c instanceof StaffHelp);
    }
    @Test
    public void ValidListAllCommand() throws ExcessInputException, InvalidIntegerException,
            WrongStaffIdException, WrongListInputException,
            InsufficientInputException, DuplicateIDException, NoInputException {
        Command c;
        c = this.parser.commandHandler("list", staffAggregation);
        assertTrue(c instanceof StaffList);
    }

    @Test
    public void ValidListNurseCommand() throws ExcessInputException, InvalidIntegerException,
            WrongStaffIdException, WrongListInputException,
            InsufficientInputException, DuplicateIDException, NoInputException {
        Command c;
        c = this.parser.commandHandler("list/nurses", staffAggregation);
        assertTrue(c instanceof StaffList);
    }
    @Test
    public void ValidListDoctorCommand() throws ExcessInputException, InvalidIntegerException,
            WrongStaffIdException, WrongListInputException,
            InsufficientInputException, DuplicateIDException, NoInputException {
        Command c;
        c = this.parser.commandHandler("list/doctors", staffAggregation);
        assertTrue(c instanceof StaffList);
    }

    @Test
    public void ValidReturnCommand() throws ExcessInputException, InvalidIntegerException,
            WrongStaffIdException, WrongListInputException,
            InsufficientInputException, DuplicateIDException, NoInputException {
        Command c;
        c = this.parser.commandHandler("return", staffAggregation);
        assertTrue(c instanceof StaffReturn);
    }

    @Test
    public void ValidDeleteCommand() throws ExcessInputException, InvalidIntegerException,
            WrongStaffIdException, WrongListInputException,
            InsufficientInputException, DuplicateIDException, NoInputException {
        Command c;
        c = this.parser.commandHandler("add/D12345/Owen/20/Surgeon", staffAggregation);
        c = this.parser.commandHandler("delete/D12345", staffAggregation);
        assertTrue(c instanceof StaffDelete);
    }

    @Test
    public void ValidFindCommand() throws ExcessInputException, InvalidIntegerException,
            WrongStaffIdException, WrongListInputException,
            InsufficientInputException, DuplicateIDException, NoInputException {
        Command c;
        c = this.parser.commandHandler("find/D12345", staffAggregation);
        assertTrue(c instanceof StaffFind);
    }
}
