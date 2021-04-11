package seedu.staff;

import org.junit.jupiter.api.Test;
import seedu.exceptions.HealthVaultException;
import seedu.logic.command.Command;
import seedu.logic.command.staff.StaffAddCommand;
import seedu.logic.command.staff.StaffHelpCommand;
import seedu.logic.command.staff.StaffListCommand;
import seedu.logic.command.staff.StaffReturnCommand;
import seedu.logic.command.staff.StaffDeleteCommand;
import seedu.logic.command.staff.StaffFindCommand;

import seedu.logic.parser.StaffParser;
import seedu.model.staff.StaffList;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StaffParserTest {
    private StaffParser parser;
    private StaffList staffList;


    public StaffParserTest() {
        this.parser = new StaffParser();
        this.staffList = new StaffList();
    }

    @Test
    public void commandHandler_lowerBoundaryAgeForAddCommand_staffAddCommandReturned()
            throws HealthVaultException {
        Command c;
        c = this.parser.commandHandler("add/D12345/Owen/18/Surgeon", staffList);
        assertTrue(c instanceof StaffAddCommand);
    }

    @Test
    public void commandHandler_upperBoundaryAgeForAddCommand_staffAddCommandReturned()
            throws HealthVaultException {
        Command c;
        c = this.parser.commandHandler("add/D12345/Owen/150/Surgeon", staffList);
        assertTrue(c instanceof StaffAddCommand);
    }

    @Test
    public void commandHandler_excessLengthStaffID_wrongStaffIdExceptionReturned() {
        HealthVaultException exception = assertThrows(HealthVaultException.class, () ->
                this.parser.commandHandler("add/D123456/Owen/20/Surgeon", staffList));
        assertEquals(exception.getMessage(), "Error in Staff ID input\n"
                + "Please input with the following format [D/N][5 digit ID number]");
    }

    @Test
    public void commandHandler_insufficientLengthStaffID_wrongStaffIdExceptionReturned() {
        HealthVaultException exception = assertThrows(HealthVaultException.class, () ->
                this.parser.commandHandler("add/D1234/Owen/20/Surgeon", staffList));
        assertEquals(exception.getMessage(), "Error in Staff ID input\n"
                + "Please input with the following format [D/N][5 digit ID number]");
    }

    @Test
    public void commandHandler_whitespaceStaffID_wrongStaffIdExceptionReturned() {
        HealthVaultException exception = assertThrows(HealthVaultException.class, () ->
                this.parser.commandHandler("add/ /Owen/20/Surgeon", staffList));
        assertEquals(exception.getMessage(), "Error in Staff ID input\n"
                + "Please input with the following format [D/N][5 digit ID number]");
    }

    @Test
    public void commandHandler_noStaffID_wrongStaffIdExceptionReturned() {
        HealthVaultException exception = assertThrows(HealthVaultException.class, () ->
                this.parser.commandHandler("add//Owen/20/Surgeon", staffList));
        assertEquals(exception.getMessage(), "Error in Staff ID input\n"
                + "Please input with the following format [D/N][5 digit ID number]");
    }

    @Test
    public void commandHandler_illegalCharactersInName_illegalCharacterExceptionReturned() {
        HealthVaultException exception = assertThrows(HealthVaultException.class, () ->
                this.parser.commandHandler("add/D12345/Owen./20/Surgeon", staffList));
        assertEquals(exception.getMessage(), "You have an illegal character in your: name");
    }

    @Test
    public void commandHandler_illegalCharactersInSpecialisation_illegalCharacterExceptionReturned() {
        HealthVaultException exception = assertThrows(HealthVaultException.class, () ->
                this.parser.commandHandler("add/D12345/Owen/20/Surgeon.", staffList));
        assertEquals(exception.getMessage(), "You have an illegal character in your: specialisation");
    }

    @Test
    public void commandHandler_excessInputFields_excessInputExceptionReturned() {
        HealthVaultException exception = assertThrows(HealthVaultException.class, () ->
                this.parser.commandHandler("add/D12345/Owen/20/Sur/geon", staffList));
        assertEquals(exception.getMessage(), "OOPS! There are too many inputs for this command");
    }

    @Test
    public void commandHandler_ageLessThan18_invalidStaffAgeExceptionReturned() {
        HealthVaultException exception = assertThrows(HealthVaultException.class, () ->
                this.parser.commandHandler("add/D12345/Owen/17/Surgeon", staffList));
        assertEquals(exception.getMessage(), "Your age input is invalid! \n"
                + "Please ensure that the age is an integer between 18 and 150 inclusive!");
    }


    @Test
    public void commandHandler_validHelpCommand_staffHelpCommandReturned() throws HealthVaultException {
        Command c;
        c = this.parser.commandHandler("help", staffList);
        assertTrue(c instanceof StaffHelpCommand);
    }



    @Test
    public void commandHandler_validListCommandToListAll_staffListCommandReturned() throws HealthVaultException {
        Command c;
        c = this.parser.commandHandler("list", staffList);
        assertTrue(c instanceof StaffListCommand);
    }

    @Test
    public void commandHandler_blankInputToListCommand_wrongListInputExceptionReturned() {
        HealthVaultException exception = assertThrows(HealthVaultException.class, () ->
                this.parser.commandHandler("list/ /", staffList));
        assertEquals(exception.getMessage(), "Invalid List command parameter\n"
                + "Please input with the either of the following format:\n\tlist\n\tlist/nurses\n\tlist/doctors");
    }

    @Test
    public void commandHandler_invalidInputToListCommand_wrongListInputExceptionReturned() {
        HealthVaultException exception = assertThrows(HealthVaultException.class, () ->
                this.parser.commandHandler("list/invalid/", staffList));
        assertEquals(exception.getMessage(), "Invalid List command parameter\n"
                + "Please input with the either of the following format:\n\tlist\n\tlist/nurses\n\tlist/doctors");
    }

    @Test
    public void commandHandler_excessInputToListCommand_excessInputExceptionReturned() {
        HealthVaultException exception = assertThrows(HealthVaultException.class, () ->
                this.parser.commandHandler("list/doctors/invalid/", staffList));
        assertEquals(exception.getMessage(), "OOPS! There are too many inputs for this command");
    }



    @Test
    public void validListNurseCommand() throws HealthVaultException {
        Command c;
        c = this.parser.commandHandler("list/nurses", staffList);
        assertTrue(c instanceof StaffListCommand);
    }

    @Test
    public void validListDoctorCommand() throws HealthVaultException {
        Command c;
        c = this.parser.commandHandler("list/doctors", staffList);
        assertTrue(c instanceof StaffListCommand);
    }



    @Test
    public void validReturnCommand() throws HealthVaultException {
        Command c;
        c = this.parser.commandHandler("return", staffList);
        assertTrue(c instanceof StaffReturnCommand);
    }




    @Test
    public void validDeleteCommand() throws HealthVaultException {
        Command c;
        c = this.parser.commandHandler("delete/D12345", staffList);
        assertTrue(c instanceof StaffDeleteCommand);
    }

    @Test
    public void invalidDeleteCommand1() {
        HealthVaultException exception = assertThrows(HealthVaultException.class, () ->
                this.parser.commandHandler("delete/D1234/", staffList));
        assertEquals(exception.getMessage(), "Error in Staff ID input\n"
                + "Please input with the following format [D/N][5 digit ID number]");
    }





    @Test
    public void validFindCommand() throws HealthVaultException {
        Command c;
        c = this.parser.commandHandler("find/D12345", staffList);
        assertTrue(c instanceof StaffFindCommand);
    }

    @Test
    public void validFindCommand2() throws HealthVaultException {
        Command c;
        c = this.parser.commandHandler("find/19", staffList);
        assertTrue(c instanceof StaffFindCommand);
    }

    @Test
    public void validFindCommand3() throws HealthVaultException {
        Command c;
        c = this.parser.commandHandler("find/Owen", staffList);
        assertTrue(c instanceof StaffFindCommand);
    }

}
