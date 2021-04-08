package seedu.staff;

import org.junit.jupiter.api.Test;
import seedu.exceptions.HealthVaultException;
import seedu.logic.command.Command;
import seedu.logic.command.staff.*;
import seedu.logic.parser.StaffParser;
import seedu.model.staff.StaffList;

import static org.junit.jupiter.api.Assertions.*;

public class StaffParserTest {
    private StaffParser parser;
    private StaffList staffList;


    public StaffParserTest() {
        this.parser = new StaffParser();
        this.staffList = new StaffList();
    }

    @Test
    public void ValidAddCommand() throws HealthVaultException {
        Command c;
        c = this.parser.commandHandler("add/D12345/Owen/18/Surgeon", staffList);
        assertTrue(c instanceof StaffAdd);
    }
    @Test
    public void ValidAddCommand2() throws HealthVaultException {
        Command c;
        c = this.parser.commandHandler("add/D12345/Owen/150/Surgeon", staffList);
        assertTrue(c instanceof StaffAdd);
    }
    @Test
    public void invalidAddCommand1() {
        HealthVaultException exception = assertThrows(HealthVaultException.class, () ->
                this.parser.commandHandler("add/D123456/Owen/20/Surgeon", staffList));
        assertEquals(exception.getMessage(), "Error in Staff ID input\nPlease input with the following format [D/N][5 digit ID number]");
    }
    @Test
    public void invalidAddCommand2() {
        HealthVaultException exception = assertThrows(HealthVaultException.class, () ->
                this.parser.commandHandler("add/D1234/Owen/20/Surgeon", staffList));
        assertEquals(exception.getMessage(), "Error in Staff ID input\nPlease input with the following format [D/N][5 digit ID number]");
    }

    @Test
    public void invalidAddCommand3() {
        HealthVaultException exception = assertThrows(HealthVaultException.class, () ->
                this.parser.commandHandler("add/ /Owen/20/Surgeon", staffList));
        assertEquals(exception.getMessage(), "Error in Staff ID input\nPlease input with the following format [D/N][5 digit ID number]");
    }

    @Test
    public void invalidAddCommand4() {
        HealthVaultException exception = assertThrows(HealthVaultException.class, () ->
                this.parser.commandHandler("add//Owen/20/Surgeon", staffList));
        assertEquals(exception.getMessage(), "Error in Staff ID input\nPlease input with the following format [D/N][5 digit ID number]");
    }

    @Test
    public void invalidAddCommand5() {
        HealthVaultException exception = assertThrows(HealthVaultException.class, () ->
                this.parser.commandHandler("add/D12345/Owen./20/Surgeon", staffList));
        assertEquals(exception.getMessage(), "You have an illegal character in your: name");
    }
    @Test
    public void invalidAddCommand6() {
        HealthVaultException exception = assertThrows(HealthVaultException.class, () ->
                this.parser.commandHandler("add/D12345/Owen/20/Surgeon.", staffList));
        assertEquals(exception.getMessage(), "You have an illegal character in your: specialisation");
    }
    @Test
    public void invalidAddCommand7() {
        HealthVaultException exception = assertThrows(HealthVaultException.class, () ->
                this.parser.commandHandler("add/D12345/Owen/20/Sur/geon", staffList));
        assertEquals(exception.getMessage(), "OOPS! There are too many inputs for this command");
    }
    @Test
    public void invalidAddCommand8() {
        HealthVaultException exception = assertThrows(HealthVaultException.class, () ->
                this.parser.commandHandler("add/D12345/Owen/17/Surgeon", staffList));
        assertEquals(exception.getMessage(), "Your age input is invalid! \n" +
                "Please ensure that the age is an integer between 18 and 150 inclusive!");
    }
    @Test
    public void invalidAddCommand9() {
        HealthVaultException exception = assertThrows(HealthVaultException.class, () ->
                this.parser.commandHandler("add/D12345/Owen/151/Surgeon", staffList));
        assertEquals(exception.getMessage(), "Your age input is invalid! \n" +
                "Please ensure that the age is an integer between 18 and 150 inclusive!");
    }





    @Test
    public void ValidHelpCommand() throws HealthVaultException {
        Command c;
        c = this.parser.commandHandler("help", staffList);
        assertTrue(c instanceof StaffHelp);
    }





    @Test
    public void ValidListAllCommand() throws HealthVaultException {
        Command c;
        c = this.parser.commandHandler("list", staffList);
        assertTrue(c instanceof seedu.logic.command.staff.StaffList);
    }
    @Test
    public void invalidListCommand1() {
        HealthVaultException exception = assertThrows(HealthVaultException.class, () ->
                this.parser.commandHandler("list/ /", staffList));
        assertEquals(exception.getMessage(), "Invalid List command parameter\n" +
                "Please input with the either of the following format:\n\tlist\n\tlist/nurses\n\tlist/doctors");
    }

    @Test
    public void invalidListCommand2() {
        HealthVaultException exception = assertThrows(HealthVaultException.class, () ->
                this.parser.commandHandler("list/invalid/", staffList));
        assertEquals(exception.getMessage(), "Invalid List command parameter\n" +
                "Please input with the either of the following format:\n\tlist\n\tlist/nurses\n\tlist/doctors");
    }

    @Test
    public void invalidListCommand3() {
        HealthVaultException exception = assertThrows(HealthVaultException.class, () ->
                this.parser.commandHandler("list/doctors/invalid/", staffList));
        assertEquals(exception.getMessage(), "OOPS! There are too many inputs for this command");
    }





    @Test
    public void ValidListNurseCommand() throws HealthVaultException {
        Command c;
        c = this.parser.commandHandler("list/nurses", staffList);
        assertTrue(c instanceof seedu.logic.command.staff.StaffList);
    }
    @Test
    public void ValidListDoctorCommand() throws HealthVaultException {
        Command c;
        c = this.parser.commandHandler("list/doctors", staffList);
        assertTrue(c instanceof seedu.logic.command.staff.StaffList);
    }



    @Test
    public void ValidReturnCommand() throws HealthVaultException {
        Command c;
        c = this.parser.commandHandler("return", staffList);
        assertTrue(c instanceof StaffReturn);
    }




    @Test
    public void ValidDeleteCommand() throws HealthVaultException {
        Command c;
        c = this.parser.commandHandler("delete/D12345", staffList);
        assertTrue(c instanceof StaffDelete);
    }

    @Test
    public void invalidDeleteCommand1() {
        HealthVaultException exception = assertThrows(HealthVaultException.class, () ->
                this.parser.commandHandler("delete/D1234/", staffList));
        assertEquals(exception.getMessage(), "Error in Staff ID input\nPlease input with the following format [D/N][5 digit ID number]");
    }





    @Test
    public void ValidFindCommand() throws HealthVaultException {
        Command c;
        c = this.parser.commandHandler("find/D12345", staffList);
        assertTrue(c instanceof StaffFind);
    }
    @Test
    public void ValidFindCommand2() throws HealthVaultException {
        Command c;
        c = this.parser.commandHandler("find/19", staffList);
        assertTrue(c instanceof StaffFind);
    }
    @Test
    public void ValidFindCommand3() throws HealthVaultException {
        Command c;
        c = this.parser.commandHandler("find/Owen", staffList);
        assertTrue(c instanceof StaffFind);
    }

}
