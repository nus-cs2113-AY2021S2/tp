package seedu.logic.command;

import seedu.storage.DoctorAppointmentStorage;
import seedu.storage.StaffStorage;
import seedu.ui.PatientUI;
import seedu.ui.StaffUI;

import java.io.IOException;

public abstract class Command {

    public Command() {
    }

    public void execute () {
    }

    public void execute (PatientActions patients, PatientUI ui){
    }

    public void execute(StaffAggregation staff, StaffUI staffUI, StaffStorage staffStorage) throws IOException {
    }

    public void execute (DrugAction inventory) {
    }

    public void execute (AppointmentActions appointment, DoctorAppointmentStorage storage) {
    }

    public void execute (NurseScheduleActions nurseSchedule) {
    }

    public abstract boolean isExit();
}
