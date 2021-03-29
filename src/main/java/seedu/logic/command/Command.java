package seedu.logic.command;

import seedu.storage.StaffStorage;

import seedu.ui.InventoryUI;
import seedu.ui.DoctorAppointmentUI;
import seedu.ui.NurseScheduleUI;
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

    public void execute (InventoryActions drugs, InventoryUI ui) {
    }

    public void execute (AppointmentActions appointment, DoctorAppointmentUI ui) throws Exception {
    }

    public void execute (NurseScheduleActions nurseSchedule, NurseScheduleUI ui) {
    }

    public abstract boolean isExit();

}
