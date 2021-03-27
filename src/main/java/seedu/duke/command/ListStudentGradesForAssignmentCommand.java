package seedu.duke.command;

import seedu.duke.Storage;
import seedu.duke.assignment.Assignment;
import seedu.duke.Module;
import seedu.duke.data.Data;
import seedu.duke.exception.ModuleNotFoundException;
import seedu.duke.ui.Ui;

public class ListStudentGradesForAssignmentCommand extends Command {
    public String moduleCode;
    public String assignmentName;

    public ListStudentGradesForAssignmentCommand(String moduleCode, String assignmentName) {
        this.moduleCode = moduleCode;
        this.assignmentName = assignmentName;
    }

    public void execute(Data data, Ui ui, Storage storage) throws ModuleNotFoundException {
        Module module = data.find(moduleCode);
        if (module == null) {
            throw new ModuleNotFoundException();
        }
        Assignment assignmentToBeQueried = module.findAssignment(assignmentName);
        if (assignmentToBeQueried == null) {
            ui.assignmentNotFoundMessage(assignmentName, moduleCode);
        } else {
            ui.listAssignmentStudentGrades(assignmentToBeQueried);
        }
    }
}
