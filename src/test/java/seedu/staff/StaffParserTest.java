package seedu.staff;

import org.junit.jupiter.api.Test;
import seedu.exceptions.HealthVaultException;
import seedu.logic.command.Command;
import seedu.logic.command.staff.*;
import seedu.logic.parser.StaffParser;
import seedu.model.staff.StaffList;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
        c = this.parser.commandHandler("add/D12345/Owen/20/Surgeon", staffList);
        assertTrue(c instanceof StaffAdd);
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
        c = this.parser.commandHandler("add/D12345/Owen/20/Surgeon", staffList);
        c = this.parser.commandHandler("delete/D12345", staffList);
        assertTrue(c instanceof StaffDelete);
    }

    @Test
    public void ValidFindCommand() throws HealthVaultException {
        Command c;
        c = this.parser.commandHandler("find/D12345", staffList);
        assertTrue(c instanceof StaffFind);
    }
}
