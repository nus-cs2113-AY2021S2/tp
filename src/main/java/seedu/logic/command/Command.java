package seedu.logic.command;

import seedu.exceptions.nurseschedules.EmptyListException;
import seedu.exceptions.nurseschedules.NurseIdNotFound;
import seedu.storage.DoctorAppointmentStorage;
import seedu.ui.NurseScheduleUI;
import seedu.ui.PatientUI;

import java.text.ParseException;

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

    public void execute (NurseScheduleActions nurseSchedule, NurseScheduleUI ui) {
    }

    public abstract boolean isExit();
}
