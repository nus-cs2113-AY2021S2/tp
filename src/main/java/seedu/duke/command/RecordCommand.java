package seedu.duke.command;

import seedu.duke.Data;
import seedu.duke.Ui;
import seedu.duke.exception.InvalidInputException;
import seedu.duke.model.Patient;
import seedu.duke.model.Record;

import java.util.HashMap;

public class RecordCommand extends Command {
    /**
     * This is the constructor of the command. Arguments are passed to parent class.
     *
     * @param ui        Instance of Ui class, for UI input/output
     * @param data      Instance of Data class, for manipulating patient list and read/write miscellaneous config
     * @param arguments Arguments decomposed from the full command given by the user
     */
    public RecordCommand(Ui ui, Data data, HashMap<String, String> arguments) {
        super(ui, data, arguments);
    }

    @Override
    public void execute() throws Exception {
        assert ui != null : "Ui must not be null";
        assert arguments.containsKey("payload") : "Arguments must contain a value for the `payload` key";
        Patient patient = data.currentPatient;
        if (patient == null) {
            throw new InvalidInputException(InvalidInputException.Type.NO_PATIENT_LOADED);
        }
        if (arguments.get("payload").length() == 0) {
            throw new InvalidInputException(InvalidInputException.Type.EMPTY_DESCRIPTION);
        }
        String consultationDetail = arguments.get("payload");
        Record record = new Record(consultationDetail);
        patient.addRecord(record);
        ui.printMessage("Added new record: " + record.toString());
    }
}
