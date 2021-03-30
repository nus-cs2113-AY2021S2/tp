package seedu.duke.command;

import seedu.duke.Constants;
import seedu.duke.Data;
import seedu.duke.Ui;
import seedu.duke.exception.InvalidInputException;
import seedu.duke.model.Patient;
import seedu.duke.model.Record;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Locale;
import java.util.TreeMap;

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

    public void execute() throws InvalidInputException {

        if (arguments.containsKey(Constants.PATIENT_KEY)) {
            String id = arguments.get(Constants.PATIENT_KEY);
            id = id.toUpperCase();
            deletePatient(id);
        }  else if (arguments.containsKey(Constants.RECORD_KEY)) {
            Patient patient = data.currentPatient;
            if (patient == null) {
                throw new InvalidInputException(InvalidInputException.Type.NO_PATIENT_LOADED);
            }
            String date = arguments.get(Constants.RECORD_KEY);
            deleteRecord(patient, date);
        } else {
            ui.printMessage("Please indicate whether to delete patient or record using /p or /r respectively!");
        }
    }

    /**
     * Deletes a patient from the list.
     * @param id Unique identifier of the patient to be retrieved
     */
    private void deletePatient(String id) {
        if (data.getPatient(id) == null) {
            ui.printMessage("Patient does not exist!");
            return;
        }
        data.deletePatient(id);
        ui.printMessage("Patient " + id + " has been deleted!");
    }

    /**
     * Deletes a record a patient's consultation details.
     * @param patient    Patient of record that is being deleted
     * @param dateString Date of record that is being deleted
     * @throws InvalidInputException when an invalid date is given
     */
    private void deleteRecord(Patient patient, String dateString) throws InvalidInputException {
        LocalDate date = null;
        try {
            date = parseDate(dateString);
        } catch (DateTimeParseException dateTimeParseException) {
            throw new InvalidInputException(InvalidInputException.Type.INVALID_DATE);
        }
        if (patient.recordExist(date)) {
            patient.deleteRecord(date);
            ui.printMessage("Record for " + date + " has been deleted!");
        } else {
            ui.printMessage("Record for " + date + " does not exist!");
        }

    }

    private LocalDate parseDate(String dateString) throws DateTimeParseException {
        if (!dateString.isEmpty()) {
            return LocalDate.parse(dateString, DateTimeFormatter.ofPattern(Constants.DATE_PATTERN));
        }
        return LocalDate.now();
    }
}
