package seedu.duke.command;

import seedu.duke.Common;
import seedu.duke.Constants;
import seedu.duke.Data;
import seedu.duke.Ui;
import seedu.duke.exception.DataException;
import seedu.duke.exception.InvalidInputException;
import seedu.duke.model.Patient;
import seedu.duke.model.Record;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class RetrieveCommand extends Command {

    /**
     * This is the constructor of the command. Arguments are passed to parent class.
     *
     * @param ui        Instance of Ui class, for UI input/output
     * @param data      Instance of Data class, for manipulating patient list and read/write miscellaneous config
     * @param arguments Arguments decomposed from the full command given by the user
     */
    public RetrieveCommand(Ui ui, Data data, HashMap<String, String> arguments) {
        super(ui, data, arguments);
    }

    @Override
    public void execute() throws InvalidInputException, DataException {
        assert ui != null : "Ui must not be null";
        assert arguments.containsKey("payload") : "Arguments must contain a value for the `payload` key";
        String records = null;
        String dateString = arguments.get(Constants.PAYLOAD_KEY);
        if (dateString.isEmpty()) {
            records = data.getRecords();
        }
        else {
            LocalDate date = Common.parseDate(dateString);
            records = data.getRecords(date);
        }
        assert records != null : "Data class must not return a null value for the patient's records";
        ui.printMessage(records);
    }

}
