package seedu.logic.command;

import seedu.storage.DoctorAppointmentStorage;
import seedu.ui.PatientUI;

public abstract class Command {

    public Command() {
    }

    public void execute () {
    }

    public void execute (PatientActions patients, PatientUI ui){
    }

    public void execute (StaffActions staff){
    }

    public void execute (DrugAction inventory) {
    }

    public void execute (AppointmentActions appointment, DoctorAppointmentStorage storage) {
    }

    public void execute (NurseScheduleActions nurseSchedule) {
    }

    public abstract boolean isExit();
}
