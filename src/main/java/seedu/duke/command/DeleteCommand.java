package seedu.duke.command;

import seedu.duke.Common;
import seedu.duke.Constants;
import seedu.duke.Data;
import seedu.duke.Ui;
import seedu.duke.exception.DataException;
import seedu.duke.exception.InvalidInputException;
import seedu.duke.exception.StorageException;
import seedu.duke.model.Patient;

import java.time.LocalDate;
import java.util.HashMap;

public class DeleteCommand extends Command {

    /**
     * This is the constructor of the command. Arguments are passed to parent class.
     *
     * @param ui        Instance of Ui class, for UI input/output
     * @param data      Instance of Data class, for manipulating patient list and read/write miscellaneous config
     * @param arguments Arguments decomposed from the full command given by the user
     */
    public DeleteCommand(Ui ui, Data data, HashMap<String, String> arguments) {
        super(ui, data, arguments);
    }

    @Override
    public void execute() throws InvalidInputException, DataException, StorageException {
        boolean isDeletePatient = arguments.containsKey(Constants.PATIENT_KEY);
        boolean isDeleteRecord = arguments.containsKey(Constants.RECORD_KEY);
        boolean neitherSpecified = !isDeletePatient && !isDeleteRecord;
        boolean bothSpecified = isDeletePatient && isDeleteRecord;
        if (neitherSpecified || bothSpecified) {
            throw new InvalidInputException(InvalidInputException.Type.UNKNOWN_DELETE_ARGUMENT);
        }
        if (isDeletePatient) {
            String id = arguments.get(Constants.PATIENT_KEY);
            id = id.toUpperCase();
            deletePatient(id);
        } else {
            String dateString = arguments.get(Constants.RECORD_KEY);
            LocalDate date = Common.parseDate(dateString);
            deleteRecord(date);
        }
        data.saveFile();
    }

    /**
     * Deletes a patient from the list.
     *
     * @param id Unique identifier of the patient to be deleted
     * @throws DataException if the patient to be deleted does not exist
     */
    private void deletePatient(String id) throws DataException {
        data.deletePatient(id);
        ui.printMessage("Patient " + id + " has been deleted!");
    }

    /**
     * Deletes a record a patient's consultation details.
     *
     * @param date date of record that is being deleted
     * @throws DataException if the patient does not have any records from the specified date
     */
    private void deleteRecord(LocalDate date) throws DataException {
        data.deleteRecord(date);
        ui.printMessage("Record for " + Common.formatDate(date) + " has been deleted.");
    }
}
